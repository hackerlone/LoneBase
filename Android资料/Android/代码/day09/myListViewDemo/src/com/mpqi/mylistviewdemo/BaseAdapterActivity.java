package com.mpqi.mylistviewdemo;

import java.util.ArrayList;
import java.util.List;

import com.mpqi.mylistviewdemo.adapter.myTestBaseAdapter;
import com.mpqi.mylistviewdemo.bean.User;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class BaseAdapterActivity extends Activity {

	private ListView myListView;
	private List<User> list;
	private myTestBaseAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.demolistview);
		myListView = (ListView) findViewById(R.id.list);
		getData();
		adapter = new myTestBaseAdapter(this, list);
		myListView.setAdapter(adapter);

		myListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				User user = list.get(position);
				String name = user.getName();

				Toast.makeText(
						BaseAdapterActivity.this,
						"position:" + position + "\t id:" + id + "\t name: "
								+ name, Toast.LENGTH_SHORT).show();
			}
		});

		myListView.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(BaseAdapterActivity.this,
						list.get(position).getName(), Toast.LENGTH_SHORT)
						.show();
				return true;//true 当前长按内容执行完了，不再执行 onItemClick内容。 
				//false 当前长按内容没有执行完，需要继续执行onItemClick内容。
			}
		});
	}

	private void getData() {
		list = new ArrayList<User>();
		int headimage = R.drawable.bierde_43;
		String sex = "女";
		for (int i = 0, len = 35; i < len; i++) {

			if (i % 2 == 0) {
				sex = "女";
			} else {
				sex = "男";
			}

			User user = new User(i + 10, headimage++, "小明" + i, sex);
			if (headimage == R.drawable.bierde_48) {
				headimage = R.drawable.bierde_43;
			}

			list.add(user);
		}
	}
}
