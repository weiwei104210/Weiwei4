package com.example.weiwei.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.weiwei.R;
import com.example.weiwei.util.DataUtils;

public class AnswerActivity extends Activity {
    private TextView tv_answer;
    private static String[] answer;
    static {
            answer= DataUtils.ANSWER;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        tv_answer = (TextView)findViewById(R.id.tv_answer);
        Intent intent=getIntent();
        int position = intent.getIntExtra("position", -1);
        tv_answer.setText(answer[position]);
    }
}
