package com.mpqi.actvitydemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.TextView;

public class myGoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.golayout);
		Button button = (Button) findViewById(R.id.content_btn);
		button.setText("我是第二个页面");
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(myGoActivity.this,
						myThirdActivity.class);
				startActivity(intent);
			}
		});
		
		Button btn2 = (Button) findViewById(R.id.content2_btn);
		btn2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(myGoActivity.this,
						myGoActivity.class);
				startActivity(intent);
			}
		});
	}
}
