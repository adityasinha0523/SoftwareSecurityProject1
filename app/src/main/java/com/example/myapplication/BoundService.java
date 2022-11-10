package com.example.myapplication;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Binder;
import android.util.Log;

public class BoundService extends Service {


    private final IBinder myBinder = new MyLocalBinder();

    public BoundService() {
    }

    @Override
    public IBinder onBind(Intent intent) {

        Log.i("BoundService", "Service Bound.");
        return myBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("BoundService", "Service Unbound.");
        return super.onUnbind(intent);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("BoundService", "Service Stopped.");

    }

    public String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Locale.US);
        return (sdf.format(new Date()));
    }

    public class MyLocalBinder extends Binder {
        BoundService getService() {

            return BoundService.this;
        }
    }
}