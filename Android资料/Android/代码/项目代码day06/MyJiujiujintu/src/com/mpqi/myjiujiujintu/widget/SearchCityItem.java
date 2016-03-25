package com.mpqi.myjiujiujintu.widget;

import com.mpqi.myjiujiujintu.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SearchCityItem extends FrameLayout {

	private ImageView choosedImageView;
	private TextView itemTextView;
	private View contentFrameLayout;
	private boolean choosed;// true 选定了
	private boolean end;// true 一排的最后一个
	private String text;
	private Context lcontext;
	


	public SearchCityItem(Context context, AttributeSet attrs) {
		super(context, attrs);
		TypedArray a = getContext().obtainStyledAttributes(attrs,
				R.styleable.SearchCityItem, 0, 0);
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.fragment_search_city_item, this);
		choosedImageView = (ImageView) findViewById(R.id.search_item_choosed);
		itemTextView = (TextView) findViewById(R.id.search_item_text);
		contentFrameLayout = findViewById(R.id.search_item_content);

		end = a.getBoolean(R.styleable.SearchCityItem_end, false);
		choosed = a.getBoolean(R.styleable.SearchCityItem_choosed, false);
		text = a.getString(R.styleable.SearchCityItem_text);
		lcontext = context;
		refresh();
		a.recycle();// 回收资源
	}

	public void setChoosed(boolean choosed) {
		this.choosed = choosed;
	}

	public void setEnd(boolean end) {
		this.end = end;
	}

	public void refresh() {
		if (!choosed) {
			choosedImageView.setVisibility(View.INVISIBLE);
		} 
		if (!end) {
			 FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) contentFrameLayout.getLayoutParams();  
			 params.rightMargin = 1;  
			 contentFrameLayout.setLayoutParams(params);

		} 		
		if (!TextUtils.isEmpty(text)) {
			itemTextView.setText(text);
		}

	}

}
