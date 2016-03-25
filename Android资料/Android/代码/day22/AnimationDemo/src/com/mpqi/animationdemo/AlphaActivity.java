package com.mpqi.animationdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class AlphaActivity extends Activity{
	private ImageView splash;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alpha);
		splash = (ImageView) findViewById(R.id.splash);
		Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha);
		splash.startAnimation(animation);
	}
	
	public void alpha(View view) {
		Animation anim = new AlphaAnimation(1.0f, 0.0f);//开始状态  不透明   结束状态  完全透明
		anim.setDuration(3000);
		anim.setFillAfter(true);
		splash.startAnimation(anim);
	}
}
