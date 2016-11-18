package com.example.weiwei.Activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.weiwei.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetMusicActivity extends Activity implements View.OnClickListener {
    private Button btn_play;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_music);
        imageView = (ImageView)findViewById(R.id.imageView);
        btn_play = (Button)findViewById(R.id.btn_play);
        btn_play.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        new AsyncTask<Void,Void,Bitmap>(){
            @Override
            protected void onPreExecute() {

            }

            @Override
            protected Bitmap doInBackground(Void... params) {

                HttpURLConnection conn=null;
                InputStream is=null;

                try {
                    URL url=new URL("http://www.atguigu.com/images/logo.gif");
                    conn= (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.setConnectTimeout(5000);
                    conn.setReadTimeout(5000);
                    conn.connect();

                    if(conn.getResponseCode()==200) {
                        is=conn.getInputStream();
                        Bitmap bitmap= BitmapFactory.decodeStream(is);

                        return bitmap;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    if(conn!=null) {
                        conn.disconnect();
                    }
                    if(is!=null) {
                        try {
                            is.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                return null;
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {

                if(bitmap!=null) {
                    imageView.setImageBitmap(bitmap);
                }
            }
        }.execute();
        };
    }

