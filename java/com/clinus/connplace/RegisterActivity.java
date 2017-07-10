package com.clinus.connplace;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity {

    ListView days;
    ListView months;
    ListView years;
    Button btnDay;
    Button btnMonth;
    Button btnYear;
    TextView txtDay;
    TextView txtMonth;
    TextView txtYear;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        String [] strDays = new String [31];
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
        String [] strYears = new String[100];
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
        txtDay = (TextView) findViewById(R.id.register_txtday);
        txtMonth = (TextView) findViewById(R.id.register_txtmonth);
        txtYear = (TextView) findViewById(R.id.register_txtyear);
        ArrayAdapter<String> adapterDays = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,strDays);
        days.setAdapter(adapterDays);
        ArrayAdapter<String> adapterMonths = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,strMonths);
        months.setAdapter(adapterMonths);
        ArrayAdapter<String> adapterYears = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,strYears);
        years.setAdapter(adapterYears);
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
    }
}








