package com.jiujiu.jintu;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class LoadingActivity extends Activity {
	private ImageView imageView;
	private Handler handler = new Handler();
	private AnimationDrawable animationDrawable;;
	private View skipView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loading);
		imageView = (ImageView) findViewById(R.id.laoding_img);
		animationDrawable = (AnimationDrawable) imageView.getDrawable();
		animationDrawable.start();

		skipView = findViewById(R.id.laoding_skip);
		skipView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (!isFinishing()) {
					startActivity(new Intent(LoadingActivity.this,
							MainActivity.class));
					finish();
				}
			}
		});

		new Thread(new Runnable() {

			@Override
			public void run() {

				try {
					Thread.sleep(10000);
					handler.post(new Runnable() {

						@Override
						public void run() {

							if (!isFinishing()) {
								startActivity(new Intent(LoadingActivity.this,
										MainActivity.class));
								finish();
							}
						}
					});
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}).start();
	}

	@Override
	public void finish() {
		animationDrawable.stop();
		animationDrawable.setCallback(null);
		animationDrawable = null;
		imageView = null;
		super.finish();
	}
}
