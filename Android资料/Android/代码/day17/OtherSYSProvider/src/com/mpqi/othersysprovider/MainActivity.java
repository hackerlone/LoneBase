package com.mpqi.othersysprovider;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		
	}
	
	public void myOnclick(View view){
		switch (view.getId()) {
		case R.id.browser:
			Intent intent= new Intent();        
		    intent.setAction("android.intent.action.VIEW");    
		    Uri content_url = Uri.parse("http://www.baidu.com");   
		    intent.setData(content_url);  
		    startActivity(intent);
			break;
		case R.id.calllog:
			Intent intent2 = new Intent(MainActivity.this , CallLogActivity.class);
			startActivity(intent2);
			break;
		case R.id.telephonedir:
			Intent intent3 = new Intent(MainActivity.this , TelephoneDirAcitivty.class);
			startActivity(intent3);
			break;
		}
		
	}
}
