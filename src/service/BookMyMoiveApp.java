package service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class BookMyMoiveApp {
    public static void main(String[] args)
    {
        BookMyMovieSys mbs = new BookMyMovieSys();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter city:");
        String city=sc.next();
        mbs.displayTheaters(city);

        System.out.println("Enter Theater Id and Movie Id:");
        int theaters_Id = sc.nextInt();
        int movies_Id = sc.nextInt();
        mbs.displayShows(movies_Id,theaters_Id);

        System.out.println("Enter show Id:");
        int show_Id = sc.nextInt();

        System.out.println("Enter number of seats to book:");
        int numberOfSeats = sc.nextInt();

        List<String> selectedSeats = new ArrayList<>();
        System.out.println("Enter seat numbers (e.g., A1 A2 B1 ...):");
        for (int i = 0; i < numberOfSeats; i++) {
            selectedSeats.add(sc.next());
        }

        mbs.bookTicket(1, show_Id, selectedSeats);

    }
}
