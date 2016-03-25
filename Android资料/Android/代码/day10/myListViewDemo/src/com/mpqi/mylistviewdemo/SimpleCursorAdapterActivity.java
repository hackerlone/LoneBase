package com.mpqi.mylistviewdemo;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.Contacts.People;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class SimpleCursorAdapterActivity extends Activity {
	private ListView myListView;
	private Cursor myCursor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.demolistview);
		myListView = (ListView) findViewById(R.id.list);
		myCursor = getContentResolver().query(People.CONTENT_URI, null, null,
				null, null);
		startManagingCursor(myCursor);
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
				android.R.layout.simple_expandable_list_item_1, myCursor,
				new String[] { People.NAME }, new int[] { android.R.id.text1 });
		myListView.setAdapter(adapter);
	}
}
