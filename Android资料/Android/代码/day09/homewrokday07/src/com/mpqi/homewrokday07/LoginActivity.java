package com.mpqi.homewrokday07;

import com.mpqi.homewrokday07.cfg.CONFIG;
import com.mpqi.homewrokday07.cfg.User;
import com.mpqi.homewrokday07.cfg.Users;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {

	private EditText usernameEditText // 用户名
			,
			pwdEditText;// 密码
	private Button commitBtn;// 提交按钮

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.userlogin_main);
		initViews();
		commitBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// 获取用户名和密码
				String username = usernameEditText.getText().toString();
				String pwd = pwdEditText.getText().toString();
				//判断输入框不为空
				if (TextUtils.isEmpty(username) || TextUtils.isEmpty(pwd)) {
					Toast.makeText(LoginActivity.this, "用户名密码不能为空", Toast.LENGTH_SHORT).show();
					return;
				}
				// 比对用户名和密码
				// 用户名不存在或者输入错误
				if (!Users.isUser(username)) {
					Toast.makeText(LoginActivity.this, "用户名不存在或者输入错误", Toast.LENGTH_SHORT).show();
					return;
				}
				//密码输入错误
				if (!Users.login(username, pwd)) {
					Toast.makeText(LoginActivity.this, "密码输入错误", Toast.LENGTH_SHORT).show();
					return;
				}
				//用户名和密码输入正确  登录
				// 跳转  返回  useranme
				Intent intent = new Intent();
				intent.putExtra(User.USERNAME, username);
				setResult(CONFIG.login_RESULTCODE, intent);
				finish();
			}
		});
	}

	private void initViews() {
		usernameEditText = (EditText) findViewById(R.id.login_username);
		pwdEditText = (EditText) findViewById(R.id.login_pwd);
		commitBtn = (Button) findViewById(R.id.login_commit);
	}
}
