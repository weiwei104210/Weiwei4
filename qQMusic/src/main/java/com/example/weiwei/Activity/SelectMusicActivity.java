package com.example.weiwei.Activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.util.Log;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SeekBar;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.weiwei.R;
import com.example.weiwei.bean.Music;
import com.example.weiwei.service.MusicPlayService;
import com.example.weiwei.util.AppConstant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class SelectMusicActivity extends Activity implements View.OnClickListener {
    private ListView lv_se;
    private SeekBar seekBar;
    private SimpleAdapter mAdapter;
    private boolean flag = true;
    private PopupWindow popupWindow;
    private View popupView;
    private ImageView imSeletStop;
    private ImageView imSeletPause;
    private ImageView imSeletPlay;
    private ImageView imSeletNext;
    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            Log.e("TAG", "handler 处理消息");
            switch (msg.what) {
                case 1:
                    flag = true;
                    break;
            }
        }
    };
    private Handler handler1=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            seekBar.setProgress(seekBar.getProgress()+1000);

            handler1.sendEmptyMessageDelayed(1,1000);
        }
    };
    private static List<Music> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_music);
        lv_se = (ListView) findViewById(R.id.lv_se);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        imSeletStop = (ImageView) findViewById(R.id.im_selet_stop);
        imSeletPause = (ImageView) findViewById(R.id.im_selet_pause);
        imSeletPlay = (ImageView) findViewById(R.id.im_selet_play);
        imSeletNext = (ImageView) findViewById(R.id.im_selet_next);

        imSeletStop.setOnClickListener(this);
        imSeletPause.setOnClickListener(this);
        imSeletPlay.setOnClickListener(this);
        imSeletNext.setOnClickListener(this);
        Log.i("TAG", "111111111111111111");
        list = getMp3Infos();
        setListAdpter(list);
        Log.i("TAG", "22222222222222222222");


        lv_se.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                Music mp3Info = list.get(arg2);
                String url = mp3Info.getUrl();
                int time = (int) mp3Info.getTime();
                if (list != null) {

                    Intent intent = new Intent();
                    intent.putExtra("position",arg2);
                    intent.putExtra("url", url);
                    intent.putExtra("MSG", AppConstant.PlayerMsg.PLAY_MSG);
                    intent.setClass(SelectMusicActivity.this, MusicPlayService.class);
                    seekBar.setMax(time);
                    startService(intent);
                    handler1.removeCallbacksAndMessages(null);
                    seekBar.setProgress(0);
                    handler1.sendEmptyMessageDelayed(1,1000);

                }
                if (popupWindow == null) {

                    popupView = View.inflate(SelectMusicActivity.this, R.layout.layout_popup, null);
                    popupWindow = new PopupWindow(popupView, arg1.getWidth() - 140, arg1.getHeight());

                    popupView.findViewById(R.id.ll_popup_play).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            popupWindow.dismiss();
                        }
                    });
                    popupView.findViewById(R.id.ll_popup_share).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            popupWindow.dismiss();
                        }
                    });

                }
                if (popupWindow.isShowing()) {
                    popupWindow.dismiss();
                }
                popupWindow.showAsDropDown(arg1, 140, -arg1.getHeight());

            }
        });
        lv_se.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                menu.add(0, 1, 0, "删除歌曲");
                menu.add(0, 2, 0, "提升音质");
                menu.add(0, 3, 0, "截取片段");
                menu.add(0, 4, 0, "设为铃声");
                

            }
        });
        lv_se.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    if (popupWindow != null && popupWindow.isShowing()) {
                        popupWindow.dismiss();
                    }
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            }
        });
    }

    public static List<Music> getList() {
        return list;
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE, 1, Menu.NONE, "设置");
        menu.add(Menu.NONE, 2, Menu.NONE, "fragmentDemo");
        menu.add(Menu.NONE, 3, Menu.NONE, "网络加载图片");
        menu.add(Menu.NONE, 4, Menu.NONE, "安卓基础复习");
        menu.add(Menu.NONE, 5, Menu.NONE, "退出应用");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==1) {
            startActivity(new Intent(this, ConfigActivity.class));
        }else if(item.getItemId()==2) {
            startActivity(new Intent(this, MyFragmentActivity.class));
        }else if(item.getItemId()==3) {
            Intent intent = new Intent(this, NetMusicActivity.class);
            startActivity(intent);
        }else if(item.getItemId()==4) {
            Intent intent = new Intent(this, ReviseActivity.class);
            startActivity(intent);
        }else if(item.getItemId()==5) {
            stopService(new Intent(this,MusicPlayService.class));
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public List<Music> getMp3Infos() {
        Cursor cursor = getContentResolver().query(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null,
                MediaStore.Audio.Media.DEFAULT_SORT_ORDER);
        List<Music> mp3Infos = new ArrayList<Music>();
        Log.i("TAG", cursor.toString());
        for (int i = 0; i < cursor.getCount(); i++) {
            Music mp3Info = new Music();
            cursor.moveToNext();
            String title = cursor.getString((cursor
                    .getColumnIndex(MediaStore.Audio.Media.TITLE)));//音乐标题
            String artist = cursor.getString(cursor
                    .getColumnIndex(MediaStore.Audio.Media.ARTIST));//艺术家
            long duration = cursor.getLong(cursor
                    .getColumnIndex(MediaStore.Audio.Media.DURATION));//时长

            String url = cursor.getString(cursor
                    .getColumnIndex(MediaStore.Audio.Media.DATA));              //文件路径
            Log.i("TAG", "=======================" + url);
            int isMusic = cursor.getInt(cursor
                    .getColumnIndex(MediaStore.Audio.Media.IS_MUSIC));//是否为音乐
            if (isMusic != 0) {     //只把音乐添加到集合当中
                mp3Info.setName(title);
                mp3Info.setSinger(artist);
                mp3Info.setTime(duration);
                mp3Info.setUrl(url);
                mp3Infos.add(mp3Info);
            }
        }
        return mp3Infos;
    }


    public void setListAdpter(List<Music> mp3Infos) {
        List<HashMap<String, String>> mp3list = new ArrayList<HashMap<String, String>>();
        for (Iterator iterator = mp3Infos.iterator(); iterator.hasNext(); ) {
            Music mp3Info = (Music) iterator.next();
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("title", mp3Info.getName());
            map.put("Artist", mp3Info.getSinger());
            map.put("zhuanji", mp3Info.getZj());
            map.put("url", mp3Info.getUrl());
            mp3list.add(map);
        }
        mAdapter = new SimpleAdapter(this, mp3list,
                R.layout.item_music, new String[]{"title", "Artist", "zhuanji"},
                new int[]{R.id.tv_item_name, R.id.tv_item_singer, R.id.tv_item_zj});
        lv_se.setAdapter(mAdapter);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (flag) {
                Toast.makeText(SelectMusicActivity.this, "再点击一次，退出当前应用", Toast.LENGTH_SHORT).show();

                flag = false;

                handler.sendEmptyMessageDelayed(1, 2000);

                return true;
            }
        }


        return super.onKeyUp(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        handler.removeCallbacksAndMessages(null);
        handler1.removeCallbacksAndMessages(null);
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.im_selet_play:
                intent.putExtra("MSG", AppConstant.PlayerMsg.PLAY_MSG);
                intent.setClass(SelectMusicActivity.this, MusicPlayService.class);
                startService(intent);
                break;
            case R.id.im_selet_pause:
                intent.putExtra("MSG", AppConstant.PlayerMsg.PAUSE_MSG);
                intent.setClass(SelectMusicActivity.this, MusicPlayService.class);
                startService(intent);
                break;
            case R.id.im_selet_stop:
                intent.putExtra("MSG", AppConstant.PlayerMsg.STOP_MSG);
                intent.setClass(SelectMusicActivity.this, MusicPlayService.class);
                startService(intent);
                handler1.removeCallbacksAndMessages(null);
                seekBar.setProgress(0);
                break;
            case R.id.im_selet_next:
                intent.putExtra("MSG", AppConstant.PlayerMsg.NEXT_MSG);
                intent.setClass(SelectMusicActivity.this, MusicPlayService.class);
                startService(intent);
                handler1.removeCallbacksAndMessages(null);
                seekBar.setProgress(0);
                handler1.sendEmptyMessageDelayed(1,1000);
                break;
        }
    }
}
