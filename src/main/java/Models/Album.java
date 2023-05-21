package Models;

import java.io.Serializable;

public class Album implements Serializable {

    private long id;
    private String artist;
    private String recordName;
    private int releaseDate;

    private double sales;

    private String genre;


    public Album(long id, String artist, String recordName, int releaseDate, double sales, String genre) {
        this.id = id;
        this.artist = artist;
        this.recordName = recordName;
        this.releaseDate = releaseDate;
        this.sales = sales;
        this.genre = genre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getRecordName() {
        return recordName;
    }

    public void setRecordName(String recordName) {
        this.recordName = recordName;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getSales() {
        return sales;
    }

    public void setSales(double sales) {
        this.sales = sales;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
