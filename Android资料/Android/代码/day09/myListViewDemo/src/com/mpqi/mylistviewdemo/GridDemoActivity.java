package com.mpqi.mylistviewdemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.SimpleAdapter;

public class GridDemoActivity extends Activity{
	private GridView myGridView;
	private List<HashMap<String, Object>> data;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gridview_main);
		myGridView = (GridView) findViewById(R.id.grid);
		
		int[] to = new int[]{R.id.simple_img,R.id.simple_name,R.id.simple_sex};
		getData();
		String[] from = new String[]{"image","sex","name"};
		
		SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.gridview_item, from, to);
		
		myGridView.setAdapter(adapter);
	}
	
	
	private void getData(){
		data = new ArrayList<HashMap<String,Object>>();
		
		HashMap<String, Object> map1 = new HashMap<String, Object>();
		map1.put("image", R.drawable.bierde_43);
		map1.put("name", "张三");
		map1.put("sex", "男");
		data.add(map1);
		
		HashMap<String, Object> map2 = new HashMap<String, Object>();
		map2.put("image", R.drawable.bierde_44);
		map2.put("name", "张2");
		map2.put("sex", "男");
		data.add(map2);
		
		HashMap<String, Object> map3 = new HashMap<String, Object>();
		map3.put("image", R.drawable.bierde_45);
		map3.put("name", "张11");
		map3.put("sex", "男");
		data.add(map3);
		
		HashMap<String, Object> map4 = new HashMap<String, Object>();
		map4.put("image", R.drawable.bierde_46);
		map4.put("name", "张4");
		map4.put("sex", "男4");
		data.add(map4);
		
		HashMap<String, Object> map5 = new HashMap<String, Object>();
		map5.put("image", R.drawable.bierde_47);
		map5.put("name", "张");
		map5.put("sex", "男");
		data.add(map5);
		
		HashMap<String, Object> map6 = new HashMap<String, Object>();
		map6.put("image", R.drawable.bierde_48);
		map6.put("name", "张61");
		map6.put("sex", "男6");
		data.add(map6);
		
		HashMap<String, Object> map7 = new HashMap<String, Object>();
		map7.put("image", R.drawable.bierde_43);
		map7.put("name", "张三");
		map7.put("sex", "男");
		data.add(map7);
		
		for (int i = 0; i <40; i++) {
			HashMap<String, Object> map8 = new HashMap<String, Object>();
			map8.put("image", R.drawable.bierde_46);
			map8.put("name", "张三"+i);
			map8.put("sex", "男"+i);
			data.add(map8);
		}
	}
}
