package com.mpqi.animationdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	public void myOnlick(View view) {
		Intent intent = null;
		switch (view.getId()) {
		case R.id.button1:
			intent = new Intent(this , AlphaActivity.class);
			startActivity(intent);
			break;
		case R.id.button2:
			intent = new Intent(this , RotateActivity.class);
			startActivity(intent);
			break;

		case R.id.button3:
			intent = new Intent(this , ScaleActivity.class);
			startActivity(intent);
			break;

		case R.id.button4:
			intent = new Intent(this , TranslateActivity.class);
			startActivity(intent);
			break;

		case R.id.button5:
			intent = new Intent(this , FrameActivity.class);
			startActivity(intent);
			break;
		}
	}
}
