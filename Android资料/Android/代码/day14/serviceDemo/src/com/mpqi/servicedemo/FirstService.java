package com.mpqi.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class FirstService extends Service {

	/** 创建参数 */
	boolean threadDisable;// 控制当前是否需要打印 count false时打印 true 时停止打印
	int count;

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		/** 创建一个线程，每秒计数器加一，并在控制台进行Log输出 */
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (!threadDisable) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					count++;
					Log.v("FirstService", "Count is " + count);
				}

			}
		}).start();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		/** 服务停止时，终止计数进程 */
		this.threadDisable = true;
		Log.i("CountService", "服务结束了呢！");
	}

	public int getConunt() {
		return count;
	}
	
	//此方法是为了可以在Acitity中获得服务的实例   
	public class ServiceBinder extends Binder {
		public FirstService getService(){
			return FirstService.this;
		}
	}
}
