package com.example.grocemate2;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;

import androidx.annotation.Nullable;

public class Music extends Service {
    private MediaPlayer mp;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (mp == null) {
            mp = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
            mp.setLooping(true);
            mp.start();
        }
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        if (mp != null) {
            mp.stop();
            mp.release();
            mp = null;
        }
        super.onDestroy();
    }
}
