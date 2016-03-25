package com.mpqi.intentdemo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity{
	private EditText lcontentEditText;
	private Button lcontentButton;
	private String GO_ACITON= "com.mpqi.intentdemo.MY_GO";
	private Button lcallButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		initViews();
		
		lcontentButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
//				Intent intent = new Intent();
//				intent.setAction(GO_ACITON);
//				startActivity(intent);
				
				//组件形式的跳转
//				ComponentName cn = new ComponentName(MainActivity.this, "com.mpqi.intentdemo.myGoActivity");
//				Intent intent = new Intent();
//				intent.setComponent(cn);
//				startActivity(intent);
				
				//回到主页面
//				Intent intent = new Intent();
//				intent.setAction(Intent.ACTION_MAIN);
//				intent.addCategory(Intent.CATEGORY_HOME);
//				startActivity(intent);
				
				//值的绑定
//				Intent intent = new Intent();
//				intent.setClass(MainActivity.this , myGoActivity.class);
//				
//				intent.putExtra("name", lcontentEditText.getText().toString());
//				intent.putExtra("age", 11);
//				
//				startActivity(intent);
				
				//值的绑定 之 Bundle
				Intent intent = new Intent();
				intent.setClass(MainActivity.this , myGoActivity.class);
				Bundle bundle = new Bundle();
				bundle.putString("name", lcontentEditText.getText().toString());
				bundle.putInt("age", 18);
				
//				intent.putExtras(bundle);
				intent.putExtra("bundletmp", bundle);
				
				startActivity(intent);
				
			}
		});
		
		lcallButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String num = lcontentEditText.getText().toString();
				Intent intent = new Intent(Intent.ACTION_CALL , Uri.parse("tel:"+num));
				startActivity(intent);
			}
		});
	}
	
	private void initViews() {
		lcontentButton = (Button) findViewById(R.id.content_btn);
		lcontentEditText = (EditText) findViewById(R.id.content_ed);
		lcallButton = (Button) findViewById(R.id.call_btn);
	}
}
