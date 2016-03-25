package com.mpqi.homewrokday07;

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
		setContentView(R.layout.userinfo_main);
	}

	public void UserInfoBtnOnclick(View view) {
		int id = view.getId();
		Intent intent = null;
		switch (id) {
		case R.id.btn_login:
			intent = new Intent(this, LoginActivity.class);
			startActivity(intent);
			break;
		case R.id.btn_regist:
			intent = new Intent(this, RegistActivity.class);
			startActivity(intent);
			break;
		}
	}
}
