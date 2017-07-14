package com.clinus.connplace;

import android.content.Intent;
import android.os.Bundle;
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

import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity {

    ListView days;
    ListView months;
    ListView years;
    Button btnDay;
    Button btnMonth;
    Button btnYear;
    Button btnRegister;
    TextView txtDay;
    TextView txtMonth;
    TextView txtYear;
    RadioButton rbSexM;
    RadioButton rbSexF;
    EditText editUserName;
    EditText editPassword;
    EditText editConfirmPassword;
    String sex = "";
    String [] strMonths =  {
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
    String [] strDays = new String [31];
    String [] strYears = new String[100];

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Calendar cal = Calendar.getInstance();
        int intYear = cal.get(Calendar.YEAR);
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
        for(int i = 0;i < strYears.length;i++){

            String strYear = "";
            strYear += intYear;
            strYears[i] = strYear;
            intYear--;
        }
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
        rbSexM.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

                rbSexF.setSelected(false);
                rbSexM.setSelected(true);
                rbSexF.setChecked(false);
                sex = rbSexM.getText().toString();
            }
        });
        rbSexF.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

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
        btnYear.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

                days.setVisibility(View.INVISIBLE);
                months.setVisibility(View.INVISIBLE);
                years.setVisibility(View.VISIBLE);
            }
        });
        days.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,long id){

                txtDay.setText(((TextView) view).getText().toString());
                days.setVisibility(View.INVISIBLE);
            }
        });
        months.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){

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
            public void onClick(View view){

                if(!validateDate(txtDay.getText().toString(),txtMonth.getText().toString())){

                    AlertDialog.Builder alert = new AlertDialog.Builder(RegisterActivity.this);
                    alert.setTitle("Atenção");
                    alert.setMessage("Data inválida!");
                    alert.setPositiveButton("OK", null);
                    alert.create();
                    alert.show();
                }else if(!editPassword.getText().toString().equals(editConfirmPassword.getText().toString())){

                    AlertDialog.Builder alert = new AlertDialog.Builder(RegisterActivity.this);
                    alert.setTitle("Atenção");
                    alert.setMessage("As senhas não conferem");
                    alert.setPositiveButton("OK", null);
                    alert.create();
                    alert.show();
                }else if(editUserName.getText().toString().equals("") ||
                         rbSexF.getText().toString().equals("") &&
                         rbSexM.getText().toString().equals("") ||
                         editPassword.getText().toString().equals("")){

                    AlertDialog.Builder alert = new AlertDialog.Builder(RegisterActivity.this);
                    alert.setTitle("Atenção");
                    alert.setMessage("campos nulos");
                    alert.setPositiveButton("OK", null);
                    alert.create();
                    alert.show();
                }else{

                    CCplaceTest dao = new CCplaceTest(RegisterActivity.this);
                    //Será necessário adicionar uma nova coluna no banco para armazenar a data de nascimento
                    String dateOfBirth =    txtDay.getText().toString() + "/" +
                                            txtMonth.getText().toString() + "/" +
                                            txtYear.getText().toString();
                    int month = 0;
                    for(int i = 0;i < strMonths.length;i++){

                        if(txtMonth.getText().toString().equals(strMonths[i])){

                            month = i + 1;
                        }
                    }
                    int age = calculatesAge(Integer.parseInt(txtDay.getText().toString()),
                                  month,
                                  Integer.parseInt(txtYear.getText().toString()));
                    String strAge = "" + age;
                    Controller action = new Controller();
                    action.controllerUser(  dao,
                                            editUserName.getText().toString(),
                                            editPassword.getText().toString(),
                                            "Aqui",
                                            strAge,
                                            sex);
                    Intent home = new Intent(RegisterActivity.this, HomeActivity.class);
                    startActivity(home);
                }
            }
        });
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

    public int calculatesAge(int day, int month, int year){

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
}








