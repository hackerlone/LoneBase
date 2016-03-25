package com.mpqi.musicservicedemo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MusicService extends Service {
	// 为日志工具设置标签
	private static String TAG = "MusicService";

	// 定义音乐播放器变量
	private MediaPlayer mPlayer;

	@Override
	// 该服务不存在需要被创建时被调用，不管startService()还是bindService()都会启动时调用该方法
	public void onCreate() {
		Toast.makeText(this, "MusicSevice onCreate()", Toast.LENGTH_SHORT)
				.show();
		Log.e(TAG, "MusicSerice onCreate()");

		mPlayer = MediaPlayer.create(getApplicationContext(), R.raw.music);
		// 设置循环播放
		mPlayer.setLooping(true);
		super.onCreate();
	}

	@Override
	public void onStart(Intent intent, int startId) {
		Toast.makeText(this, "MusicSevice onStart()"
				, Toast.LENGTH_SHORT).show();
		Log.e(TAG, "MusicSerice onStart()");
		
		mPlayer.start();
		
		super.onStart(intent, startId);
	}

	@Override
	public void onDestroy() {
		Toast.makeText(this, "MusicSevice onDestroy()"
				, Toast.LENGTH_SHORT).show();
		Log.e(TAG, "MusicSerice onDestroy()");
		
		mPlayer.stop();
		
		super.onDestroy();
	}

	@Override
	//其他对象通过bindService 方法通知该Service时该方法被调用
	public IBinder onBind(Intent intent) {
		Toast.makeText(this, "MusicSevice onBind()"
				, Toast.LENGTH_SHORT).show();
		Log.e(TAG, "MusicSerice onBind()");
		
		mPlayer.start();
		
		return null;
	}
	
	@Override
	//其它对象通过unbindService方法通知该Service时该方法被调用
	public boolean onUnbind(Intent intent) {
		Toast.makeText(this, "MusicSevice onUnbind()"
				, Toast.LENGTH_SHORT).show();
		Log.e(TAG, "MusicSerice onUnbind()");
		
		mPlayer.stop();
		
		return super.onUnbind(intent);
	}

}
