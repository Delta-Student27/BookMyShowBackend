package entity;

public class Movie
{
    private int moives_Id;
    private String title;
    private String genre;
    private  String lang;
    private  int duration;

    public Movie(int moiveId, String title, String genre, String lang, int duration) {
        this.moives_Id = moiveId;
        this.title = title;
        this.genre = genre;
        this.lang = lang;
        this.duration = duration;
    }

    public int getMoiveId() {
        return moives_Id;
    }

    public void setMoiveId(int moiveId) {
        this.moives_Id = moiveId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
