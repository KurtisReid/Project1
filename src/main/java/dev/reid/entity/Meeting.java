package dev.reid.entity;

public class Meeting {
    private int id;

    private String location;

    private String date;

    public Meeting(int id, String location, String date) {
        this.id = id;
        this.location = location;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
