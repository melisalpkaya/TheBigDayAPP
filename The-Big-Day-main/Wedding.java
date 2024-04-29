package com.myfirstapplication.mobileproject;

public class Wedding {
    private String location;
    private String date;
    private String hour;
    private String coupleName;

    public Wedding(String location,String hour, String date, String coupleName) {
        this.location = location;
        this.hour = hour;
        this.date = date;
        this.coupleName = coupleName;
    }

    public Wedding() {
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

    public String getCoupleName() {
        return coupleName;
    }

    public void setCoupleName(String coupleName) {
        this.coupleName = coupleName;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    @Override
    public String toString() {
        return "Wedding{" +
                "location='" + location + '\'' +
                ", date='" + date + '\'' +
                ", coupleName='" + coupleName + '\'' +
                '}';
    }
}
