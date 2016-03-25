package com.mpqi.myjiujiujintu;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

/**
 * 读取加载界面
 * 
 * @author mpqi
 *
 */
public class LoadingActivity extends Activity {
	private ImageView nloadingImg, nskipImg;// 中间的帧动画图片 右上角的跳过图片
	private AnimationDrawable nloadingAnimationDrawable;// 帧动画
	private Handler handler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loading);

		initView();
		initLoadingImg();
	}

	/**
	 * 控件初始化
	 */
	private void initView() {
		nloadingImg = (ImageView) findViewById(R.id.loading_img);
		nskipImg = (ImageView) findViewById(R.id.loading_skip);

		nskipImg.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (!isFinishing()) {
					startActivity(new Intent(LoadingActivity.this,
							MainActivity.class));
					finish();
				}
			}
		});
	}

	/**
	 * 初始化加载动画
	 */
	private void initLoadingImg() {
		nloadingAnimationDrawable = (AnimationDrawable) nloadingImg
				.getDrawable();
		nloadingAnimationDrawable.start();// 启动帧动画
		new Thread(new Runnable() {// 启动子线程

					@Override
					public void run() {
						try {
							Thread.sleep(10000);// 线程睡十秒 再跳转到主activity
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						handler.post(new Runnable() {// 通知主线程关闭当前 activity
														// 启动mainActivity

							@Override
							public void run() {
								if (!isFinishing()) {
									startActivity(new Intent(
											LoadingActivity.this,
											MainActivity.class));
									finish();
								}

							}
						});
					}
				}).start();
	}

	@Override
	public void finish() {
		nloadingAnimationDrawable.stop();// 停止帧动画
		nloadingAnimationDrawable.setCallback(null);
		nloadingAnimationDrawable = null;
		nloadingImg = null;
		nskipImg = null;
		super.finish();
	}
}
