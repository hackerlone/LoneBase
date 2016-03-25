package com.mpqi.mphonebook;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.Contacts;
import android.support.v4.widget.CursorAdapter;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AlphabetIndexer;
import android.widget.ListView;
import android.widget.SectionIndexer;
import android.widget.TextView;

/**
 * 电话簿
 * 
 * @author mpqi
 *
 */
public class TelephoneDirAcitivty extends Activity {
	private Cursor cursor;
	private ListView mTelephoneDirListView;
	private LayoutInflater inflater;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telephonedir_layout);
		initView();
		initTelephoneDir();
	}

	private void initView() {
		mTelephoneDirListView = (ListView) findViewById(R.id.telephonedir_listvew);
		inflater = LayoutInflater.from(this);
	}

	private void initTelephoneDir() {
		ContentResolver resolver = getContentResolver();
		String[] projection = new String[] {
				ContactsContract.CommonDataKinds.Phone._ID,
				ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
				ContactsContract.CommonDataKinds.Phone.NUMBER
				,ContactsContract.CommonDataKinds.Phone.MIMETYPE};
		cursor = resolver.query(
				ContactsContract.CommonDataKinds.Phone.CONTENT_URI, projection,
				null, null,
				ContactsContract.CommonDataKinds.Phone.SORT_KEY_PRIMARY);
		
		mTelephoneDirListView.setAdapter(new CursorAdapter(this, cursor) {

			@Override
			public View newView(Context arg0, Cursor arg1, ViewGroup arg2) {
				return inflater.inflate(R.layout.telephonedir_item, null);
			}

			@Override
			public void bindView(View view, Context context, Cursor cursor) {
				TextView nameTextView = (TextView) view
						.findViewById(R.id.telephonedir_item_name);
				TextView phoneTextView = (TextView) view
						.findViewById(R.id.telephonedir_item_num);

				String name = cursor.getString(1);
				String phone = cursor.getString(2);
				int type = cursor.getInt(3);
				String typetext = "-";
				
				nameTextView.setText(name);
				phoneTextView.setText(phone);
				switch (type) {
				case ContactsContract.CommonDataKinds.Phone.TYPE_HOME:
					typetext = "住宅";
					break;
				case ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE:
					typetext = "手机";
					break;
				case ContactsContract.CommonDataKinds.Phone.TYPE_COMPANY_MAIN:
					typetext = "单位";
					break;
				case ContactsContract.CommonDataKinds.Phone.TYPE_FAX_HOME:
					typetext = "家里传真";
					break;
				case ContactsContract.CommonDataKinds.Phone.TYPE_FAX_WORK:
					typetext = "单位传真";
					break;					
				}
				Log.e("test", typetext);
			}
		});
		
		
	}

	/**
	 * 底部菜单栏点击事件
	 * 
	 * @param view
	 */
	public void footbarOnclick(View view) {
		Intent intent = null;
		switch (view.getId()) {
		case R.id.gophonenumbers:
			intent = new Intent(this, PhoneNumbersActivity.class);
			startActivity(intent);
			finish();
			break;
		case R.id.gocalllog:
			intent = new Intent(this, CallLogActivity.class);
			startActivity(intent);
			finish();
			break;

		case R.id.gocall:
			intent = new Intent(this, CallActivity.class);
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
