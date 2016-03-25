package com.mpqi.dialogdemo;

import com.mpqi.dialogdemo.LoginDialogFragment.LoginInputListener;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements LoginInputListener {

	private EditText usernameEditText, pwdEditText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	public void DialogOnclick(View view) {
		switch (view.getId()) {
		case R.id.btn_1:
			normalDialog();
			break;
		case R.id.btn_2:
			listDialog();
			break;
		case R.id.btn_3:
			RadioButtonDialog();
			break;
		case R.id.btn_4:
			MultiChoiceDialog();
			break;
		case R.id.btn_5:
			loginDialog();
			break;
		case R.id.btn_6:
			EditNameDialogFragment dialogFragment = new EditNameDialogFragment();
			dialogFragment.show(getFragmentManager(), "EditNameDialog");
			break;
		case R.id.btn_7:
			LoginDialogFragment loginDialogFragment = new LoginDialogFragment();
			loginDialogFragment.show(getFragmentManager(), "LoginDialog");
			break;
		}
	}

	/**
	 * 显示一般对话框
	 */
	private void normalDialog() {
		AlertDialog.Builder dialog = new AlertDialog.Builder(this);
		dialog.setTitle("提示");
		dialog.setMessage("你确定要退出么？");
		dialog.setIcon(R.drawable.ic_launcher);// 设置标题图 选填
		dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this, "你点击了确定", Toast.LENGTH_SHORT)
						.show();
				dialog.dismiss();// 对话框消失
			}
		});
		dialog.setNeutralButton("忽略", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this, "你点击了忽略", Toast.LENGTH_SHORT)
						.show();
				dialog.dismiss();// 对话框消失
			}
		});
		dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this, "你点击了取消", Toast.LENGTH_SHORT)
						.show();
				dialog.dismiss();// 对话框消失
			}
		});

		dialog.create();// 创建dialog
		dialog.show();// 显示dialog
	}

	/**
	 * 列表对话框
	 */
	private void listDialog() {
		final String[] items = new String[] { "张三", "李四", "王五", "赵六" };
		AlertDialog.Builder dialog = new AlertDialog.Builder(this);
		dialog.setTitle("提示");
		dialog.setIcon(R.drawable.ic_launcher);
		dialog.setItems(items, new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this, items[which],
						Toast.LENGTH_SHORT).show();

			}
		});
		dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this, "你点击了确定", Toast.LENGTH_SHORT)
						.show();
				dialog.dismiss();// 对话框消失
			}
		});
		dialog.create();// 创建对话框
		dialog.show();// 显示对话框
	}

	/**
	 * 单选按钮对话框
	 */
	private void RadioButtonDialog() {
		final String[] items = new String[] { "Java", ".net", "Android", "php",
				"ast" };
		AlertDialog.Builder dialog = new AlertDialog.Builder(this);
		dialog.setTitle("提示");
		dialog.setIcon(R.drawable.ic_launcher);
		dialog.setSingleChoiceItems(items, 2,
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(MainActivity.this, items[which],
								Toast.LENGTH_SHORT).show();
						;

					}
				});
		dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this, "你点击了确定", Toast.LENGTH_SHORT)
						.show();
				dialog.dismiss();// 对话框消失
			}
		});
		dialog.create().show();
	}

	/**
	 * 多选按钮对话框
	 */
	private void MultiChoiceDialog() {
		final String[] items = new String[] { "Java", ".net", "Android", "php",
				"ast" };
		boolean[] checkedItems = new boolean[] { false, true, false, false,
				true };
		AlertDialog.Builder dialog = new AlertDialog.Builder(this);
		dialog.setTitle("提示");
		dialog.setIcon(R.drawable.ic_launcher);
		dialog.setMultiChoiceItems(items, checkedItems,
				new DialogInterface.OnMultiChoiceClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which,
							boolean isChecked) {
						Toast.makeText(MainActivity.this,
								items[which] + isChecked, Toast.LENGTH_SHORT)
								.show();
					}
				});
		dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this, "你点击了确定", Toast.LENGTH_SHORT)
						.show();
				dialog.dismiss();// 对话框消失
			}
		});
		dialog.create().show();
	}

	/**
	 * 自定义样式对话框（登录框）
	 */
	private void loginDialog() {
		LayoutInflater layout = LayoutInflater.from(this);
		View view = layout.inflate(R.layout.login_main, null);

		usernameEditText = (EditText) view.findViewById(R.id.ed_username);
		pwdEditText = (EditText) view.findViewById(R.id.ed_password);

		AlertDialog.Builder dialog = new AlertDialog.Builder(this);
		dialog.setTitle("请登录");
		dialog.setIcon(R.drawable.ic_launcher);
		dialog.setView(view);
		dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this, "点击了取消", Toast.LENGTH_SHORT)
						.show();
				dialog.dismiss();
			}
		});
		dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(
						MainActivity.this,
						"点击了确定\t" + "用户名："
								+ usernameEditText.getText().toString()
								+ "\t密码:" + pwdEditText.getText().toString(),
						Toast.LENGTH_SHORT).show();
				dialog.dismiss();
			}
		});
		dialog.create().show();
	}

	@Override
	public void onLoginInputComplete(String username, String password) {
		Toast.makeText(this, "帐号：" + username + ",  密码 :" + password,
				Toast.LENGTH_SHORT).show();
	}
}
