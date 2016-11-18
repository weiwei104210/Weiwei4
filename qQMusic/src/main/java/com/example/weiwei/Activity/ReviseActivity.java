package com.example.weiwei.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.weiwei.Activity.AnswerActivity;
import com.example.weiwei.R;
import com.example.weiwei.util.DataUtils;

public class ReviseActivity extends Activity implements AdapterView.OnItemClickListener {
    private ListView lv_rev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revise);
        lv_rev = (ListView)findViewById(R.id.lv_rev);

        ArrayAdapter adapter=new ArrayAdapter(this,R.layout.item_revise,R.id.tv_revise,DataUtils.QUESTION);
        lv_rev.setAdapter(adapter);
        lv_rev.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent=new Intent(this,AnswerActivity.class);
        intent.putExtra("position",position);
        startActivity(intent);
    }
}
