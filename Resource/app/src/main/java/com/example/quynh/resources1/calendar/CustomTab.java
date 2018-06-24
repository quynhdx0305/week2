package com.example.quynh.resources1.calendar;

import android.net.Uri;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.quynh.resources1.R;

public class CustomTab extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_tab);
        String url = getIntent().getStringExtra("url_web");


        //String url = "https://www.codepath.com/";
        fun_chrometab(url);
    }

    //fun tab chrome
    public void fun_chrometab(String url){

        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(this, Uri.parse(url));
    }
}
