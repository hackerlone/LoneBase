package com.mpqi.animationdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class TranslateActivity extends Activity{
	
	private ImageView trans_iamge;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.translate);
		trans_iamge = (ImageView) findViewById(R.id.trans_image);
		Animation animation = AnimationUtils.loadAnimation(this, R.anim.translate);
		trans_iamge.startAnimation(animation);
	}
	
	public void translate(View view) {
		//起始的 X 结束的X  起始的Y 结束位置的 Y
		Animation anim = new TranslateAnimation(200, 100, 300, 50);
		anim.setDuration(2000);
		anim.setFillAfter(true);
		OvershootInterpolator overshoot = new OvershootInterpolator();//插值器
		anim.setInterpolator(overshoot);
		trans_iamge.startAnimation(anim);
	}

}
