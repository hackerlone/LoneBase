package com.mpqi.othersysprovider;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.Inflater;

import android.R.integer;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.CallLog;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

public class CallLogActivity extends Activity {
	private ListView myListView;
	private Cursor cursor;
	private LayoutInflater inflater;
	private CursorAdapter cursorAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listlayout);
		myListView = (ListView) findViewById(R.id.list);
		inflater = getLayoutInflater();

		ContentResolver cr = getContentResolver();
		cursor = cr.query(CallLog.Calls.CONTENT_URI, new String[] {
				CallLog.Calls.NUMBER, CallLog.Calls.CACHED_NAME,
				CallLog.Calls.TYPE, CallLog.Calls.DATE, CallLog.Calls.DURATION,
				CallLog.Calls._ID }, null, null,
				CallLog.Calls.DEFAULT_SORT_ORDER);
		initCursorAdapter();
		myListView.setAdapter(cursorAdapter);
	}

	private void initCursorAdapter() {
		cursorAdapter = new CursorAdapter(this, cursor) {

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

				String phone = null;
				String name = null;
				Date date = null;
				String time = null;
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
				} else {// 名字不为空
					nameTextView.setText(name);
					phoneTextView.setText(phone);
				}

				long diff = System.currentTimeMillis()
						- Long.parseLong(cursor.getString(3));
				long days = diff / (1000 * 60 * 60 * 24);// 得出天数
				long hours = (diff - days * (1000 * 60 * 60 * 24))
						/ (1000 * 60 * 60);// 得出小时
				long minutes = (diff - days * (1000 * 60 * 60 * 24) - hours
						* (1000 * 60 * 60))
						/ (1000 * 60);// 得出分钟

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
	}

	@Override
	protected void onDestroy() {
		cursor.close();
		super.onDestroy();
	}
}
