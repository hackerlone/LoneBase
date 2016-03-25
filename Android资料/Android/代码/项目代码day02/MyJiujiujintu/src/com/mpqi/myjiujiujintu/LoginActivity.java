package com.mpqi.myjiujiujintu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

public class LoginActivity extends Activity {
	private View jiujiuView, peopleView, dynamictextView, jiujiubtnView,
			dynamicbtnView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_login);
		initView();
	}

	private void initView() {
		jiujiuView = findViewById(R.id.login_label_jiujiu);
		peopleView = findViewById(R.id.login_label_people);
		dynamictextView = findViewById(R.id.login_text_dynamic);
		jiujiubtnView = findViewById(R.id.login_btn_jiujiu);
		dynamicbtnView = findViewById(R.id.login_btn_dynamic);
	}

	/**
	 * 按钮点击事件
	 * 
	 * @param view
	 */
	public void btnOnClick(View view) {
		int id = view.getId();
		switch (id) {
		case R.id.login_close:// 关闭按钮
			finish();
			return;
		case R.id.login_btn_jiujiu:// 点击久久账户登录
			jiujiuView.setVisibility(View.VISIBLE);
			peopleView.setVisibility(View.GONE);
			dynamictextView.setVisibility(View.GONE);
			jiujiubtnView
					.setBackgroundResource(R.drawable.bg_left_corner_green_5dp);
			dynamicbtnView
					.setBackgroundResource(R.drawable.bg_right_green_stroke_corner_5dp);
			return;
		case R.id.login_btn_dynamic:// 点击动态密码
			jiujiuView.setVisibility(View.GONE);
			peopleView.setVisibility(View.VISIBLE);
			dynamictextView.setVisibility(View.VISIBLE);
			jiujiubtnView
					.setBackgroundResource(R.drawable.bg_left_green_stroke_corner_5dp);
			dynamicbtnView
					.setBackgroundResource(R.drawable.bg_right_corner_green_5dp);
			return;
		case R.id.login_btn_login:// 点击登录
			break;
		case R.id.login_btn_regist:// 点击注册新用户
//			startActivity(new Intent(this, RegisterActivity.class));
//			finish();
			break;
		}

	}

	/**
	 * 返回键响应
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			finish();
		}
		return false;
	}
}
