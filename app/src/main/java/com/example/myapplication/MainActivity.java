package com.example.myapplication;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private Button broadcastButton;
    private Button serviceButton;
    private Button contentButton;
    private TextView time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        broadcastButton = (Button) findViewById(R.id.broadCastButton);
        broadcastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                broadcastActivityEvent();
            }
        });
        serviceButton = (Button) findViewById(R.id.serviceButton);
        serviceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                serviceActivityEvent();
            }
        });
        contentButton = (Button) findViewById(R.id.contentButton);
        contentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contentActivityEvent();
            }
        });

        Date date = Calendar.getInstance().getTime();
        String formatdate= date.toString();
        String []formatdateArray= formatdate.split(" ");
        Log.d(TAG, "myLogDate: " + date.toString());
        Log.d(TAG, "formatdate: " + formatdate);
        Log.d(TAG, "formatdateArray: " + formatdateArray[3]);

        time= findViewById(R.id.time);
        time.setText(formatdateArray[3]);



    }
    private void broadcastActivityEvent() {
        Intent intent = new Intent(this, BroadcastActivity.class);
        startActivity(intent);
    }

    private void serviceActivityEvent() {
        Intent intent = new Intent(this, ServiceActivity.class);
        startActivity(intent);
    }
    private void contentActivityEvent() {
        Intent intent = new Intent(this, ContentActivity.class);
        startActivity(intent);
    }
}