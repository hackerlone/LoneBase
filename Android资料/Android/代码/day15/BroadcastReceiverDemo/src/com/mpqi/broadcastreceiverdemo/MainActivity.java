package com.mpqi.broadcastreceiverdemo;

import com.mpqi.broadcastreceiverdemo.broadcast.RigisterReceiver;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button lsendBroadcastBtn;
	private Button lrigisterReceiverBtn;
	private Button lorderedBtn;
	private RigisterReceiver abcReceiver;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		lsendBroadcastBtn = (Button) findViewById(R.id.sendBroadcast);
		lrigisterReceiverBtn = (Button) findViewById(R.id.rigisterReceiver);
		lorderedBtn = (Button) findViewById(R.id.orderedReceiver);

		// 动态注册
		IntentFilter intentFilter = new IntentFilter(
				"org.mpqi.braod.RIGISTER_RECEIVER");
		abcReceiver = new RigisterReceiver();
		registerReceiver(abcReceiver, intentFilter);
		
		lrigisterReceiverBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setAction("org.mpqi.braod.RIGISTER_RECEIVER");
				intent.putExtra("msg", "这是我的第一个动态注册的广播！！！^ ^");
				sendBroadcast(intent);//发送广播
			}
		});
		
		//发送静态注册广播
		lsendBroadcastBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setAction("org.mpqi.broad.MYRECEIVER");
				intent.putExtra("msg", "这是我的第一个静态注册广播消息~！！！");
				sendBroadcast(intent);
			}
		});
		
		// 有序广播
		lorderedBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setAction("org.mpqi.broad.ORDERRECEIVER");
				intent.putExtra("msg", "这是我的有序广播，开始！！！");
				sendOrderedBroadcast(intent, null);
			}
		});
	}
	
	@Override
	protected void onDestroy() {
		unregisterReceiver(abcReceiver);
		super.onDestroy();
	}
}
