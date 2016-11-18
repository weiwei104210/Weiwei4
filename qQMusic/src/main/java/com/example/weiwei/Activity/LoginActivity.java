package com.example.weiwei.Activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.weiwei.R;

public class LoginActivity extends Activity {
	private EditText et_log_user;
	private EditText et_log_password;
	private Button btn_log_login;
	private Button btn_log_cancel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		et_log_user = (EditText)findViewById(R.id.et_log_user);
		et_log_password = (EditText)findViewById(R.id.et_log_password);
	}

	public void login(View v) {

		String key = et_log_user.getText().toString();
		String value = et_log_password.getText().toString();
		if (key.length() == 0 || value.length() == 0) {
			Toast.makeText(this, "你还没有输入用户名或密码", Toast.LENGTH_SHORT).show();
		} else {
			SharedPreferences sp = this.getSharedPreferences("user_info",
					Context.MODE_PRIVATE);
			String valueresult = sp.getString(key, null);
			if (valueresult == null) {
				Toast.makeText(this, "用户名错误", Toast.LENGTH_SHORT).show();
			} else {
				if (valueresult.equals(value)) {
					Intent intent=new Intent(this, SelectMusicActivity.class);
					intent.putExtra("username",key);
					startActivity(intent);
					finish();
				} else {
					Toast.makeText(this, "密码错误", Toast.LENGTH_SHORT).show();
				}
			}
		}
	}

	public void cancel(View v) {
		finish();
	}

	public void zc(View v) {
		int resquestCode=1;
		startActivityForResult(new Intent(this, ZcActivity.class), resquestCode);
	}
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(requestCode == 1 && resultCode == RESULT_OK) {
			String result = data.getStringExtra("result");
			et_log_user.setText(result);
		}
	}

	public void dis(View v) {
		String key = et_log_user.getText().toString();
		SharedPreferences sp = this.getSharedPreferences("user_info",
				Context.MODE_PRIVATE);
		String value = sp.getString(key, null);
		if (value == null) {
			Toast.makeText(this, "查无此用户", Toast.LENGTH_SHORT).show();
		} else {
			et_log_password.setText(value);
			Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
		}
	}
}
