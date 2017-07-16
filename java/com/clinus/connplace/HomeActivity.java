package com.clinus.connplace;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private ListView users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        users = (ListView) findViewById(R.id.home_listuser);
        CCplaceTest dao = new CCplaceTest(HomeActivity.this);
        ArrayAdapter<String> adapterUsers =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,dao.getUsers());
        users.setAdapter(adapterUsers);
    }
}
