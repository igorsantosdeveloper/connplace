package com.clinus.connplace;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity {

    private ListView days;
    private ListView months;
    private ListView years;
    private Button btnDay;
    private Button btnMonth;
    private Button btnYear;
    private Button btnRegister;
    private TextView txtDay;
    private TextView txtMonth;
    private TextView txtYear;
    private RadioButton rbSexM;
    private RadioButton rbSexF;
    private EditText editUserName;
    private EditText editPassword;
    private EditText editConfirmPassword;
    private String sex = "";
    private String[] strMonths = {

            "Janeiro",
            "Fevereiro",
            "Março",
            "Abril",
            "Maio",
            "Junho",
            "Julho",
            "Agosto",
            "Setembro",
            "Outubro",
            "Novembro",
            "Dezembro"
    };
    private String[] strDays = new String[31];
    private String[] strYears = new String[100];
    private final Message msg = new Message();
    private static String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        createElements();
        rbSexM.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                rbSexF.setSelected(false);
                rbSexM.setSelected(true);
                rbSexF.setChecked(false);
                sex = rbSexM.getText().toString();
            }
        });
        rbSexF.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                rbSexM.setSelected(false);
                rbSexF.setSelected(true);
                rbSexM.setChecked(false);
                sex = rbSexF.getText().toString();
            }
        });
        btnDay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                months.setVisibility(View.INVISIBLE);
                years.setVisibility(View.INVISIBLE);
                days.setVisibility(View.VISIBLE);
            }
        });
        btnMonth.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                days.setVisibility(View.INVISIBLE);
                years.setVisibility(View.INVISIBLE);
                months.setVisibility(View.VISIBLE);
            }
        });
        btnYear.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                days.setVisibility(View.INVISIBLE);
                months.setVisibility(View.INVISIBLE);
                years.setVisibility(View.VISIBLE);
            }
        });
        days.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                txtDay.setText(((TextView) view).getText().toString());
                days.setVisibility(View.INVISIBLE);
            }
        });
        months.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                txtMonth.setText(((TextView) view).getText().toString());
                months.setVisibility(View.INVISIBLE);
            }
        });
        years.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                txtYear.setText(((TextView) view).getText().toString());
                years.setVisibility(View.INVISIBLE);
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (!validateDate(txtDay.getText().toString(), txtMonth.getText().toString())) {

                    showInvalid(msg.getInvalidDate());
                } else if (!editPassword.getText().toString().equals(editConfirmPassword.getText().toString())) {

                    showInvalid(msg.getPasswordsDoNotMatch());
                } else if (editUserName.getText().toString().equals("") ||
                        !rbSexF.isChecked() &&
                                !rbSexM.isChecked() ||
                        editPassword.getText().toString().equals("")) {

                    showInvalid(msg.getNullFields());
                } else if (validateNameUser(editUserName.getText().toString())) {

                    showInvalid(msg.getInvalidCaracter());
                } else if (editPassword.getText().toString().length() < 5) {

                    showInvalid(msg.getWeakPassword());
                } else {

                    Controller action = new Controller();
                    if (action.checkNameUser(RegisterActivity.this, editUserName.getText().toString()) == -1) {

                        finishRegistration();
                    } else {

                        showInvalid(msg.getExistingUser());
                    }
                }
            }
        });
    }

    public static String getUser(){ return user; }

    public void createElements(){

        days = (ListView) findViewById(R.id.register_listday);
        months = (ListView) findViewById(R.id.register_listmonth);
        years = (ListView) findViewById(R.id.register_listyear);
        btnDay = (Button) findViewById(R.id.register_btnday);
        btnMonth = (Button) findViewById(R.id.register_btnmonth);
        btnYear = (Button) findViewById(R.id.register_btnyear);
        btnRegister = (Button) findViewById(R.id.register_btnregister);
        txtDay = (TextView) findViewById(R.id.register_txtday);
        txtMonth = (TextView) findViewById(R.id.register_txtmonth);
        txtYear = (TextView) findViewById(R.id.register_txtyear);
        rbSexM = (RadioButton) findViewById(R.id.register_radiosexm);
        rbSexF = (RadioButton) findViewById(R.id.register_radiosexf);
        editUserName = (EditText) findViewById(R.id.register_editusername);
        editPassword = (EditText) findViewById(R.id.register_editpassword);
        editConfirmPassword = (EditText) findViewById(R.id.register_editconrfirmpassword);
        ArrayAdapter<String> adapterDays = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,strDays);
        days.setAdapter(adapterDays);
        ArrayAdapter<String> adapterMonths = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,strMonths);
        months.setAdapter(adapterMonths);
        ArrayAdapter<String> adapterYears = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,strYears);
        years.setAdapter(adapterYears);
        for(int i = 0;i < strDays.length;i++){

            String str;
            if(i < 9) {

                str = "0";
            }else{

                str = "";
            }
            str += i+1;
            strDays[i] = str;
        }
        Calendar cal = Calendar.getInstance();
        int intYear = cal.get(Calendar.YEAR);
        for(int i = 0;i < strYears.length;i++){

            String strYear = "";
            strYear += intYear;
            strYears[i] = strYear;
            intYear--;
        }
    }

    public boolean validateDate(String day,String month){

        if(     day.equals("30") && month.equals("Fevereiro") ||
                day.equals("31") && month.equals("Fevereiro") ||
                day.equals("31") && month.equals("Abril")     ||
                day.equals("31") && month.equals("Junho")     ||
                day.equals("31") && month.equals("Setembro")  ||
                day.equals("31") && month.equals("Novembro")) {

            return false;
        }
        return true;
    }

    public boolean validateNameUser(String name){

        String invalidCaracters[] = {"'","!","#","$","%","¢","¬","&","*",
                "(",")","-","+","=","§","{","[","ª",
                "}","]","º",",",".","<",">",";",":",
                "|","/","?","°","Ã","Â","Á","À","Ẽ",
                "Ê","É","È","Ĩ","Î","Í","Ì","Õ","Ô",
                "Ó","Ò","Ũ","Û","Ú","Ù"," "};
        for(int i = 0;i < invalidCaracters.length;i++){

            if(name.contains(invalidCaracters[i])){

                return true;
            }
        }
        return false;
    }

    public int getAge(int day, int month, int year){

        Calendar cal = Calendar.getInstance();
        int calDay = cal.get(Calendar.DAY_OF_MONTH);
        int calMonth = cal.get(Calendar.MONTH);
        int calYear = cal.get(Calendar.YEAR);
        int age = 0;
        if(month > calMonth){

            age = calYear - year - 1;
        }else if(month < calMonth){

            age = calYear - year;
        }else{

            if(day > calDay){

                age = calYear - year - 1;
            }else{

                age = calYear - year;
            }
        }
        return age;
    }

    public int getMonth(){

        int month = 0;
        for(int i = 0;i < strMonths.length;i++){

            if(txtMonth.getText().toString().equals(strMonths[i])){

                month = i + 1;
            }
        }

        return month;
    }

    public void showInvalid(String str){

        AlertDialog.Builder alert = new AlertDialog.Builder(RegisterActivity.this);
        alert.setTitle(str);
        alert.setMessage(msg.getAttentionMessage());
        alert.setPositiveButton(msg.getOk(), null);
        alert.create();
        alert.show();

    }

    public void mountNewUser(){

        String dateOfBirth =    txtDay.getText().toString() + "/" +
                getMonth() + "/" +
                txtYear.getText().toString();
        int age = getAge(   Integer.parseInt(txtDay.getText().toString()),
                getMonth(),
                Integer.parseInt(txtYear.getText().toString()));
        String strAge = "" + age;
        Controller action = new Controller();
        action.newUser(  RegisterActivity.this,
                editUserName.getText().toString(),
                editPassword.getText().toString(),
                strAge,
                dateOfBirth,
                sex);
    }

    public void finishRegistration(){

        user = editUserName.getText().toString().toUpperCase();
        mountNewUser();
        transfer();
    }

    public void transfer(){

        ToLocate locate = new ToLocate(this);
        locate.bringLocation();
        HomeActivity.setLoggingIn(false);
        Intent home = new Intent(RegisterActivity.this, HomeActivity.class);
        startActivity(home);
    }
}








