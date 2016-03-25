package com.mpqi.animationdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

public class ScaleActivity extends Activity{
	
	private ImageView scale_iamge;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scale);
		scale_iamge = (ImageView) findViewById(R.id.scale_image);
		Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale);
		scale_iamge.startAnimation(animation);
	}
	
	
	public void sclae(View view) {
		Animation anim = new ScaleAnimation(2.0f, 1.0f, 2.0f, 1.0f, 
				Animation.RELATIVE_TO_SELF, 1.0f, 
				Animation.RELATIVE_TO_SELF, 1.0f);
		anim.setDuration(1000);
		anim.setFillAfter(false);
		LinearInterpolator lr = new LinearInterpolator();
		anim.setInterpolator(lr);
//		BounceInterpolator bounce = new BounceInterpolator();
//		anim.setInterpolator(bounce);
		scale_iamge.startAnimation(anim);
	}
}
