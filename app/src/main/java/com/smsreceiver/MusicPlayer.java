package com.smsreceiver;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import com.smsreceiver.R;

/**
 * Created by Rozerin on 4.07.2017.
 */

class MusicPlayer extends Service {
    private MediaPlayer player;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int flags,int startId) {
        super.onStartCommand(intent, flags,startId);
        player = MediaPlayer.create(this, R.raw.test);
        player.start();
        return START_STICKY;
    }

    public void onDestroy() {
        super.onDestroy();
        player.stop();
    }
}