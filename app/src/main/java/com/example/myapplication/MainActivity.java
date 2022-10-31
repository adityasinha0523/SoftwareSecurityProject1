package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button broadcastButton;
    private Button serviceButton;
    private Button contentButton;
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