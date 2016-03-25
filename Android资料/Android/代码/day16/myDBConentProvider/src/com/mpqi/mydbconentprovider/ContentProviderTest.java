package com.mpqi.mydbconentprovider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

/**
 * 注意事项: 在AndroidManifest.xml中注册ContentProvider时的属性
 * android:exported="true"表示允许其他应用访问. 这样 mineXXX这个应用才可以访问该处的ContentProvider
 */
public class ContentProviderTest extends ContentProvider {
	private DBOpenHelper dbOpenHelper;// 数据库操作的管理工具
	private UriMatcher URI_MATCHER;
	private static final int PERSONS = 0;
	private static final int PERSON = 1;

	@Override
	public boolean onCreate() {
		initinitUriMatcher();// 初始化URI
		dbOpenHelper = new DBOpenHelper(getContext());
		return true;
	}

	private void initinitUriMatcher() {
		URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);
		// 表示返回所有的person,其中PERSONS为该特定Uri的标识码
		URI_MATCHER.addURI("cn.mpqi.testcontentprovider", "person", PERSONS);
		// 表示返回某一个person,其中PERSON为该特定Uri的标识码
		URI_MATCHER.addURI("cn.mpqi.testcontentprovider", "person/#", PERSON);
	}

	@Override
	public Cursor query(Uri uri, String[] columns, String whereClause,
			String[] whereArgs, String sortOrder) {
		SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
		Cursor cursor = null;
		switch (URI_MATCHER.match(uri)) {
		// 查询表
		case PERSONS:
			cursor = db.query("person", columns, whereClause, whereArgs, null,
					null, sortOrder);
			break;
		// 按照id查询某条数据
		case PERSON:
			long id = ContentUris.parseId(uri);
			String where = "_id=" + id;
			if (whereClause != null && whereClause.trim().length() != 0) {
				where += " and " + whereClause;
			}
			cursor = db.query("person", columns, where, whereArgs, null, null,
					sortOrder);

			break;
		default:
			throw new IllegalArgumentException("unknown uri" + uri.toString());
		}
		return cursor;
	}

	/**
	 * 返回当前Uri所代表的数据的MIME类型. 
	 * 如果该Uri对应的数据可能包含多条记录,那么返回
	 * 字符串应该以"vnd.android.cursor.dir/"开头 
	 * 如果该Uri对应的数据只包含一条记录,那么返回
	 * 字符串应该以"vnd.android.cursor.item/"开头
	 */
	@Override
	public String getType(Uri uri) {
		switch (URI_MATCHER.match(uri)) {
		case PERSONS:
			return "vnd.android.cursor.dir/persons";

		case PERSON:
			return "vnd.android.cursor.item/person";
		default:
			throw new IllegalArgumentException("unknown uri" + uri.toString());
		}
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
		switch (URI_MATCHER.match(uri)) {
		case PERSONS:
			long rowid = db.insert("person", "name,phone,salary", values);
			return ContentUris.withAppendedId(uri, rowid);
		default:
			throw new IllegalArgumentException("unkonw uri :" + uri.toString());
		}
	}

	/**
	 * 删除操作: 删除操作有两种可能:删除一张表或者删除某条数据 在删除某条数据时原理类似于查询某条数据,见下.
	 */
	@Override
	public int delete(Uri uri, String whereClause, String[] whereArgs) {
		SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
		int deletNum = 0;
		switch (URI_MATCHER.match(uri)) {
		// 删除表
		case PERSONS:
			deletNum = db.delete("person", whereClause, whereArgs);
			break;
		// 按照id删除某条数据
		case PERSON:
			long id = ContentUris.parseId(uri);
			String where = "_id=" + id;
			if (whereClause != null && whereClause.trim().length() != 0) {
				where += " and " + whereClause;
			}
			deletNum = db.delete("person", where, whereArgs);
			break;
		default:
			throw new IllegalArgumentException("unknown uri" + uri.toString());
		}
		return deletNum;
	}

	/**
	 * where name like ? and type = ? String[]{"小%","2"} 更新操作:
	 * 更新操作有两种可能:更新一张表或者更新某条数据 在更新某条数据时原理类似于查询某条数据,见下.
	 */
	@Override
	public int update(Uri uri, ContentValues values, String whereClause,
			String[] whereArgs) {
		SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
		int updateNume = 0;
		switch (URI_MATCHER.match(uri)) {
		// 更新表
		case PERSONS:
			updateNume = db.update("person", values, whereClause, whereArgs);
			break;
		// 按照id更新某条数据
		case PERSON:
			Log.i("contentprovider", uri.toString());
			long id = ContentUris.parseId(uri);
			String where = "_id=" + id;
			if (whereClause != null && whereClause.trim().length() != 0) {
				where += " and " + whereClause;
			}
			updateNume = db.update("person", values, where, whereArgs);
			break;
		default:
			throw new IllegalArgumentException("unknown uri" + uri.toString());
		}
		return updateNume;
	}

}
