package com.mpqi.leanclouddemo;

import java.io.IOException;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.LogInCallback;
import com.avos.avoscloud.SignUpCallback;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class LoginOrRegisAtctivity extends Activity {
	private EditText usernameEdt;
	private EditText pwdEdt;
	private int requestCode;// 1 µÇÂ¼ 2 ×¢²á

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_main);
		usernameEdt = (EditText) findViewById(R.id.editText1);
		pwdEdt = (EditText) findViewById(R.id.editText2);

		requestCode = getIntent().getIntExtra("requestCode", 1);
	}

	public void myOnclick(View view) {
		String username = usernameEdt.getText().toString();
		String password = pwdEdt.getText().toString();
		
		
		
		switch (requestCode) {
		case 1://µÇÂ¼
			AVUser.logInInBackground(username, password, new LogInCallback<AVUser>() {

				@Override
				public void done(AVUser user, AVException e) {
					if (e == null) {
						Intent data = new Intent();
						data.putExtra("user", user);
						setResult(1, data);
						finish();
					}else {
						e.printStackTrace();
						Log.i("test", "µÇÂ¼Ê§°Ü");
					}
				}
			});
			
//			setResult(resultCode, data);
			break;

		case 2://×¢²á
			final AVUser avUser = new AVUser();
			avUser.setUsername(username);
			avUser.setPassword(password);
			avUser.setEmail("");
			
			avUser.signUpInBackground(new SignUpCallback() {
				
				@Override
				public void done(AVException e) {
					if (e == null) {
						Intent data = new Intent();
						data.putExtra("user", avUser);
						setResult(2, data);
						finish();
					}else {
						e.printStackTrace();
						Log.i("test", "×¢²áÊ§°Ü");
					}
					
				}
			});
			
			break;
		}
	}

}
