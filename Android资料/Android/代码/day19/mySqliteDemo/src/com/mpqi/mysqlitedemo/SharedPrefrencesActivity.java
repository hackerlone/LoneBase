package com.mpqi.mysqlitedemo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SharedPrefrencesActivity extends Activity {

	private EditText keyEditText;
	private EditText valueEditText;
	private TextView contentTextView;
	public static final String PATH = "/data/data/com.mpqi.mysqlitedemo/shared_prefs/shared_demo.xml";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shared_main);

		initView();
	}

	private void initView() {
		keyEditText = (EditText) findViewById(R.id.key);
		valueEditText = (EditText) findViewById(R.id.value);
		contentTextView = (TextView) findViewById(R.id.content);

	}

	public void myOnclick(View view) {
		// 获取SharedPreferences对象
		SharedPreferences sp = getSharedPreferences("shared_demo",
				Activity.MODE_PRIVATE);
		// 获取Editor对象
		Editor editor = sp.edit();
		switch (view.getId()) {
		case R.id.insert:
			editor.putString(keyEditText.getText().toString(), valueEditText
					.getText().toString());
			editor.commit();
			break;

		case R.id.delete:
			editor.remove(keyEditText.getText().toString());
			editor.commit();
			break;
		case R.id.modify:
			editor.putString(keyEditText.getText().toString(), valueEditText
					.getText().toString());
			editor.commit();
			break;
		case R.id.query:
			String value = sp
					.getString(keyEditText.getText().toString(), "没有值");
			valueEditText.setText(value);
			break;
		case R.id.clear:
			editor.clear();
			editor.commit();
			break;
		}
		contentTextView.setText(print());
	}

	/** 获取存储文件的数据 */
	private String print() {
		StringBuffer buff = new StringBuffer();
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					new FileInputStream(PATH)));
			String str;
			while ((str = reader.readLine()) != null) {
				buff.append(str + "\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return buff.toString();
	}
}
