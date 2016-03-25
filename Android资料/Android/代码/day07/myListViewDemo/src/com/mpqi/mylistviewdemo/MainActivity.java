package com.mpqi.mylistviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	private ListView myListView;
	private String[] strs = new String[] { "aagd", "asda", "5rrt", "wewtdfg",
			"werwerwerw", "sdfsdf", "aagd", "asda", "5rrt", "wewtdfg",
			"werwerwerw", "sdfsdf", "aagd", "asda", "5rrt", "wewtdfg",
			"werwerwerw", "sdfsdf", "aagd", "asda", "5rrt", "wewtdfg",
			"werwerwerw", "sdfsdf", "aagd", "asda", "5rrt", "wewtdfg",
			"werwerwerw", "sdfsdf", "aagd", "asda", "5rrt", "wewtdfg",
			"werwerwerw", "sdfsdf", "aagd", "asda", "5rrt", "wewtdfg",
			"werwerwerw", "sdfsdf" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		myListView = (ListView) findViewById(R.id.list);
		
		//系统的 item 的布局  android.R.layout.simple_expandable_list_item_1
//		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//				android.R.layout.simple_expandable_list_item_1, strs);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.array_item, strs);
		myListView.setAdapter(adapter);
	}
}
