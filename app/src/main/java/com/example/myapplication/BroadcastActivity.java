package com.example.myapplication;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import static com.example.myapplication.MainActivity.globalBroadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class BroadcastActivity extends AppCompatActivity {
    private TextView textView;
    private TextView time;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);
        Date date = Calendar.getInstance().getTime();
        String formatdate = date.toString();
        String[] formatdateArray = formatdate.split(" ");
        Log.d(TAG, "myLogDate: " + date.toString());
        Log.d(TAG, "formatdate: " + formatdate);
        Log.d(TAG, "formatdateArray: " + formatdateArray[3]);

        time = findViewById(R.id.broadCastTime);
        time.setText(formatdateArray[3]);
        text= findViewById(R.id.text);
        text.setText(globalBroadcast);

    }
}