package com.mpqi.broadcastreceiverdemo.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class RigisterReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		String tmp = intent.getStringExtra("msg");
		Toast.makeText(context, tmp, Toast.LENGTH_SHORT).show();
	}

}
