package com.example.weiwei.service;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.IBinder;

import com.example.weiwei.Activity.SelectMusicActivity;
import com.example.weiwei.bean.Music;
import com.example.weiwei.util.AppConstant;

import java.util.List;


@SuppressLint("NewApi")
public class MusicPlayService extends Service {
    private MediaPlayer mediaPlayer;       //媒体播放器对象
    private String path;                        //音乐文件路径
    private String prepath;
    private boolean isPause;                    //暂停状态
    private static List<Music> list;
    private int position;
    private int preposition;

    static {
        list = SelectMusicActivity.getList();
    }

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }




    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        position = intent.getIntExtra("position",-1);
        if(position!=-1) {
            preposition=position;
        }
        path = intent.getStringExtra("url");
        int msg = intent.getIntExtra("MSG", 0);
        if (msg == AppConstant.PlayerMsg.PLAY_MSG) {
            play();
        } else if (msg == AppConstant.PlayerMsg.PAUSE_MSG) {
            pause();
        } else if (msg == AppConstant.PlayerMsg.STOP_MSG) {
            stop();
        } else if (msg == AppConstant.PlayerMsg.NEXT_MSG) {
            next();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    private void next() {
        preposition += 1;
        if(preposition>=list.size()) {
            preposition=0;
        }
        path=list.get(preposition).getUrl();
        play();
    }


    /**
     * 播放音乐
     */
    private void play() {
        try {

            if (mediaPlayer == null || (path != null && !path.equals(prepath))) {
                if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }
                mediaPlayer = new MediaPlayer();
                mediaPlayer.reset();//把各项参数恢复到初始状态
                mediaPlayer.setDataSource(path);
                if (path != null) {
                    prepath = path;
                }

                mediaPlayer.prepare();
            }
            if (isPause) {
                mediaPlayer.start();
            }

            //进行缓冲
            mediaPlayer.setOnPreparedListener(new PreparedListener());//注册一个监听器
            mediaPlayer.setOnCompletionListener(new MyOncompliteListener());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 暂停音乐
     */
    private void pause() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            isPause = true;
        }
    }

    /**
     * 停止音乐
     */
    private void stop() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.reset();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }


    @Override
    public void onDestroy() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();

        }
        super.onDestroy();
    }

    /**
     * 实现一个OnPrepareLister接口,当音乐准备好的时候开始播放
     */
    private final class PreparedListener implements OnPreparedListener {
        @Override
        public void onPrepared(MediaPlayer mp) {
            mediaPlayer.start();    //开始播放

        }
    }
    class MyOncompliteListener implements MediaPlayer.OnCompletionListener{

        @Override
        public void onCompletion(MediaPlayer mp) {
            next();
        }
    }

}
