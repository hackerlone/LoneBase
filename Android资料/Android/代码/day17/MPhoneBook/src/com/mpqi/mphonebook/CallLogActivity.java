package com.mpqi.mphonebook;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.CallLog;
import android.provider.CallLog.Calls;
import android.support.v4.widget.CursorAdapter;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class CallLogActivity extends Activity {
	private Button callLogBtn;
	private ListView callLogListView;
	private Cursor cursor;
	private LayoutInflater inflater;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.calllog_layout);
		initView();
		callLogValues();
	}

	/**
	 * 初始化控件
	 */
	private void initView() {
		callLogBtn = (Button) findViewById(R.id.gocalllog);
		callLogBtn.setBackgroundColor(getResources()
				.getColor(R.color.lightblue));
		callLogListView = (ListView) findViewById(R.id.calllog_listvew);
		inflater = LayoutInflater.from(this);
	}

	private void callLogValues() {
		ContentResolver cr = getContentResolver();
		cursor = cr.query(CallLog.Calls.CONTENT_URI, new String[] {
				CallLog.Calls.NUMBER, CallLog.Calls.CACHED_NAME,
				CallLog.Calls.TYPE, CallLog.Calls.DATE, CallLog.Calls.DURATION,
				CallLog.Calls._ID }, null, null,
				CallLog.Calls.DEFAULT_SORT_ORDER);
		CursorAdapter cursorAdapter = new CursorAdapter(this, cursor) {

			@Override
			public View newView(Context arg0, Cursor arg1, ViewGroup arg2) {
				return inflater.inflate(R.layout.calllog_item, null);
			}

			@Override
			public void bindView(View view, Context arg1, Cursor cursor) {
				TextView nameTextView = (TextView) view
						.findViewById(R.id.phonename);
				TextView phoneTextView = (TextView) view
						.findViewById(R.id.phone);
				TextView timeTextView = (TextView) view
						.findViewById(R.id.phonetime);
				TextView typeTextView = (TextView) view
						.findViewById(R.id.phonetype);
				Date date = null;
				Date sysdate = null;
				String time = null;
				String phone = null;
				String name = null;
				int type;

				phone = cursor.getString(0);
				name = cursor.getString(1);

				if (TextUtils.isEmpty(name)) {

					if (phone.trim().equals("-1")) {
						nameTextView.setText("未知");
					} else {
						nameTextView.setText(phone);
					}
					phoneTextView.setText("-");

				} else {
					nameTextView.setText(name);
					phoneTextView.setText(phone);
				}

				long diff = System.currentTimeMillis()
						- Long.parseLong(cursor.getString(3));
				long days = diff / (1000 * 60 * 60 * 24);

				long hours = (diff - days * (1000 * 60 * 60 * 24))
						/ (1000 * 60 * 60);
				long minutes = (diff - days * (1000 * 60 * 60 * 24) - hours
						* (1000 * 60 * 60))
						/ (1000 * 60);
				if (days > 7) {
					date = new Date(Long.parseLong(cursor.getString(3)));
					SimpleDateFormat sfd = new SimpleDateFormat(
							"MM-dd hh:mm:ss");
					time = sfd.format(date);
				} else if (days > 0 && days < 8) {
					time = days + " 天前";
				} else if (days < 1 && hours > 0) {
					time = hours + " 小时前";
				} else if (hours < 1 && minutes > 0) {
					time = minutes + " 分钟前";
				} else if (minutes < 1) {
					time = "0 分钟前";
				}

				timeTextView.setText(time);

				type = cursor.getInt(2);// 来电:1,拨出:2,未接:3
				// public static final int INCOMING_TYPE = 1;
				// public static final int OUTGOING_TYPE = 2;
				// public static final int MISSED_TYPE = 3;

				switch (type) {
				case 1:
					typeTextView.setText("来电");
					break;
				case 2:
					typeTextView.setText("拨出");
					break;
				case 3:
					typeTextView.setText("未接");
					break;
				}

			}
		};
		callLogListView.setAdapter(cursorAdapter);
	}

	private void calllogvalues1111() {

		String strNumber, strName = "";
		int type;
		long callTime;
		Date date;
		String time = "";
		ContentResolver cr = getContentResolver();
		final Cursor cursor = cr.query(CallLog.Calls.CONTENT_URI,
				new String[] { CallLog.Calls.NUMBER, CallLog.Calls.CACHED_NAME,
						CallLog.Calls.TYPE, CallLog.Calls.DATE,
						CallLog.Calls.DURATION }, null, null,
				CallLog.Calls.DEFAULT_SORT_ORDER);
		cursor.moveToPosition(0);
		strNumber = cursor.getString(0); // 呼叫号码
		strName = cursor.getString(1); // 联系人姓名
		type = cursor.getInt(2); // 来电:1,拨出:2,未接:3 public static final int
									// INCOMING_TYPE = 1; public static final
									// int OUTGOING_TYPE = 2; public static
									// final int MISSED_TYPE = 3;
		long duration = cursor.getLong(4);
		SimpleDateFormat sfd = new SimpleDateFormat("MM-dd hh:mm:ss");// yyyy-MM-dd
																		// hh:mm:ss
		date = new Date(Long.parseLong(cursor.getString(3)));
		time = sfd.format(date);
		System.out.println("------" + duration);
		System.out.println("?????" + strNumber);
		System.out.println("?????" + time);
		System.out.println("?????" + strName);
		System.out.println("?????" + type);
	}

	/**
	 * 底部菜单栏点击事件
	 * 
	 * @param view
	 */
	public void footbarOnclick(View view) {
		Intent intent = null;
		switch (view.getId()) {
		case R.id.gocall:
			intent = new Intent(this, CallActivity.class);
			startActivity(intent);
			finish();
			break;
		case R.id.gophonenumbers:
			intent = new Intent(this, PhoneNumbersActivity.class);
			startActivity(intent);
			finish();
			break;
		case R.id.gotelephonedir:
			intent = new Intent(this, TelephoneDirAcitivty.class);
			startActivity(intent);
			finish();
			break;
		}

	}

	@Override
	protected void onDestroy() {
		cursor.close();
		super.onDestroy();
	}
}
