package com.mpqi.mylistviewdemo;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
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

		// 系统的 item 的布局 android.R.layout.simple_expandable_list_item_1
		// ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		// android.R.layout.simple_expandable_list_item_1, strs);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.array_item, strs);
		myListView.setAdapter(adapter);

		// getResources() 获取资源 getDrawable 获取图片资源
		Drawable drawable = getResources().getDrawable(R.drawable.bierde_48);
		myListView.setSelector(drawable);// Drawable 图片资源对象 int resID

		Drawable drawable2 = getResources().getDrawable(R.color.qianlanse);
		myListView.setDivider(drawable2);
		myListView.setDividerHeight(4);
		setListViewHeightBasedOnChildren(myListView);
	}

	/**
	 * 手动计算ListView高度
	 * 
	 * @param listView
	 */
	public static void setListViewHeightBasedOnChildren(ListView listView) {
		ListAdapter listAdapter = listView.getAdapter();
		if (listAdapter == null) {
			// pre-condition
			return;
		}

		int totalHeight = 0;
		for (int i = 0; i < listAdapter.getCount(); i++) {
			View listItem = listAdapter.getView(i, null, listView);
			listItem.measure(0, 0);
			totalHeight += listItem.getMeasuredHeight();
		}

		ViewGroup.LayoutParams params = listView.getLayoutParams();
		params.height = totalHeight
				+ (listView.getDividerHeight() * (listAdapter.getCount() - 1));
		listView.setLayoutParams(params);
	}
}
