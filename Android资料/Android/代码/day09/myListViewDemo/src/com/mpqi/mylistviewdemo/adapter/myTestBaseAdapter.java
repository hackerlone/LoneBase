package com.mpqi.mylistviewdemo.adapter;

import java.util.List;

import com.mpqi.mylistviewdemo.R;
import com.mpqi.mylistviewdemo.bean.User;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class myTestBaseAdapter extends BaseAdapter {

	private Context context;// 当前会话
	private List<User> list;// 数据源
	private LayoutInflater inflater;// 生成 View 的容器 

	public myTestBaseAdapter(Context context, List<User> list) {
		super();
		this.context = context;
		this.list = list;
		inflater = LayoutInflater.from(context);
	}

	private class holver{//缓存每一个布局内部的控件
		ImageView headImageView;//头像
		TextView nameTextView;//姓名
		TextView sexTextView;//性别
	}
	
	@Override
	public int getCount() {// 获取数据内容的长度
		return list.size();
	}

	@Override
	public Object getItem(int position) {// 获取指定下标数据内容对象
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {// 获取数据ID 或 下标
		return list.get(position).getUserid();
	}

	@Override
	// 获取每个item 当中的布局控件 对象
	public View getView(int position, View convertView, ViewGroup parent) {

		holver h = null;
		
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.simpleitem, null);
			h = new holver();
			// 获取控件 并缓存
			h.headImageView = (ImageView) convertView
					.findViewById(R.id.simple_img);
			h.nameTextView = (TextView) convertView
					.findViewById(R.id.simple_name);
			h.sexTextView = (TextView) convertView
					.findViewById(R.id.simple_sex);
			convertView.setTag(h);
			
		}else {
			h = (holver) convertView.getTag();
		}

		User user = list.get(position);

		h.headImageView.setImageResource(user.getHeadImage());
		h.nameTextView.setText(user.getName());
		h.sexTextView.setText(user.getSex());
		

		return convertView;
	}

}
