package com.mpqi.logindemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity {

	private Button commitBtn;
	private EditText contentEd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_layout);

		commitBtn = (Button) findViewById(R.id.commit_btn);
		contentEd = (EditText) findViewById(R.id.login_ed);

		commitBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String content = contentEd.getText().toString();
				Intent intent = new Intent();
				if (content.equals("abc")) {
					intent.putExtra("content", content);
					// resultCode 结果返回码
					setResult(2, intent);
				} else {//错误的情况
					intent.putExtra("content", "你真的错了！！！");
					// resultCode 结果返回码
					setResult(3, intent);
				}

				finish();
			}
		});
	}
}
