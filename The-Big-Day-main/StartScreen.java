package com.myfirstapplication.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

public class StartScreen extends AppCompatActivity {
    MediaPlayer player;
    VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        video = (VideoView) findViewById(R.id.video);
        video.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" +R.raw.video3));
        MediaController vidControl = new MediaController(this);
        vidControl.setAnchorView(this.video);
        video.setMediaController(vidControl);
        this.video.start();

        if(player==null){
            player = MediaPlayer.create(this, R.raw.song);
        }
        player.start();
        Handler handler =new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent =new Intent(StartScreen.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },2000);
    }
}