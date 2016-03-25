package com.mpqi.hello;

import android.R.integer;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class myThirdActivity extends Activity {
	private TextView contentTextView;
	private Button cButton;
	private String lastnum = "0";
	private boolean jiaflag = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.jisuanqi_layout);

		initViews();
		
		cButton.setOnLongClickListener(new OnLongClickListener() {//长按点击事件
			
			@Override
			public boolean onLongClick(View v) {
				contentTextView.setText("0");
				return true;
			}
		});
	}

	private void initViews() {
		contentTextView = (TextView) findViewById(R.id.content);
		cButton = (Button) findViewById(R.id.btn_c);
	}

	public void myOnclick(View view) {
		int id = view.getId();
		String content = contentTextView.getText().toString();
		switch (id) {
		case R.id.btn_01:
			if (content.equals("0") || jiaflag) {
				content = "1";
				jiaflag = false;
			}else {
				content +="1";
			}			
			break;
		case R.id.btn_02:
			if (content.equals("0")  || jiaflag) {
				content = "2";
				jiaflag = false;
			}else {
				content +="2";
			}	
			break;
		case R.id.btn_03:
			if (content.equals("0")  || jiaflag) {
				content = "3";
				jiaflag = false;
			}else {
				content +="3";
			}	
			break;
		case R.id.btn_04:
			if (content.equals("0") || jiaflag) {
				content = "4";
				jiaflag = false;
			}else {
				content +="4";
			}	
			break;
		case R.id.btn_05:
			if (content.equals("0") || jiaflag) {
				content = "5";
				jiaflag = false;
			}else {
				content +="5";
			}	
			break;
		case R.id.btn_06:
			if (content.equals("0") || jiaflag) {
				content = "6";
				jiaflag = false;
			}else {
				content +="6";
			}	
			break;
		case R.id.btn_07:
			if (content.equals("0") || jiaflag) {
				content = "7";
				jiaflag = false;
			}else {
				content +="7";
			}	
			break;
		case R.id.btn_08:
			if (content.equals("0") || jiaflag) {
				content = "8";
				jiaflag = false;
			}else {
				content +="8";
			}	
			break;
		case R.id.btn_09:
			if (content.equals("0") || jiaflag) {
				content = "9";
				jiaflag = false;
			}else {
				content +="9";
			}	
			break;
		case R.id.btn_10:
			if (content.equals("0") || jiaflag) {
				content = "0";
				jiaflag = false;
			}else {
				content +="0";
			}	
			break;
		case R.id.btn_jia:
			lastnum = content;
			jiaflag = true;
			break;
		case R.id.btn_dengyu:
			jiaflag = false;
			int lnum = Integer.valueOf(lastnum);
			int cnum = Integer.valueOf(content);
			content = lnum + cnum +"";
			break;
		case R.id.btn_c://删除一个
			if (!content.equals("0") && content.length() > 1) {
				content = content.subSequence(0, content.length()-1).toString();
			}else if (content.length() == 1) {
				content = "0";
			}		
			Toast.makeText(this, "点击删除事件", Toast.LENGTH_SHORT).show();
			break;
		}
		
		contentTextView.setText(content);
	}
}
