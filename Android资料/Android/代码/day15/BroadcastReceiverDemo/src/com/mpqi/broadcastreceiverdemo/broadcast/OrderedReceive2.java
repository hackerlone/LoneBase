package com.mpqi.broadcastreceiverdemo.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class OrderedReceive2 extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		//解析前一个BroadcastReceiver 所存入的key 为first的消息
		Bundle bundle = getResultExtras(true);
		String msg = bundle.getString("first");
		Toast.makeText(context, msg+"第二个有序广播", Toast.LENGTH_SHORT).show();
		Log.i("Receiver", msg);
	}

}
