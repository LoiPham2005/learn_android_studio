package com.example.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MyService extends Service {
    MediaPlayer mymusic;
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // hàm dùng khởi tạo đối tượng mà service quản lí
    @Override
    public void onCreate() {
        super.onCreate();
        mymusic = MediaPlayer.create(MyService.this,R.raw.trentinhbanduoitinhyeu);
        mymusic.setLooping(true);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(mymusic.isPlaying())
            mymusic.pause();
        else
            mymusic.start();

        return super.onStartCommand(intent, flags, startId);
    }
    // hàm dùng để dừng đối tượng mà Service quản lí


    @Override
    public void onDestroy() {
        super.onDestroy();
        mymusic.stop();
    }
}