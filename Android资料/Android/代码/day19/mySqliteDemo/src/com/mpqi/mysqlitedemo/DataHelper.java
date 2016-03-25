package com.mpqi.mysqlitedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DataHelper extends SQLiteOpenHelper {

	private final static String dbname = "datahelper.db";// 数据库的名字
	private static int dbversion = 6;// 数据库的版本号

	/**
	 * 
	 * @param context
	 *            会话
	 * @param name
	 *            数据库的名字
	 * @param factory
	 *            游标的管理
	 * @param version
	 *            版本号
	 */
	public DataHelper(Context context) {
		super(context, dbname, null, dbversion);

	}

	@Override
	// 数据库初始化 如果数据库已经存在，那么此方法不执行
	public void onCreate(SQLiteDatabase db) {
		String createStr = "create table answer (_id integer primary key autoincrement ,timu_title text ,timu1  varchar(64), daan1   varchar(64));";
		db.execSQL(createStr);
	}

	@Override
	// 数据库更新
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		String createStr = "create table user (_id integer primary key autoincrement ,username text ,pwd  varchar(64), age   varchar(64));";
		db.execSQL(createStr);
	}

}
