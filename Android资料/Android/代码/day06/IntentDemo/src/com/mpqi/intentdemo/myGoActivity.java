package com.mpqi.intentdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class myGoActivity extends Activity{

	private TextView lgoTextView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.go_layout);
		initViews();
		Intent intent = getIntent();
		//绑定值获取
//		String name = intent.getStringExtra("name");
//		int age  = intent.getIntExtra("age", -1);
		
		//绑定值获取 之  Bundle
//		Bundle bundle = intent.getExtras();
		Bundle bundle = intent.getBundleExtra("bundletmp");
		String name = bundle.getString("name");
		int age = bundle.getInt("age", -1);
		
		
		lgoTextView.setText(name);
		Toast.makeText(this, age+"", Toast.LENGTH_SHORT).show();
	}
	
	private void initViews() {
		lgoTextView = (TextView) findViewById(R.id.go_text);

	}
}
