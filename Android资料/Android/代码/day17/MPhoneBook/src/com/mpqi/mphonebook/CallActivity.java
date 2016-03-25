package com.mpqi.mphonebook;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.TextView;

public class CallActivity extends Activity {

	private Button callBtn , xBtn;
	private TextView numText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.call_layout);
		
		if (Intent.ACTION_VIEW.equals(getIntent().getAction())) {
			
		}
		initView();
	}
	

	/**
	 * 初始化控件
	 */
	private void initView() {
		callBtn = (Button) findViewById(R.id.gocall);
		callBtn.setBackgroundColor(getResources().getColor(R.color.lightblue));
		numText = (TextView) findViewById(R.id.numtext);
		xBtn = (Button) findViewById(R.id.numx);
		
		xBtn.setOnLongClickListener(new OnLongClickListener() {
			
			@Override
			public boolean onLongClick(View v) {
				numText.setText("");
				return true;
			}
		});
	}

	public void callNum(View view) {
		String num = numText.getText().toString();
		switch (view.getId()) {
		case R.id.num1:
			num += "1";
			numText.setText(num);
			break;

		case R.id.num2:
			num += "2";
			numText.setText(num);
			break;
		case R.id.num3:
			num += "3";
			numText.setText(num);
			break;

		case R.id.num4:
			num += "4";
			numText.setText(num);
			break;

		case R.id.num5:
			num += "5";
			numText.setText(num);
			break;
		case R.id.num6:
			num += "6";
			numText.setText(num);
			break;

		case R.id.num7:
			num += "7";
			numText.setText(num);
			break;

		case R.id.num8:
			num += "8";
			numText.setText(num);
			break;
		case R.id.num9:
			num += "9";
			numText.setText(num);
			break;

		case R.id.num0:
			num += "0";
			numText.setText(num);
			break;

		case R.id.numxing:
			num += "*";
			numText.setText(num);
			break;
		case R.id.numjing:
			num += "#";
			numText.setText(num);
			break;
		case R.id.numcall:
			Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+num));  
            startActivity(intent);  
			break;

		case R.id.numx:
			if (num.length() != 0) {
				numText.setText(num.subSequence(0, num.length()-1));
			}
			break;
		}
	}

	/**
	 * 底部菜单栏点击事件
	 * 
	 * @param view
	 */
	public void footbarOnclick(View view) {
		Intent intent = null;
		switch (view.getId()) {
		case R.id.gophonenumbers:
			intent = new Intent(this, PhoneNumbersActivity.class);
			startActivity(intent);
			finish();
			break;
		case R.id.gocalllog:
			intent = new Intent(this, CallLogActivity.class);
			startActivity(intent);
			finish();
			break;
		case R.id.gotelephonedir:
			intent = new Intent(this, TelephoneDirAcitivty.class);
			startActivity(intent);
			finish();
			break;
		}

	}
}
