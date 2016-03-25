package com.mpqi.myjiujiujintu;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.LogInCallback;
import com.avos.avoscloud.SignUpCallback;
import com.mpqi.myjiujiujintu.util.JJJCONFIG;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class RegisterActivity extends Activity {
	private EditText usernameEdit, pwdEdit, phoneEdit;
	private ImageView showPwdImageView;// 显示密码 隐藏密码
	private boolean showPwdFlag = false;// false 隐藏 true 显示

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_regist);
		initView();
	}

	private void initView() {
		usernameEdit = (EditText) findViewById(R.id.regist_edit_user);
		pwdEdit = (EditText) findViewById(R.id.regist_edt_pwd);
		phoneEdit = (EditText) findViewById(R.id.regist_edit_phone);
		showPwdImageView = (ImageView) findViewById(R.id.regist_img_show_pwd);

	}

	public void btnOnclick(View viwe) {
		switch (viwe.getId()) {
		case R.id.regist_img_show_pwd:// 显示密码 隐藏密码
			if (showPwdFlag) {
				showPwdFlag = false;
				pwdEdit.setInputType(InputType.TYPE_CLASS_TEXT
						| InputType.TYPE_TEXT_VARIATION_PASSWORD);
				showPwdImageView.setImageResource(R.drawable.show_password);
			} else {
				showPwdFlag = true;
				pwdEdit.setInputType((InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD));
				showPwdImageView
						.setImageResource(R.drawable.show_password_pressed);
			}
			break;
		case R.id.regist_btn_regist:

			final String username = usernameEdit.getText().toString();
			final String pwd = pwdEdit.getText().toString();
			String phone = phoneEdit.getText().toString();

			if (TextUtils.isEmpty(username)) {
				Toast.makeText(this, "用户名不能为空哦！", Toast.LENGTH_SHORT).show();
				return;
			}

			if (TextUtils.isEmpty(pwd)) {
				Toast.makeText(this, "密码不能为空哦！", Toast.LENGTH_SHORT).show();
				return;
			}

			if (pwd.length() < 6 || pwd.length() > 16) {
				Toast.makeText(this, "密码长度为6到16位", Toast.LENGTH_SHORT).show();
				return;
			}

			AVUser user = new AVUser();
			user.setUsername(username);
			user.setPassword(pwd);

			if (!TextUtils.isEmpty(phone)) {
				if (!isMobileNO(phone)) {
					Toast.makeText(this, "手机号码输入不正确！", Toast.LENGTH_SHORT)
							.show();
					return;
				}
				// 其他属性可以像其他AVObject对象一样使用put方法添加
				user.put("phone", phone);
			}
			user.signUpInBackground(new SignUpCallback() {
				public void done(AVException e) {
					if (e == null) {
						AVUser.logInInBackground(username, pwd,
								new LogInCallback<AVUser>() {

									@Override
									public void done(AVUser arg0,
											AVException arg1) {
										setResult(JJJCONFIG.REGIST_RESULT_SUCCESS);
										finish();

									}
								});

					} else {
						switch (e.getCode()) {
						case AVException.USERNAME_TAKEN:
							Toast.makeText(RegisterActivity.this,
									"用户名已经被注册过了，亲，换一个吧 (づ￣3￣)づ╭❤～！",
									Toast.LENGTH_SHORT).show();
							break;
						}
					}
				}
			});
			break;
		}
	}

	/**
	 * 验证手机格式
	 */
	private boolean isMobileNO(String mobiles) {
		/*
		 * 移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
		 * 联通：130、131、132、152、155、156、185、186 电信：133、153、180、189、（1349卫通）
		 * 总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
		 */
		String telRegex = "[1][358]\\d{9}";// "[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
		if (TextUtils.isEmpty(mobiles))
			return false;
		else
			return mobiles.matches(telRegex);
	}

	/**
	 * 返回键响应
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			setResult(JJJCONFIG.REGIST_RESULT);
			finish();
		}
		return false;
	}
}
