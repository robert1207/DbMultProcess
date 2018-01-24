package com.redare.dbmultprocess;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.redare.dbmultprocess.db.SQLite_db;

public class MainActivity extends AppCompatActivity {

    private SQLite_db db;

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = SQLite_db.getInstance(getApplicationContext());

        doDbWork();

        Intent intent = new Intent();
        intent.setClass(this, MyService.class);
        startService(intent);
    }

    private void doDbWork() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    db.insertNewTask(1, "activity");
                    Log.e(TAG, "run: activity 1111" );
                }
            }
        }).start();
    }
}
