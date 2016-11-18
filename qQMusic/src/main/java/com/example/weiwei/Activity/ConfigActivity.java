package com.example.weiwei.Activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.weiwei.R;

public class ConfigActivity extends Activity implements AdapterView.OnItemClickListener {
    private ListView lv_con;
    private String[] data ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
        lv_con = (ListView) findViewById(R.id.lv_con);
        data = new String[]{"定时播放", "清空缓存", "设置项3", "设置项4"
                , "设置项5", "设置项6", "设置项7", "设置项8", "设置项9", "设置项10"
                , "设置项11", "设置项12", "设置项13", "设置项14", "设置项15"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.item_con,data);
        lv_con.setAdapter(adapter);
        lv_con.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if(i==0) {
            Intent intent = new Intent(this, config_1Activity.class);
            startActivity(intent);
        }else if(i==1) {
            new AlertDialog.Builder(this)
                        .setTitle("确定清理")
                       .setMessage("确定清理缓存？")
                       .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialog, int which) {
                               Toast.makeText(ConfigActivity.this, "清理成功", Toast.LENGTH_SHORT).show();
                           }
                      })
                        .setNegativeButton("取消", null)
                      .show();
        }

    }
}
