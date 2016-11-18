package com.example.weiwei.Activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.weiwei.R;

public class ZcActivity extends Activity {
	private EditText et_zc_user;
	private EditText et_zc_pass;
	private EditText et_zc_repass;
	private String user;
	private String pass;
	private String repass;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_zc);

		et_zc_user = (EditText) findViewById(R.id.et_zc_user);
		et_zc_pass = (EditText) findViewById(R.id.et_zc_pass);
		et_zc_repass = (EditText) findViewById(R.id.et_zc_repass);

	}

	public void zc_zc(View v) {

		user = et_zc_user.getText().toString();
		pass = et_zc_pass.getText().toString();
		repass = et_zc_repass.getText().toString();
		if(user.length()==0||pass.length()==0||repass.length()==0) {
		    Toast.makeText(ZcActivity.this, "信息输入不完整", Toast.LENGTH_SHORT).show();
			return;
		}
		new Thread(new Runnable() {
			@Override
			public void run() {
				if (pass.equals(repass)) {

					SharedPreferences sp = ZcActivity.this.getSharedPreferences("user_info",
							Context.MODE_PRIVATE);
					String result = sp.getString(user, null);
					if (result != null) {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								Toast.makeText(ZcActivity.this, "用户名已存在", Toast.LENGTH_SHORT).show();
							}
						});

					} else {
						SharedPreferences.Editor edit = sp.edit();
						edit.putString(user, pass);
						edit.commit();
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								Toast.makeText(ZcActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
							}
						});

						Intent intent = getIntent();
						String resu = et_zc_user.getText().toString();
						intent.putExtra("result",resu);
						setResult(RESULT_OK, intent);
						finish();
					}
				} else {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							Toast.makeText(ZcActivity.this, "你两次输入的密码不一致，请重新输入", Toast.LENGTH_SHORT).show();
						}
					});

				}
			}
		}).start();

	}

	public void zc_cancel(View v) {
		finish();
	}
}
