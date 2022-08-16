package dev.reid.entity;

public class Meeting {
    private int id;

    private String location;

    private int time;

    private String summary;

    public Meeting(int id, String location, int date) {
        this.id = id;
        this.location = location;
        this.time = date;
    }

    public Meeting() {

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

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", date='" + time + '\'' +
                '}';
    }
}
