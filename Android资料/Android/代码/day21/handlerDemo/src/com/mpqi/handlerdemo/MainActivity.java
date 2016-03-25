package com.mpqi.handlerdemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	Handler handler = new Handler(){
		public void handleMessage(Message msg) {
			Log.i("test", msg.arg1+"");
			Log.i("test", msg.arg2+"");
			Log.i("test", msg.what+"");
			Log.i("test", msg.obj+"");
			Toast.makeText(MainActivity.this, "这是send的内容", Toast.LENGTH_SHORT).show();
		};
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//这里会报错  
		//java.lang.RuntimeException: Can't create handler inside thread that has not called Looper.prepare()

//		new Thread(new Runnable() {//创建一个普通的子线程
//
//			@Override
//			public void run() {
//				try {
//					Thread.sleep(10000);//让子线程睡眠10秒
//					Toast.makeText(MainActivity.this, "这是十秒钟以后",
//							Toast.LENGTH_SHORT).show();
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//
//			}
//		}).start();//启动一个线程
		
//		HandlerThread hThread = new HandlerThread("name"){
//			@Override
//			public void run() {
//				try {
//				
//					Thread.sleep(2000);//让子线程睡眠10秒
//					Toast.makeText(MainActivity.this, "这是十秒钟以后",
//							Toast.LENGTH_SHORT).show();
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		};
//		hThread.start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				handler.post(new Runnable() {
					
					@Override
					public void run() {
						Toast.makeText(MainActivity.this, "我是5秒之后", Toast.LENGTH_SHORT).show();
						
					}
				});
				
				Message msg = new Message();
				msg.arg1 = 1;
				msg.arg2 = 2;
				msg.what = 3;
				msg.obj = "hello";
				handler.sendMessage(msg);
			}
		}).start();
	
		MyHandlerThead myHandlerThead = new MyHandlerThead("mythread");
		myHandlerThead.start();
		Handler mhandler = new Handler(myHandlerThead.getLooper(), myHandlerThead);
		Message msg = new Message();
		msg.obj = "我主线程转入的内容";
		mhandler.sendEmptyMessage(1);
		mhandler.sendMessage(msg);
		mhandler.sendEmptyMessage(1);
		mhandler.sendEmptyMessage(2);
		mhandler.sendEmptyMessage(3);
		
	}
	
	class MyHandlerThead extends HandlerThread implements Callback{

		public MyHandlerThead(String name) {
			super(name);
			// TODO Auto-generated constructor stub
		}

		@Override
		public boolean handleMessage(Message msg) {
			Log.i("myhandler", "这是子线程里的内容："+msg.obj+msg.what);
			return false;
		}
		
	}
	
}
