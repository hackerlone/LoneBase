package com.mpqi.logindemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button loginBtn;
	private TextView contentText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		loginBtn = (Button) findViewById(R.id.login);
		contentText = (TextView) findViewById(R.id.content_text);
		
		loginBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this , LoginActivity.class);
				//Intent intent, int requestCode 请求码
				startActivityForResult(intent, 1);
				
			}
		});
		
	}
	
	@Override
	/**
	 * requestCode 请求码
	 * resultCode 结果返回码
	 * data  意图包裹的数据
	 */
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 1 && resultCode == 2) {
			String text = data.getStringExtra("content");
			contentText.setText(text);
		}else if (requestCode == 1 && resultCode == 3) {
			String text = data.getStringExtra("content");
			contentText.setText(text);
			Toast.makeText(this, "不要挣扎了！", Toast.LENGTH_SHORT).show();
		}
	}
}
