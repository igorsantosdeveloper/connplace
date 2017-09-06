package com.clinus.connplace;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity{

    private ListView users;
    ToLocate locate = new ToLocate(this);
    private static String nameUser;
    private static boolean updatingList;

    public static boolean isUpdatingList() {
        return updatingList;
    }

    public static void setUpdatingList(boolean updatingList) {
        HomeActivity.updatingList = updatingList;
    }

    public static String getNameUser() {
        return nameUser;
    }

    public static void setNameUser(String nameUser) {
        HomeActivity.nameUser = nameUser;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        users = (ListView) findViewById(R.id.home_listuser);
        createList();
        /*new Thread(){
            public void run(){

                while(true){

                    locate.overlapLocation();
                    createList();
                    try {
                        sleep(1000 * 10);//Para por 10 segundos
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();*/
    }

    private ArrayList<String> prepareUserList(){

        double distance = 0;
        ToLocate locate = new ToLocate();
        ServiceController controller = new ServiceController();
        DynamicCreateQuery sql = new DynamicCreateQuery();
        List<BringsLocation> locations = controller.bringsLocations();
        ArrayList<Integer> id_s = new ArrayList<>();
        BringsCoordinates coordinates = controller.bringsCoordinates(controller.getUserId(nameUser));
        for(BringsLocation location : locations){

            distance = locate.calculateDistance(
                    coordinates.getLatitude(),
                    coordinates.getLongitude(),
                    location.getLatitude(),
                    location.getLongitude()
            );
            if(distance <= 1000){
                id_s.add(location.getUser_id());
            }
        }
        DynamicQuery dynamicQuery = new DynamicQuery(sql.createUserListQuery(id_s));
        ArrayList<String>users = new ArrayList<>();
        List<ForwardListOfUsers> listUsers = new ArrayList<>();
        listUsers = controller.forwardListOfUsers(dynamicQuery);
        if(dynamicQuery.getForwardListOfUsers() != null) {
            for (ForwardListOfUsers user : listUsers) {

                users.add(user.getNameUser());
            }
        }
        return users;
    }

    public void createList(){

        ArrayList<String> listUsers = prepareUserList();
        listUsers.remove(nameUser);
        if(listUsers != null) {
            ArrayAdapter<String> adapterUsers =
                    new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listUsers);
            users.setAdapter(adapterUsers);
        }
    }

    private  Runnable t1 = new Runnable() {
        public void run() {

            createList();
        }
    };
}
