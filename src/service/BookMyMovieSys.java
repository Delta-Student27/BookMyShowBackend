package service;
import config.DataBaseConfig;

import java.sql.*;
import java.util.List;
import java.util.Scanner;
public class BookMyMovieSys {
    Scanner sc = new Scanner(System.in);

    //display moives
    public void displayMovies()
    {
        try
        {
            Connection con = DataBaseConfig.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from moives");
            System.out.println("-----------Available Movies-----------");
            while (rs.next()) {
                System.out.println(rs.getInt("movies_id") + ". " + rs.getString("title") + "(" + rs.getString("gener") + ")");
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    //show theater in cities

    public void displayTheaters(String city) {
        try {
            Connection con = DataBaseConfig.getConnection();
            PreparedStatement stmt = con.prepareStatement("select * from theaters where city = ?");
            stmt.setString(1, city);
            ResultSet rs = stmt.executeQuery();

            System.out.println("Theaters in " + city + ":");
            while (rs.next()) {
                System.out.println(rs.getInt("theaters_Id") + "." + rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //shows display
    public void displayShows(int movies_Id, int theaters_Id) {
        try {
            Connection con = DataBaseConfig.getConnection();
            PreparedStatement stmt =
                    con.prepareStatement("select * from shows where movies_id= ? AND theaters_id=?");
            stmt.setInt(1, movies_Id);
            stmt.setInt(2, theaters_Id);
            ResultSet rs = stmt.executeQuery();
            System.out.println("Available Shows");
            while (rs.next()) {
                System.out.println(rs.getInt("movies_id") + ". " + rs.getString("timing") + "- Seats Available: " + rs.getString("available_seat"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Book Ticket
    public void bookTicket(int userId, int show_Id, List<String> selectedSeats) {
        try {
            Connection con = DataBaseConfig.getConnection();
            con.setAutoCommit(false);

            //check if seats are available
            boolean alreadyBookedSeat = false;
            for (String seat : selectedSeats) {
                PreparedStatement stmt = con.prepareStatement("select * from seat where seat_number = ? and show_Id=?");
                stmt.setString(1, seat);
                stmt.setInt(2, show_Id);
                ResultSet rs = stmt.executeQuery();
                if (rs.next() && rs.getBoolean("is_booked")) {
                    alreadyBookedSeat = true;
                    System.out.println("seat " + seat + " is already booked. Choose another seat ");
                }
            }
            if (alreadyBookedSeat) {
                System.out.println("Booking Failed ! Some seats are already Booked.");
                con.rollback();
                return;
            }
            for (String seat : selectedSeats) {
                PreparedStatement stmt = con.prepareStatement("update seat set is_booked=TRUE where seat_number=? AND show_id=?");
                stmt.setString(1, seat);
                stmt.setInt(2, show_Id);
                stmt.executeUpdate();
            }
            double seatPrice=200.0;
            double tp = selectedSeats.size()*seatPrice;

            PreparedStatement stmt=
                    con.prepareStatement("insert into bookings(user_id,show_id,seats_booked,total_price) values(?,?,?,?)");
            stmt.setInt(1,userId);
            stmt.setInt(2,show_Id);
            stmt.setString(3,String.join(",",selectedSeats));
            stmt.setDouble(4,tp);
            stmt.executeUpdate();
            con.commit();
            System.out.println("Booking Successful !! seats:"+selectedSeats+"|Total Price:"+tp);

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }
}