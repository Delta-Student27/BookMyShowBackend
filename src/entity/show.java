package entity;

public class show {
    private int showId;
    private int moviesId;
    private int theaterId;
    private String timing;
    private int availableSeats;

    public show(int showId, int moviesId, int theaterId, String timing, int availableSeats) {
        this.showId = showId;
        this.moviesId = moviesId;
        this.theaterId = theaterId;
        this.timing = timing;
        this.availableSeats = availableSeats;
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public int getMovisId() {
        return moviesId;
    }

    public void setMovisId(int movisId) {
        this.moviesId = movisId;
    }

    public int getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(int theaterId) {
        this.theaterId = theaterId;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
}
