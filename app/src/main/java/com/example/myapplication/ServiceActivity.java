package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.os.IBinder;
import android.content.Context;
import android.content.Intent;
import android.content.ComponentName;
import android.content.ServiceConnection;
import com.example.myapplication.BoundService.MyLocalBinder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ServiceActivity extends AppCompatActivity {

    Button btnStart, btnStop;
    TextView myTextView, textStatus;
    BoundService myService;
    boolean isBound = false;

    private final ServiceConnection myConnection = new ServiceConnection()
    {

        public void onServiceConnected(ComponentName className, IBinder service) {
            MyLocalBinder binder = (MyLocalBinder) service;
            myService = binder.getService();
            isBound = true;
            textStatus.setText(R.string.connecting);
        }

        public void onServiceDisconnected(ComponentName arg0) {

            isBound = false;
            textStatus.setText(R.string.disconnecting);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);
        textStatus = findViewById(R.id.textStatus);
        myTextView = findViewById(R.id.myTextView);

        btnStart.setOnClickListener(btnStartListener);
        btnStop.setOnClickListener(btnStopListener);

        Intent intent = new Intent(this, BoundService.class);
        bindService(intent, myConnection, Context.BIND_AUTO_CREATE);

    }

    private final OnClickListener btnStartListener = new OnClickListener() {
        public void onClick(View v){
            showTime(v);
            textStatus.setText(R.string.binding);
        }
    };

    private final OnClickListener btnStopListener = v -> {
        doUnbindService();
        stopService(new Intent(ServiceActivity.this, BoundService.class));
    };

    public void showTime(View view)
    {
        String currentTime = myService.getCurrentTime();
        myTextView.setText(currentTime);
        Toast.makeText(this, "Service Started! ", Toast.LENGTH_SHORT).show();
    }

    void doUnbindService() {
        unbindService(myConnection);
        textStatus.setText(R.string.unbinding);
        myTextView.setText(R.string.hello_world);
        Toast.makeText(this, "Service Stopped :( ", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            doUnbindService();
        }
        catch (Throwable t) {
            Log.e("ServiceActivity", "Failed to unbind from the service", t);
        }
    }
}