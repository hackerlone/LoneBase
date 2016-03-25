package com.mpqi.othersysprovider;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

/**
 * 电话簿
 * @author mpqi
 *
 */
public class TelephoneDirAcitivty extends Activity {
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
		cursor = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
				new String[] { ContactsContract.CommonDataKinds.Phone._ID,
						ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
						ContactsContract.CommonDataKinds.Phone.NUMBER,
						ContactsContract.CommonDataKinds.Phone.MIMETYPE },
				null, null,
				ContactsContract.CommonDataKinds.Phone.SORT_KEY_PRIMARY);
		initCursorAdapter();
		myListView.setAdapter(cursorAdapter);
	}

	private void initCursorAdapter() {
		cursorAdapter = new CursorAdapter(this, cursor) {

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
				TextView typeTextView = (TextView) view
						.findViewById(R.id.telephonedir_item_type);

				String name = cursor.getString(1);
				String phone = cursor.getString(2);
				int type = cursor.getInt(3);
				String typetext = "手机";

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
				typeTextView.setText(typetext);
			}
		};
	}
}
