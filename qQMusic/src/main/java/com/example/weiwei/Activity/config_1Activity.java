package com.example.weiwei.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.weiwei.R;

public class config_1Activity extends Activity implements RadioGroup.OnCheckedChangeListener {
    RadioGroup ra_con_1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_1);

        ra_con_1 = (RadioGroup)findViewById(R.id.ra_con_1);
        ra_con_1.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        RadioButton r= (RadioButton) findViewById(i);
        String content=r.getText().toString();
        Toast.makeText(config_1Activity.this,content+ "后停止播放", Toast.LENGTH_SHORT).show();
        finish();
    }
}
