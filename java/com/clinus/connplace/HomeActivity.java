package com.clinus.connplace;

import android.content.pm.PackageManager;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity{

    private ListView users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        users = (ListView) findViewById(R.id.home_listuser);
        CCplaceTest dao = new CCplaceTest(HomeActivity.this);
        ArrayAdapter<String> adapterUsers =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dao.getUsers());
        users.setAdapter(adapterUsers);
    }
}
