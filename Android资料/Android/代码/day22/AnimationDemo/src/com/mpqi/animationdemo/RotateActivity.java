package com.mpqi.animationdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

public class RotateActivity extends Activity {

	private int currAngle;//当前图片的角度 起始是0
	private View piechart;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rotate);
		piechart = findViewById(R.id.piechart);// 找到图片控件
		Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate);// 读取动画
		piechart.startAnimation(animation);
		currAngle = 0;
	}

	/**
	 * 顺时针
	 */
	public void positive(View v) {
		//Animation.RELATIVE_TO_SELF 相对于自己的百分数
		Animation animation = new RotateAnimation(currAngle, currAngle + 90,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f);
		/** 匀速插值器 */
		LinearInterpolator lr = new LinearInterpolator();
		animation.setInterpolator(lr);
		animation.setDuration(1000);//持续时间1秒
		/** 动画完成后不恢复原状 */
		animation.setFillAfter(true);
		currAngle += 90;//记录当前的角度
		if (currAngle > 360) {
			currAngle = currAngle - 360;
		}
		piechart.startAnimation(animation);
	}
	
	/**
	 * 逆时针
	 * @param v
	 */
	public void negative(View v) {
		Animation anim = new RotateAnimation(currAngle, currAngle - 180, Animation.RELATIVE_TO_SELF, 0.5f,
				Animation.RELATIVE_TO_SELF, 0.5f);
		/** 匀速插值器 */
		LinearInterpolator lir = new LinearInterpolator();
		anim.setInterpolator(lir);
		anim.setDuration(1000);
		/** 动画完成后不恢复原状 */
		anim.setFillAfter(true);
		currAngle -= 180;
		if (currAngle < -360) {
			currAngle = currAngle + 360;
		}
		piechart.startAnimation(anim);
	}
}
