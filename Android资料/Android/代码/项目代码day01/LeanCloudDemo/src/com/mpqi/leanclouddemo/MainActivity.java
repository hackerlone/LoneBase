package com.mpqi.leanclouddemo;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVUser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private TextView contentTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		contentTextView = (TextView) findViewById(R.id.content);
	}

	public void myOnclick(View view) {
		Intent intent = new Intent(this, LoginOrRegisAtctivity.class);
		switch (view.getId()) {
		case R.id.button1:
			intent.putExtra("requestCode", 1);
			startActivityForResult(intent, 1);
			break;

		case R.id.button2:
			intent.putExtra("requestCode", 2);
			startActivityForResult(intent, 2);
			break;
		case R.id.button3://直接登录
			AVUser avUser = AVUser.getCurrentUser();
			if (avUser != null) {//存在缓存
				String username = avUser.getUsername();
				contentTextView.setText(username+" 直接登录成功了！");
			}else {
				contentTextView.setText("当前没有缓存用户可用");
			}
			break;
		case R.id.button4://退出登录
			AVUser.logOut();
			contentTextView.setText("退出成功");
			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (resultCode) {
		case 1://登录
			Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
			AVUser user = data.getParcelableExtra("user");
			contentTextView.setText(user.getUsername()+"登录成功");
			break;

		case 2://注册
			Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
			AVUser user1 = data.getParcelableExtra("user");
			contentTextView.setText(user1.getUsername()+"注册成功");
			break;
		}
	}
}
