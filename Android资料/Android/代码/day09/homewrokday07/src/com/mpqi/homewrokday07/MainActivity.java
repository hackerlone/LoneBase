package com.mpqi.homewrokday07;

import com.mpqi.homewrokday07.cfg.CONFIG;
import com.mpqi.homewrokday07.cfg.User;
import com.mpqi.homewrokday07.cfg.Users;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.UserDictionary.Words;
import android.text.LoginFilter.UsernameFilterGeneric;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class MainActivity extends Activity {

	private ImageView lheadImageView;// 头像
	private TextView lusernameTextView;// 昵称
	private TextView lwordTextView;// 签名
	private View lbtnsView;// 包含了两个按钮的控件
	private ListView lusersLsitView;// 所有注册用户的列表
	private SimpleAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.userinfo_main);
		initViews();
	}

	public void UserInfoBtnOnclick(View view) {
		int id = view.getId();
		Intent intent = null;
		switch (id) {
		case R.id.btn_login:
			intent = new Intent(this, LoginActivity.class);
			startActivityForResult(intent, CONFIG.login_REQUESTCODE);
			break;
		case R.id.btn_regist:
			intent = new Intent(this, RegistActivity.class);
			startActivity(intent);
			break;
		}
	}

	private void initViews() {
		lheadImageView = (ImageView) findViewById(R.id.userhead);
		lusernameTextView = (TextView) findViewById(R.id.username);
		lwordTextView = (TextView) findViewById(R.id.word);
		lbtnsView = findViewById(R.id.userinfo_btns);
		lusersLsitView = (ListView) findViewById(R.id.userslist);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == CONFIG.login_REQUESTCODE
				&& resultCode == CONFIG.login_RESULTCODE) {// 登录成功
			String username = data.getStringExtra(User.USERNAME);//获取绑定的用户名
			User user = Users.getUserByUserName(username);
			lheadImageView.setImageResource(user.getHead());
			lusernameTextView.setText(user.getUsername());
			lwordTextView.setText(user.getWord());
			lwordTextView.setVisibility(View.VISIBLE);
			lbtnsView.setVisibility(View.GONE);
			lusersLsitView.setVisibility(View.VISIBLE);
//			adapter = new SimpleAdapter(this, Users.getAllUsersMaps(), resource, from, to)
		}
	}
}
