package com.mpqi.myjiujiujintu.fragment;

import java.util.ArrayList;
import java.util.List;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;
import com.mpqi.myjiujiujintu.R;
import com.mpqi.myjiujiujintu.bean.City;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class SearchCityFragment extends Fragment {
	private TableLayout hotTableLayout, sortsTableLayout, allcityTableLayout;
	private LayoutInflater linflater;
	private String choosedName;
	private List<String> sorts;
	private List<City> allcities;
	private List<View> sortViews;
	private LinearLayout lscrollLinearLayout;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_search_city, null);
		linflater = inflater;
		initViews(view);
		inithotCities();
		initSorts();
		return view;
	}

	private void initViews(View view) {
		hotTableLayout = (TableLayout) view
				.findViewById(R.id.search_city_hot_table);
		sortsTableLayout = (TableLayout) view
				.findViewById(R.id.search_city_sorts_table);
		allcityTableLayout = (TableLayout) view
				.findViewById(R.id.search_city_all_table);
		lscrollLinearLayout = (LinearLayout) view
				.findViewById(R.id.search_city_scroll_line);
	}

	private void inithotCities() {
		AVQuery<City> query = AVObject.getQuery(City.class);

		query.whereGreaterThan(City.HOTNUM_TEXT, 0);
		query.orderByAscending(City.HOTNUM_TEXT);
		query.findInBackground(new FindCallback<City>() {

			@Override
			public void done(List<City> list, AVException arg1) {
				if (arg1 == null) {
					TextView titleTextView = (TextView) linflater.inflate(
							R.layout.fragment_search_city_title, null);
					titleTextView.setText(R.string.hot_city);
					hotTableLayout.addView(titleTextView);

					int len = list.size();
					TableRow tableRow = null;
					String name = null;
					for (int i = 0; i < len; i++) {
						if (i % 5 == 0) {
							tableRow = new TableRow(getActivity());
							hotTableLayout.addView(tableRow);
						}
						name = list.get(i).getCityName();
						blank(tableRow, name, i, false);
					}

					noblank(tableRow, len);
				} else {
					arg1.printStackTrace();
				}

			}
		});

	}

	private void initSorts() {
		sorts = new ArrayList<String>();
		AVQuery<City> query = AVObject.getQuery(City.class);
		query.orderByAscending(City.SORT_TEXT);//字母升序
		query.findInBackground(new FindCallback<City>() {

			@Override
			public void done(List<City> list, AVException arg1) {
				if (arg1 == null) {
					allcities = list;
					//设置当前table的标题
					TextView titleTextView = (TextView) linflater.inflate(
							R.layout.fragment_search_city_title, null);
					titleTextView.setText(R.string.search_pinyin);
					sortsTableLayout.addView(titleTextView);

					int len = list.size();
					int j = 0;//字母的下标
					TableRow tableRow = null;
					String sort = null;
					String lastsort = null;
					for (int i = 0; i < len; i++) {
						if (j % 5 == 0) {
							tableRow = new TableRow(getActivity());
							sortsTableLayout.addView(tableRow);
						}
						sort = list.get(i).getSort();
						if (lastsort == null || !lastsort.equals(sort)) {
							lastsort = sort;
							sorts.add(sort);
							blank(tableRow, sort, j++, true);
						}

					}

					noblank(tableRow, sorts.size());
					initallCities();
				} else {
					arg1.printStackTrace();
				}

			}
		});
	}

	private void initallCities() {
		sortViews = new ArrayList<View>();
		String lastsort = null;
		City city = null;
		String sort = null;
		TableRow tableRow = null;
		int len = allcities.size();
		int j = 0;
		for (int i = 0 ; i < len; i++) {
			city = allcities.get(i);
			sort = city.getSort();
			if (lastsort == null || !lastsort.equals(sort)) {
				if (lastsort != null) {
					noblank(tableRow, j);
				}
				lastsort = sort;
				TextView titleTextView = (TextView) linflater.inflate(
						R.layout.fragment_search_city_title, null);
				titleTextView.setText(sort);
				allcityTableLayout.addView(titleTextView);
				sortViews.add(titleTextView);
				j = 0;
			}

			if (j % 5 == 0) {
				tableRow = new TableRow(getActivity());
				allcityTableLayout.addView(tableRow);
			}
			blank(tableRow, city.getCityName(), j, false);
			j++;
		}
		noblank(tableRow, j);
	}

	/**
	 * 
	 * @param tableRow
	 * @param contentName
	 * @param postion
	 * @param isSort true 字幕索引  false  其他城市内容
	 */
	private void blank(TableRow tableRow, final String contentName,
			final int postion, final boolean isSort) {
		FrameLayout itemView = (FrameLayout) linflater.inflate(
				R.layout.fragment_search_city_item, null);
		ImageView choosedImageView = (ImageView) itemView
				.findViewById(R.id.search_item_choosed);

		TextView itemTextView = (TextView) itemView
				.findViewById(R.id.search_item_text);
		if (!contentName.equals(choosedName)) {
			choosedImageView.setVisibility(View.INVISIBLE);
		}

		tableRow.addView(itemView);
		TableRow.LayoutParams params = (TableRow.LayoutParams) itemView
				.getLayoutParams();
		params.weight = 1;
		switch (postion % 5) {
		case 0:

		case 1:

		case 2:

		case 3:

			params.rightMargin = 2;
			break;
		}
		params.bottomMargin = 2;
		itemTextView.setText(contentName);
		itemView.setLayoutParams(params);
		itemView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (isSort) {
					// float y = sortViews.get(postion).getY();
					// lscrollLinearLayout.scrollTo(0, (int)y);
				} else {
					((SetChoosedNameListner) getActivity())
							.setChoosedName(contentName);
					((SetChoosedNameListner) getActivity()).close();// 关闭当前界面
				}

			}
		});
	}

	private void noblank(TableRow tableRow, int len) {
		int num = 5 - len % 5;

		for (int i = 0; i < num && num != 5; i++) {
			FrameLayout itemView = (FrameLayout) linflater.inflate(
					R.layout.fragment_search_city_item, null);
			tableRow.addView(itemView);
			TableRow.LayoutParams params = (TableRow.LayoutParams) itemView
					.getLayoutParams();
			params.weight = 1;
			params.bottomMargin = 2;
			itemView.setLayoutParams(params);
			ImageView choosedImageView = (ImageView) itemView
					.findViewById(R.id.search_item_choosed);
			choosedImageView.setVisibility(View.INVISIBLE);
		}
	}

	public void setChoosedName(String choosedName) {
		this.choosedName = choosedName;
	}

	public String getChoosedName() {
		return choosedName;
	}

	public interface SetChoosedNameListner {
		public void setChoosedName(String choosedName);

		public void close();

		public String getChoosedName();
	}
}
