package com.luffy.videoviewdemo;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import java.io.File;
import java.io.IOException;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.videov_film)
    VideoView videovFilm;
    @InjectView(R.id.btn_play)
    Button btnPlay;
    @InjectView(R.id.btn_pause)
    Button btnPause;
    @InjectView(R.id.btn_stop)
    Button btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initVideoView();
    }

    public void initVideoView(){
        File file =new File(Environment.getExternalStorageDirectory(),"video.mp4");//将文件存放为file对象
        videovFilm.setVideoPath(file.getPath());//设置音频文件路径
    }
    @OnClick({R.id.btn_play, R.id.btn_pause, R.id.btn_stop})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_play:
                if(!videovFilm.isPlaying()){
                    videovFilm.start();
                }
                break;
            case R.id.btn_pause:
                if(videovFilm.isPlaying()){
                    videovFilm.pause();
                }
                break;
            case R.id.btn_stop:
                if(videovFilm.isPlaying()){
                    videovFilm.resume();
                }
                break;
        }
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        if(videovFilm!=null) {
            videovFilm.suspend();
        }
    }
}
