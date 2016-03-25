package com.mpqi.servicedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	Button startServiceButton;// 启动服务按钮
	Button shutDownServiceButton;// 关闭服务按钮
	Button startBindServiceButton;// 启动绑定服务按钮
	Button startActionServerButton;// 通过Action启动服务按钮

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getWidget();
		regiestListener();
	}

	/** 获得组件 */
	public void getWidget() {
		startServiceButton = (Button) findViewById(R.id.startServerButton);
		startBindServiceButton = (Button) findViewById(R.id.startBindServerButton);
		shutDownServiceButton = (Button) findViewById(R.id.sutdownServerButton);
		startActionServerButton = (Button) findViewById(R.id.startActionServerButton);
	}

	/** 为按钮添加监听 */
	public void regiestListener() {
		startServiceButton.setOnClickListener(startService);
		shutDownServiceButton.setOnClickListener(shutdownService);
		startBindServiceButton.setOnClickListener(startBinderService);
		startActionServerButton.setOnClickListener(startActionService);
	}

	/** 通过Action启动服务的事件监听 */
	public OnClickListener startActionService = new OnClickListener() {

		@Override
		public void onClick(View v) {
			/** 单击按钮时启动服务 */
			Intent intent = new Intent();
			intent.setAction("com.mpqi.servicedemo.service.MY_FIRSTSERVICE");
			startService(intent);
			Log.v("MainStadyServics", "By Action start Service");
		}
	};

	/** 启动服务的事件监听 */
	public OnClickListener startService = new OnClickListener() {

		@Override
		public void onClick(View v) {
			/** 单击按钮时启动服务 */
			Intent intent = new Intent(MainActivity.this, FirstService.class);
			startService(intent);
			Log.v("MainStadyServics", "start Service");
		}
	};

	/** 关闭服务 */
	public OnClickListener shutdownService = new OnClickListener() {

		@Override
		public void onClick(View v) {
			/** 单击按钮时启动服务 */
			Intent intent = new Intent(MainActivity.this, FirstService.class);
			/** 停止服务 */
			stopService(intent);
			Log.v("MainStadyServics", "shutDown serveice");
		}
	};

	/** 打开绑定服务的Activity */
	public OnClickListener startBinderService = new OnClickListener() {

		@Override
		public void onClick(View v) {
			/** 单击按钮时启动服务 */
			Intent intent = new Intent(MainActivity.this,
					UseBriderServiceActivity.class);
			startActivity(intent);
			Log.v("MainStadyServics", "start Binder Service");
		}
	};
}
