package com.clinus.connplace;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity{

    private ListView users;
    private static boolean loggingIn;
    ToLocate locate = new ToLocate(this);

    public static void setLoggingIn(boolean loggingIn){

        HomeActivity.loggingIn = loggingIn;
    }

    public static boolean isLoggingIn(){ return HomeActivity.loggingIn; }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        loggingIn = true;
        createList();
        new Thread(t1).start();
    }

    private ArrayList<String> prepareUserList(){

        double distance = 0;
        ToLocate locate = new ToLocate();
        Controller action = new Controller();
        DynamicCreateQuery sql = new DynamicCreateQuery();
        ArrayList<ModelLocation> locations = action.bringsLocations(this);
        ArrayList<Integer> id_s = new ArrayList<>();
        for(ModelLocation location : locations){

            distance = locate.calculateDistance(
                    ModelLocation.getUserLatitude(),
                    ModelLocation.getUserLongitude(),
                    location.getLatitude(),
                    location.getLongitude()
            );
            if(distance <= 1000){
                id_s.add(location.getIdUser());
            }
        }
        String query = sql.createUserListQuery(id_s);
        return action.forwardListOfUsers(this,query);
    }

    private void createList(){

        users = (ListView) findViewById(R.id.home_listuser);
        ArrayAdapter<String> adapterUsers =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, prepareUserList());
        users.setAdapter(adapterUsers);
    }

    private  Runnable t1 = new Runnable() {
        public void run() {

            while(true) {

                locate.bringLocation();
                if(ToLocate.isUpdatingList()){

                   createList();
                }
            }
        }
    };
}
