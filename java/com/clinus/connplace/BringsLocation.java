package com.clinus.connplace;

public class BringsLocation {

    private double latitude;
    private double longitude;
    private int user_id;

    public BringsLocation(){}

    public BringsLocation(double latitude, double longitude, int user_id) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.user_id = user_id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "BringsLocation{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", user_id=" + user_id +
                '}';
    }
}
