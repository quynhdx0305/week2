package com.example.quynh.resources1.calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quynh.resources1.MainActivity;
import com.example.quynh.resources1.R;

import java.util.ArrayList;
import java.util.List;

public class MainCalendar extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    TextView txtcalendar;
    Button btnSave;
    Button btnNo;
    String  calender = "";
    Spinner spinner;
    CheckBox check1;
    CheckBox check2;
    CheckBox check3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filter);
        //anh xa
        txtcalendar = (TextView)findViewById(R.id.txtbegindate);
        btnSave = (Button)findViewById(R.id.btn_Save);
        btnNo = (Button)findViewById(R.id.btn_No) ;
        spinner =(Spinner)findViewById(R.id.spinner) ;
        check1 = (CheckBox)findViewById(R.id.check1);
        check2 = (CheckBox)findViewById(R.id.check2);
        check3 = (CheckBox)findViewById(R.id.check3);
        //doc du lieu
        fun_readPrefer("data_maincalendar");


        //Click
        txtcalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(v);
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // luu du lieu
                fun_savePrefer(calender,spinner.getSelectedItem().toString());
                //spinner.getSelectedItem();
                Log.d("Spinner",spinner.getSelectedItem().toString());

                Intent filterIntent = new Intent(MainCalendar.this,MainActivity.class);
                startActivity(filterIntent);
                finish();

            }
        });
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fun_readPrefer("data_maincalendar");
                finish();
            }
        });

    }


    public void fun_readPrefer(String data_pre){
        SharedPreferences pre = getSharedPreferences (data_pre,MODE_PRIVATE);
        String preCalen = pre.getString("calendar","20180101");
        String preSpinn = pre.getString("spinner","newest");
        Boolean preCheck1 = pre.getBoolean("check1",false);
        Boolean preCheck2 = pre.getBoolean("check2",false);
        Boolean preCheck3 = pre.getBoolean("check3",false);
        Log.d("preSpinn",preSpinn);
            txtcalendar.setText(preCalen);
            calender = preCalen;
            if(preSpinn == spinner.getSelectedItem()){
                spinner.setSelection(0);//vi tri hien tai == 0
            }else {
                spinner.setSelection(1);//doi vi tri voi thang khac
            }
        check1.setChecked(preCheck1);
        check2.setChecked(preCheck2);
        check3.setChecked(preCheck3);
    }
    public void fun_savePrefer(String calend,String spinn){
        SharedPreferences pre = getSharedPreferences("data_maincalendar", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = pre.edit();
        edit.putString("calendar",calend);
        edit.putString("spinner",spinn);
        edit.putBoolean("check1",check1.isChecked());
        edit.putBoolean("check2",check2.isChecked());
        edit.putBoolean("check3",check3.isChecked());
        edit.commit();
        //fun_readPrefer("data_maincalendar");
    }

    // attac onclick handler to show the date pickerh to an
    public void showDatePickerDialog(View v) {
        DatePickerFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        final Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, monthOfYear);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        //Log.d("Calendar",c.get(Calendar.DAY_OF_MONTH)+"");
        // chuyen so sang chu
        calender = String.valueOf(year);
        if(monthOfYear<10){
            calender += "0" + String.valueOf(monthOfYear);
        }else {
            calender += String.valueOf(monthOfYear);
        }
        if(dayOfMonth < 10){
            calender += "0" + String.valueOf(dayOfMonth);
        }else {
            calender += String.valueOf(dayOfMonth);
        }
        txtcalendar.setText(calender);
    }
}
