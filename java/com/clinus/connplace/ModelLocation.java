package com.clinus.connplace;

public class ModelLocation {

    private static double latitude;
    private static double longitude;
    private int idUser;

    public ModelLocation(int idUser) {

        this.idUser = idUser;
    }

    public static double getLatitude() {
        return latitude;
    }

    public static void setLatitude(double latitude) {
        ModelLocation.latitude = latitude;
    }

    public static double getLongitude() {
        return longitude;
    }

    public static void setLongitude(double longitude) {
        ModelLocation.longitude = longitude;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}