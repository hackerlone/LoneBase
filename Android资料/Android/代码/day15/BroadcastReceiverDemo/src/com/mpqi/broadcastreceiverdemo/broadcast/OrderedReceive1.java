package com.mpqi.broadcastreceiverdemo.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class OrderedReceive1 extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		String msg = intent.getStringExtra("msg");
		Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
		Log.i("Receiver", msg);
		
		Bundle bundle = new Bundle();
		bundle.putString("first", "这是从有序广播1里面传来的消息！你是：");
		setResultExtras(bundle);//把消息数据包 传递给第二个广播
		abortBroadcast();//取消BroadcastReceiver的继续传播 影响2是否接受
	}

}
