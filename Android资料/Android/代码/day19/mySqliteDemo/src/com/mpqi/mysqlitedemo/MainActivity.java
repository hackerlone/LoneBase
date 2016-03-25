package com.mpqi.mysqlitedemo;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {
	private DataHelper helper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		helper = new DataHelper(this);
		// insert();
		// insertEXECSQL();
		// update();
		// delete();
		// query();
		rawquery();
	}

	private void insert() {
		// SQLiteDatabase db = helper.getWritableDatabase();//获取可读写数据库
		// ContentValues values = new ContentValues();
		// values.put("timu_title",
		// "1	 __dull he may be, he is certainly a very successful top executive.	Although	whatever 	As	However 				D	however引导的让步状语从句,意思是无论(怎么样),从句需要倒装,即However+adj/adv+主+谓. However dull he may be=Dull as he may be. although和as引导让步状语从句,指”尽管”, whatever用来引导名词从句,意思是: 无论什么. 句意: 无论他多么地令人感到乏味.他还是一位非常成功的顶级行政人员.	单选	0");
		// values.put("timu1","Although");
		// values.put("daan1","A");
		// db.insert("answer", null, values);

		SQLiteDatabase db = helper.getWritableDatabase();//
		ContentValues values = new ContentValues();
		values.put("username", "小明");
		db.insert("user", "username", values);
		db.close();
	}

	private void insertEXECSQL() {
		SQLiteDatabase db = helper.getWritableDatabase();//
		ContentValues values = new ContentValues();
		String insert1 = "insert into user(username , age) values ('小王',13)";
		db.execSQL(insert1);

		String insert2 = "insert into user values (null,'小王','abccc',13)";// _id
																			// null
		db.execSQL(insert2);
		db.close();
	}

	private void update() {
		SQLiteDatabase db = helper.getWritableDatabase();//
		ContentValues values = new ContentValues();
		values.put("username", "小红");
		db.update("user", values, "_id = ?", new String[] { "3" });

		String update = "update user set username = '小林'  where _id = ?";
		db.execSQL(update, new String[] { "2" });
		db.close();
	}

	private void delete() {
		SQLiteDatabase db = helper.getWritableDatabase();//
		db.delete("user", "_id = ?", new String[] { "-1" });
		db.close();
	}

	private void query() {
		SQLiteDatabase db = helper.getWritableDatabase();
		// select * from user
		Cursor cursor1 = db.query("user", null, null, null, null, null, null);
		String msg = null;
		String name = null;
		String pwd = null;
		String _id = null;
		String age = null;
		while (cursor1.moveToNext()) {
			name = cursor1.getString(cursor1.getColumnIndex("username"));
			pwd = cursor1.getString(cursor1.getColumnIndex("pwd"));
			_id = cursor1.getInt(cursor1.getColumnIndex("_id")) + "";
			age = cursor1.getInt(cursor1.getColumnIndex("age")) + "";
			msg = "_id : " + _id + " name : " + name + " pwd : " + pwd
					+ " age : " + age;
			Log.i("sqlite_demo", msg);

		}

		Log.i("sqlite_demo", "条件查询");
		Cursor cursor2 = db.query("user", new String[] { "username , _id " },
				"pwd = ?", new String[] { "abccc" }, null, null, null);
		while (cursor2.moveToNext()) {
			name = cursor2.getString(cursor2.getColumnIndex("username"));
			_id = cursor2.getInt(cursor2.getColumnIndex("_id")) + "";
			msg = "_id : " + _id + " name : " + name;
			Log.i("sqlite_demo", msg);

		}
		db.close();
	}

	private void rawquery() {
		SQLiteDatabase db = helper.getWritableDatabase();
		Cursor cursor = db.rawQuery("select * from user where username = ?",
				new String[] { "小明" });
		String msg = null;
		String name = null;
		String pwd = null;
		String _id = null;
		String age = null;
		while (cursor.moveToNext()) {
			name = cursor.getString(cursor.getColumnIndex("username"));
			pwd = cursor.getString(cursor.getColumnIndex("pwd"));
			_id = cursor.getInt(cursor.getColumnIndex("_id")) + "";
			age = cursor.getInt(cursor.getColumnIndex("age")) + "";
			msg = "_id : " + _id + " name : " + name + " pwd : " + pwd
					+ " age : " + age;
			Log.i("sqlite_demo", msg);

		}
		db.close();
	}
}
