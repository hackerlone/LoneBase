package com.mpqi.actvitydemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	
	public void MyOnclick(View view) {
		finish();
	}
	
	
	public void MyOnclick2(View view) {
		Intent intent = new Intent(this , myGoActivity.class);
		startActivity(intent);
	}
	
	@Override
	/***
	 * 初始化创建
	 */
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.i("ActivityDemo", "-----------onCreate-----------");
	}
	
	
	@Override
	/**
	 * 启动创建
	 */
	protected void onStart() {
		super.onStart();
		Log.i("ActivityDemo", "-----------onStart-----------");
	}
	
	@Override
	/**
	 * 启动、唤醒
	 */
	protected void onResume() {
		super.onResume();
		Log.i("ActivityDemo", "-----------onResume-----------");
	}
	
	
	@Override
	/**
	 * 暂停  短暂等待
	 */
	protected void onPause() {
		super.onPause();
		Log.i("ActivityDemo", "-----------onPause-----------");
	}
	
	@Override
	/**
	 *  后台等待  较长时间 ---> onRestart() --->onStart
	 *        进程被系统杀掉了 ----> onCreate()
	 */
	protected void onStop() {
		super.onStop();
		Log.i("ActivityDemo", "-----------onStop-----------");
	}
	
	@Override
	/**
	 * 销毁
	 */
	protected void onDestroy() {
		super.onDestroy();
		Log.i("ActivityDemo", "-----------onDestroy-----------");
	}
	
	@Override
	/**
	 * 较长等待后 重新被唤醒 ---> onStart
	 */
	protected void onRestart() {
		super.onRestart();
		Log.i("ActivityDemo", "-----------onRestart-----------");
	}
}
