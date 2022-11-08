package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class BroadcastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);
    }
    
    public void onReceive(Context context, Intent intent) {
        String format = "HH:mm:ss";
        SimpleDateFormat sdf =new SimpleDateFormat(format, Locale.US);
        String callstarttime = sdf.format(Calendar.getInstance().getTime());
        Toast.makeText(context, callstarttime, Toast.LENGTH_SHORT).show();
    }
}