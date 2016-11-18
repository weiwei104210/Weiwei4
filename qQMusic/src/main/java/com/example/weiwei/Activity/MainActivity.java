package com.example.weiwei.Activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.weiwei.R;

import static com.example.weiwei.R.layout.activity_main;

public class MainActivity extends Activity implements OnLongClickListener {
	private Button button1;
	private RelativeLayout main_acti;
	private float preX;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(activity_main);
		button1=(Button) findViewById(R.id.button1);
		main_acti = (RelativeLayout)findViewById(R.id.main_acti);
		button1.setOnLongClickListener(this);

		AlphaAnimation alphaAnimation=new AlphaAnimation(0,1);
		alphaAnimation.setDuration(1000);
		ScaleAnimation scaleAnimation=new ScaleAnimation(0,1,0,1,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
		scaleAnimation.setDuration(1000);
		RotateAnimation rotateAnimation=new RotateAnimation(0,360, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
		rotateAnimation.setDuration(1000);

		AnimationSet animationSet=new AnimationSet(false);
		animationSet.addAnimation(alphaAnimation);
		animationSet.addAnimation(scaleAnimation);
		animationSet.addAnimation(rotateAnimation);

		main_acti.startAnimation(animationSet);

	}



	public void start(View v){
		startActivity(new Intent(this, LoginActivity.class));
		finish();
	}
	@Override
	public boolean onLongClick(View arg0) {
		Intent intent=new Intent(Intent.ACTION_DIAL);
		Uri uri=Uri.parse("tel:"+"15834986368");
		intent.setData(uri);
		startActivity(intent);
		return true;
	}
}
