package com.smsreceiver;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {


       public BroadcastReceiver smsReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onResume() {
        super.onResume();


    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("pause", "sds");
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null) {
            Log.d("sd", "sds");
            Intent serviceIntent = new Intent(MainActivity.this, MusicPlayer.class);
            startService(serviceIntent);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("stop", "sds");
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null) {
            Log.d("sd", "sds");
            Intent serviceIntent = new Intent(MainActivity.this, MusicPlayer.class);
            startService(serviceIntent);
        }
    }
}
