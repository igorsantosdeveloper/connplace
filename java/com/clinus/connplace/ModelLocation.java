package com.clinus.connplace;

public class ModelLocation {

    private static double userLatitude;
    private static double userLongitude;
    private double latitude;
    private double longitude;
    private int idUser;

    public ModelLocation(int idUser) {

        this.idUser = idUser;
    }

    public ModelLocation(double latitude, double longitude, int idUser){

        this.latitude = latitude;
        this.longitude = longitude;
        this.idUser = idUser;
    }

    public static double getUserLatitude() {
        return ModelLocation.userLatitude;
    }

    public static void setUserLatitude(double userLatitude) {
        ModelLocation.userLatitude = userLatitude;
    }

    public static double getUserLongitude() {
        return ModelLocation.userLongitude;
    }

    public static void setUserLongitude(double userLongitude) {
        ModelLocation.userLongitude = userLongitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public int getIdUser() {
        return idUser;
    }

    @Override
    public String toString() {
        return "ModelLocation{" +
                "latitude=" + userLatitude +
                ", longitude=" + userLongitude +
                ", idUser=" + idUser +
                '}';
    }
}
