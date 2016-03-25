package com.mpqi.servicedemo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

public class UseBriderServiceActivity extends Activity {

	FirstService countService;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TextView textView = new TextView(this);
		textView.setLayoutParams(new LayoutParams(
				ViewGroup.LayoutParams.WRAP_CONTENT,
				ViewGroup.LayoutParams.WRAP_CONTENT));
		textView.setText("我启动了！！！");
		setContentView(textView);
		
		Intent intent = new Intent(UseBriderServiceActivity.this,FirstService.class);
		/** 进入Activity开始服务 */
		bindService(intent, conn, Context.BIND_AUTO_CREATE);
	}
	
	private ServiceConnection conn = new ServiceConnection() {
		
		@Override
		/** 无法获取到服务对象时的操作 */
		public void onServiceDisconnected(ComponentName name) {
			countService = null;			
		}
		
		@Override
		/** 获取服务对象时的操作 */
		public void onServiceConnected(ComponentName name, IBinder service) {
			countService = ((FirstService.ServiceBinder)service).getService();
			
		}
	};
	
	protected void onDestroy() {
		super.onDestroy();
		this.unbindService(conn);
		Log.v("MainStadyServics", "out");
	}
}
