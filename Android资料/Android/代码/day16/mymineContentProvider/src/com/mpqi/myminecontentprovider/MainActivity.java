package com.mpqi.myminecontentprovider;

import com.mpqi.myminecontentprovider.bean.Person;

import android.R.integer;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button mAddButton;
	private Button mDeleteButton;
	private Button mUpdateButton;
	private Button mQueryButton;
	private Button mQueryAllButton;
	private Button mTypeButton;
	private ContentResolver mContentResolver;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
	}

	private void init() {
		mContentResolver = getContentResolver();
		OnClickListener onClickListener = new ClickListenerImpl();

		mAddButton = (Button) findViewById(R.id.addButton);
		mAddButton.setOnClickListener(onClickListener);

		mDeleteButton = (Button) findViewById(R.id.deleteButton);
		mDeleteButton.setOnClickListener(onClickListener);

		mUpdateButton = (Button) findViewById(R.id.updateButton);
		mUpdateButton.setOnClickListener(onClickListener);

		mQueryButton = (Button) findViewById(R.id.queryButton);
		mQueryButton.setOnClickListener(onClickListener);

		mQueryAllButton = (Button) findViewById(R.id.queryallButton);
		mQueryAllButton.setOnClickListener(onClickListener);

		mTypeButton = (Button) findViewById(R.id.typeButton);
		mTypeButton.setOnClickListener(onClickListener);

	}

	private class ClickListenerImpl implements OnClickListener {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.addButton:
				Person person = new Person("王小明", "13453211234", 25);
				testInsert(person);
				break;
			case R.id.deleteButton:
				testDelete(7);
				break;
			case R.id.updateButton:
				// testUpdate(4);
				testUpdates();
				break;
			case R.id.queryButton:
				testQuery(3);
				break;
			case R.id.queryallButton:
				testQuery();
				break;
			case R.id.typeButton:
				testType();
				break;
			default:
				break;
			}

		}
	}

	private void testInsert(Person person) {
		ContentValues values = new ContentValues();
		values.put("name", person.getName());
		values.put("phone", person.getPhone());
		values.put("salary", person.getSalary());
		Uri insertUri = Uri
				.parse("content://cn.mpqi.testcontentprovider/person");
		Uri returnUri = mContentResolver.insert(insertUri, values);
		Log.i("my_resolver", "新增数据:returnUri=" + returnUri);
	}

	private void testUpdate(int id) {
		Uri uri = Uri.parse("content://cn.mpqi.testcontentprovider/person/"
				+ id);
		ContentValues values = new ContentValues();
		values.put("name", "小华");
		values.put("phone", "0000000000111");
		values.put("salary", 333);
		int rows = mContentResolver.update(uri, values, null, null);
		Log.i("my_resolver", "更新数据：row：" + rows + "\t id：" + id);
	}

	private void testUpdates() {
		Uri uri = Uri.parse("content://cn.mpqi.testcontentprovider/person");
		ContentValues values = new ContentValues();
		values.put("name", "小兰");
		values.put("phone", "2222222111");
		values.put("salary", 6666);
		int rows = mContentResolver.update(uri, values, "salary = ?",
				new String[] { "333" });
		Log.i("my_resolver", "更新数据：row：" + rows);
	}

	private void testDelete(int id) {
		Uri uri = Uri.parse("content://cn.mpqi.testcontentprovider/person/"
				+ id);
		int rows = mContentResolver.delete(uri, null, null);
		Log.i("my_resolver", "删除数据：row：" + rows + "\t id：" + id);
	}

	private void testQuery(int id) {
		Uri uri = Uri.parse("content://cn.mpqi.testcontentprovider/person/"
				+ id);
		Cursor cursor = mContentResolver.query(uri, null, null, null, null);
		while (cursor.moveToNext()) {
			// cursor.getColumnIndex("_id") 通过列名拿到列数
			// cursor.getInt(列数) 获取相应类型的值
			int pid = cursor.getInt(cursor.getColumnIndex("_id"));
			String name = cursor.getString(cursor.getColumnIndex("name"));
			String phone = cursor.getString(cursor.getColumnIndex("phone"));
			int salary = cursor.getInt(cursor.getColumnIndex("salary"));
			Log.i("my_resolver", "查询得到:personid=" + pid + ",name=" + name
					+ ",phone=" + phone + ",salary=" + salary);
		}
		cursor.close();
	}

	private void testQuery() {
		Uri uri = Uri.parse("content://cn.mpqi.testcontentprovider/person/");
		Cursor cursor = mContentResolver.query(uri, null, null, null, null);
		while (cursor.moveToNext()) {
			// cursor.getColumnIndex("_id") 通过列名拿到列数
			// cursor.getInt(列数) 获取相应类型的值
			int pid = cursor.getInt(cursor.getColumnIndex("_id"));
			String name = cursor.getString(cursor.getColumnIndex("name"));
			String phone = cursor.getString(cursor.getColumnIndex("phone"));
			int salary = cursor.getInt(cursor.getColumnIndex("salary"));
			Log.i("my_resolver", "查询得到:personid=" + pid + ",name=" + name
					+ ",phone=" + phone + ",salary=" + salary);
		}
		cursor.close();
	}

	private void testType() {
		Uri dirUri = Uri.parse("content://cn.mpqi.testcontentprovider/person");
		String dirType = mContentResolver.getType(dirUri);
		Log.i("my_resolver", "dirType:" + dirType);

		Uri itemUri = Uri
				.parse("content://cn.mpqi.testcontentprovider/person/3");
		String itemType = mContentResolver.getType(itemUri);
		Log.i("my_resolver", "dirType:" + itemType);
	}
}
