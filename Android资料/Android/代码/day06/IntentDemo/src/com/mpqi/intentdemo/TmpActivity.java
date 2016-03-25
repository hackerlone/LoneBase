package com.mpqi.intentdemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class TmpActivity extends Activity{
	private TextView lgoTextView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.go_layout);
		initViews();
		lgoTextView.setText("我是TMP这个Activity");
	}
	
	private void initViews() {
		lgoTextView = (TextView) findViewById(R.id.go_text);

	}
}
