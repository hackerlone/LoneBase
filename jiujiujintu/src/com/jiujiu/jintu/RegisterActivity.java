package com.jiujiu.jintu;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.LogInCallback;
import com.avos.avoscloud.RequestMobileCodeCallback;
import com.jiujiu.jintu.util.Code;

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
	private ImageView verCodeImageView;
	private String realCode;// 验证码
	private EditText phoneEditText// 手机号框
			,
			pwdEditText// 密码框
			, verificationCodeEditText // 验证码框
			, phonecodeEditText; // 手机验证码框
	private ImageView showPwdImageView;// 显示密码 隐藏密码
	private boolean showPwdFlag = false;// false 隐藏 true 显示
	private String phonenum// 手机号码
			,
			verificationCode // 验证码
			, phoneCode// 手机验证码
			, password;// 密码

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_regist);
		initView();
	}

	public void initView() {
		pwdEditText = (EditText) findViewById(R.id.regist_edt_pwd);
		phoneEditText = (EditText) findViewById(R.id.regist_edit_phone);
		verificationCodeEditText = (EditText) findViewById(R.id.regist_edit_verification_code);
		phonecodeEditText = (EditText) findViewById(R.id.regist_edit_phone_code);
		
		showPwdImageView = (ImageView) findViewById(R.id.regist_img_show_pwd);
		verCodeImageView = (ImageView) findViewById(R.id.regist_img_verification_code);
		// 将验证码用图片的形式显示出来
		verCodeImageView.setImageBitmap(Code.getInstance().createBitmap());
		realCode = Code.getInstance().getCode();
	}

	public void btnOnclick(View view) {
		int id = view.getId();
		switch (id) {
		case R.id.regist_close:// 关闭
			finish();
			break;
		case R.id.regist_img_verification_code:// 验证码更换
			initVerificationCode();
			break;
		case R.id.regist_img_show_pwd:// 显示密码 隐藏密码
			if (showPwdFlag) {
				showPwdFlag = false;
				pwdEditText.setInputType(InputType.TYPE_CLASS_TEXT
						| InputType.TYPE_TEXT_VARIATION_PASSWORD);
				showPwdImageView.setImageResource(R.drawable.show_password);
			} else {
				showPwdFlag = true;
				pwdEditText
						.setInputType((InputType.TYPE_CLASS_TEXT
								| InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD));
				showPwdImageView
						.setImageResource(R.drawable.show_password_pressed);
			}
			break;
		case R.id.regist_text_phone_code:// 发送验证码
			phonenum = phoneEditText.getText().toString();// 获取电话号码
			if (isMobileNO(phonenum)) {// 通过电话号码验证

				new Thread(new Runnable() {

					@Override
					public void run() {
						try {
							AVOSCloud.requestSMSCode(phonenum, getResources()
									.getString(R.string.app_name), "新用户注册", 5);// 发送验证码、手机号、应用名、操作名、10分钟
						} catch (AVException e) {
							e.printStackTrace();
						}
					}
				}).start();

			} else {
				Toast.makeText(this, "手机号码输入不正确", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.regist_btn_regist:// 点击注册
			phonenum = phoneEditText.getText().toString();
			password = pwdEditText.getText().toString();
			verificationCode = verificationCodeEditText.getText().toString();
			phoneCode = phonecodeEditText.getText().toString();
			if (TextUtils.isEmpty(verificationCode)) {// 验证码为空
				Toast.makeText(this, "验证码不能为空", Toast.LENGTH_SHORT).show();
				initVerificationCode();
				return;
			} else if (!realCode.toLowerCase().equals(verificationCode.toLowerCase())) {
				Toast.makeText(this, "验证码错了", Toast.LENGTH_SHORT).show();
				initVerificationCode();
				return;
			}
			if (TextUtils.isEmpty(phonenum)) {
				Toast.makeText(this, "手机号码不能为空", Toast.LENGTH_SHORT).show();
				initVerificationCode();
				return;
			} else if (!isMobileNO(phonenum)) {
				Toast.makeText(this, "手机号码输入不正确", Toast.LENGTH_SHORT).show();
				initVerificationCode();
				return;
			}
			if (TextUtils.isEmpty(phoneCode)) {
				Toast.makeText(this, "手机验证码不能为空", Toast.LENGTH_SHORT).show();
				initVerificationCode();
				return;
			}
			if (TextUtils.isEmpty(password)) {
				Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
				initVerificationCode();
				return;
			} else if (password.length() < 6 || password.length() > 16) {
				Toast.makeText(this, "密码长度为6到16位", Toast.LENGTH_SHORT).show();
				initVerificationCode();
				return;
			}
			AVUser.signUpOrLoginByMobilePhoneInBackground(phonenum,
					phoneCode, new LogInCallback<AVUser>() {
						public void done(AVUser user, AVException e) {
							// 至此就完成了注册或登录的功能。用户的用户名即为手机号码
							if (e == null) {// 验证成功
								user.setPassword(password);
								user.saveInBackground();
								Toast.makeText(RegisterActivity.this,
										"恭喜您，注册成功！", Toast.LENGTH_SHORT).show();
							} else {// 验证失败
								Toast.makeText(RegisterActivity.this,
										"手机验证码输入错误", Toast.LENGTH_SHORT).show();
							}

						}
					});
			break;
		}

	}

	private void initVerificationCode() {
		verificationCodeEditText.setText("");
		verCodeImageView.setImageBitmap(Code.getInstance().createBitmap());
		realCode = Code.getInstance().getCode();
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
			finish();
		}
		return false;
	}
}
