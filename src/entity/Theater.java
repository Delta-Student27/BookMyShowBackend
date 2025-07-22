package entity;

public class Theater {
    private int theaters_Id;
    private String name;
    private String city;

    public Theater(int theater_Id, String name, String city) {
        this.theaters_Id = theaters_Id;
        this.name = name;
        this.city = city;
    }

    public int getTheaterId() {
        return theaters_Id;
    }

    public void setTheaterId(int theater_Id) {
        this.theaters_Id = theater_Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
