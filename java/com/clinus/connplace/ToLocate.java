package com.clinus.connplace;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class ToLocate {

    private Context context;
    private String userloggedIn;
    private FusedLocationProviderClient mFusedLocationClient;
    private static boolean updatingList = false;

    public ToLocate(Context context) {

        this.context = context;
    }

    public ToLocate(){}

    public static void setUpdatingList(boolean updatingList){ ToLocate.updatingList = updatingList; }

    public static boolean isUpdatingList(){ return ToLocate.updatingList; }

    public void bringLocation() {

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(context);
        if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mFusedLocationClient.getLastLocation()
                .addOnSuccessListener((Activity) context, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {

                            Controller action = new Controller();
                            userloggedIn = RegisterActivity.getUser();
                            ModelLocation modelLocation = new ModelLocation(action.getIdUser(context,userloggedIn.toUpperCase()));
                            if(!HomeActivity.isLoggingIn()) {

                                ModelLocation.setUserLatitude(location.getLatitude());
                                ModelLocation.setUserLongitude(location.getLongitude());
                                action.newLocation(context, modelLocation);
                            }else{

                                if(ModelLocation.getUserLongitude() != location.getLongitude() ||
                                        ModelLocation.getUserLatitude() != location.getLatitude()) {

                                    ModelLocation.setUserLatitude(location.getLatitude());
                                    ModelLocation.setUserLongitude(location.getLongitude());
                                    action.overlapLocation(context, modelLocation);
                                    updatingList = false;
                                }
                            }
                        }
                    }
                });
    }

    public double calculateDistance(double latitude_1, double longitude_1, double latitude_2, double longitude_2 ){

        double r = 6371.0;
        double dLat = 0;
        double dLon = 0;
        double a = 0;
        double c = 0;
        latitude_1 = Math.PI / 180.0;
        longitude_1 = Math.PI / 180.0;
        latitude_2 = Math.PI / 180.0;
        longitude_2 = Math.PI / 180.0;
        if(latitude_1 > latitude_2){

            dLat = latitude_1 - latitude_2;
        }else{

            dLat = latitude_2 - latitude_1;
        }
        if(longitude_1 > longitude_2){

            dLat = longitude_1 - longitude_2;
        }else{

            dLat = longitude_2 - longitude_1;
        }
        a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.cos(latitude_1) * Math.cos(latitude_2)
                * Math.sin(dLon / 2);
        c = Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return Math.round(r * c * 1000);
    }


}
