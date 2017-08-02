package com.clinus.connplace;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ClientService {

    //User
    public boolean newUser(ModelUser user) {

        HttpClient httpClient = new DefaultHttpClient();
        Gson gson = new Gson();
        try{

            HttpPost request = new HttpPost(ServiceHost.serviceHost + "user");
            StringEntity params = new StringEntity(gson.toJson(user));
            request.addHeader("content-type","application/json");
            request.addHeader("Accept","application/json");
            request.setEntity(params);
            HttpResponse response = httpClient.execute(request);
            return true;
        }catch (Exception e){

            e.printStackTrace();
            return false;
        }finally {

            httpClient.getConnectionManager().shutdown();
        }
    }

    public boolean authenticateUser(String nameUser, String passwordUser){

        HttpClient httpClient = new DefaultHttpClient();
        try{

            HttpGet request = new HttpGet(
                    ServiceHost.serviceHost + "user/authenticateUser" +
                    "?" + "nameUser=" + nameUser + "&" + "passwordUser=" + passwordUser);
            request.addHeader("content-type","application/json");
            request.addHeader("Accept","application/json");
            HttpResponse response = httpClient.execute(request);
            String json = EntityUtils.toString(response.getEntity());
            Gson gson = new Gson();
            ModelUser user = gson.fromJson(json, ModelUser.class);
            if(user.getId() > -1){

                return true;
            }else{

                return false;
            }
        }catch (Exception e){

            e.printStackTrace();
            return false;
        }finally {

            httpClient.getConnectionManager().shutdown();
        }
    }

    public boolean checkNameUser(String nameUser){

        HttpClient httpClient = new DefaultHttpClient();
        try{

            HttpGet request = new HttpGet(
                    ServiceHost.serviceHost + "user/checkNameUser" +
                            "?" + "nameUser=" + nameUser);
            request.addHeader("content-type","application/json");
            request.addHeader("Accept","application/json");
            HttpResponse response = httpClient.execute(request);
            String json = EntityUtils.toString(response.getEntity());
            Gson gson = new Gson();
            ModelUser user = gson.fromJson(json, ModelUser.class);
            if(user.getId() > -1){

                return true;
            }else{

                return false;
            }
        }catch (Exception e){

            e.printStackTrace();
            return false;
        }finally {

            httpClient.getConnectionManager().shutdown();
        }
    }
    //End User

    //Location
    public boolean newLocation(ModelLocation location) {

        HttpClient httpClient = new DefaultHttpClient();
        Gson gson = new Gson();
        try{

            HttpPost request = new HttpPost(ServiceHost.serviceHost + "location");
            StringEntity params = new StringEntity(gson.toJson(location));
            request.addHeader("content-type","application/json");
            request.addHeader("Accept","application/json");
            request.setEntity(params);
            HttpResponse response = httpClient.execute(request);
            return true;
        }catch (Exception e){

            e.printStackTrace();
            return false;
        }finally {

            httpClient.getConnectionManager().shutdown();
        }
    }

    public boolean overlapLocation(ModelLocation location) {

        HttpClient httpClient = new DefaultHttpClient();
        Gson gson = new Gson();
        try{

            HttpPost request = new HttpPost(ServiceHost.serviceHost + "location/overlapLocation");
            StringEntity params = new StringEntity(gson.toJson(location));
            request.addHeader("content-type","application/json");
            request.addHeader("Accept","application/json");
            request.setEntity(params);
            HttpResponse response = httpClient.execute(request);
            return true;
        }catch (Exception e){

            e.printStackTrace();
            return false;
        }finally {

            httpClient.getConnectionManager().shutdown();
        }
    }

    public boolean bringsLocations() {

        HttpClient httpClient = new DefaultHttpClient();
        Gson gson = new Gson();
        try{

            HttpGet request = new HttpGet(ServiceHost.serviceHost + "location/bringsLocations");
            request.addHeader("content-type","application/json");
            request.addHeader("Accept","application/json");
            HttpResponse response = httpClient.execute(request);
            String json = EntityUtils.toString(response.getEntity());
            Type type = new TypeToken<ArrayList<BringsLocation>>(){}.getType();
            List<BringsLocation> locations = gson.fromJson(json, type);
            return true;
        }catch (Exception e){

            e.printStackTrace();
            return false;
        }finally {

            httpClient.getConnectionManager().shutdown();
        }
    }

    public boolean forwardListOfUsers(DynamicQuery dynamicQuery) {

        HttpClient httpClient = new DefaultHttpClient();
        Gson gson = new Gson();
        try{

            HttpPost request = new HttpPost(ServiceHost.serviceHost + "location/forwardListOfUsers");
            StringEntity params = new StringEntity(gson.toJson(dynamicQuery));
            request.addHeader("content-type","application/json");
            request.addHeader("Accept","application/json");
            request.setEntity(params);
            HttpResponse response = httpClient.execute(request);
            String json = EntityUtils.toString(response.getEntity());
            Type type = new TypeToken<ArrayList<ForwardListOfUsers>>(){}.getType();
            List<ForwardListOfUsers> users = gson.fromJson(json, type);
            for(ForwardListOfUsers user : users){

                System.out.println(user);
            }
            return true;
        }catch (Exception e){

            e.printStackTrace();
            return false;
        }finally {

            httpClient.getConnectionManager().shutdown();
        }
    }
    //End Location
}












