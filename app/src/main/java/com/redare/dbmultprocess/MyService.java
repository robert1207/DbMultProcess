package com.redare.dbmultprocess;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.redare.dbmultprocess.db.SQLite_db;

public class MyService extends Service {


    private static final String TAG = "MyService";

    private SQLite_db db;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        db = SQLite_db.getInstance(getApplicationContext());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
       // return super.onStartCommand(intent, flags, startId);
        doDbWork();

        return START_STICKY;
    }

    private void doDbWork() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    db.insertNewTask(2, "service");
                    Log.e(TAG, "run: service 2222" );
                }
            }
        }).start();
    }
}
