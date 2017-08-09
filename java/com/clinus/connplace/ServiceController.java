package com.clinus.connplace;

import android.os.StrictMode;

import java.util.List;

public class ServiceController {

    private ClientService service;

    public ServiceController(){

        service = new ClientService();
    }

    //User
    public boolean newUser(ModelUser user){

        if(android.os.Build.VERSION.SDK_INT > 9){
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        return service.newUser(user);
    }

    public boolean authenticateUser(String nameUser, String passwordUser){

        if(android.os.Build.VERSION.SDK_INT > 9){
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        return service.authenticateUser(nameUser,passwordUser);
    }

    public boolean checkNameUser(String nameUser){

        if(android.os.Build.VERSION.SDK_INT > 9){
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        return service.checkNameUser(nameUser);
    }

    public int getUserId(String nameUser){

        if(android.os.Build.VERSION.SDK_INT > 9){
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        return service.getUserId(nameUser);
    }
    //End User

    //Location
    public boolean newLocation(ModelLocation location){

        if(android.os.Build.VERSION.SDK_INT > 9){
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        return service.newLocation(location);
    }

    public boolean overlapLocation(ModelLocation location){

        if(android.os.Build.VERSION.SDK_INT > 9){
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        return service.overlapLocation(location);
    }

    public List<BringsLocation> bringsLocations(){

        if(android.os.Build.VERSION.SDK_INT > 9){
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        return service.bringsLocations();
    }

    public List<ForwardListOfUsers> forwardListOfUsers(DynamicQuery dynamicQuery){

        if(android.os.Build.VERSION.SDK_INT > 9){
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        return service.forwardListOfUsers(dynamicQuery);
    }

    public BringsCoordinates bringsCoordinates(int idUser){

        if(android.os.Build.VERSION.SDK_INT > 9){
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        ClientService service = new ClientService();
        return service.bringsCoordinates(idUser);
    }
    //End Location
}
