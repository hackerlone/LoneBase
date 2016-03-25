package com.mpqi.myjiujiujintu.adapter;

import java.util.List;

import com.mpqi.myjiujiujintu.R;
import com.mpqi.myjiujiujintu.bean.TourismProduct;
import com.mpqi.myjiujiujintu.util.IMGSize;
import com.mpqi.myjiujiujintu.util.JJJCONFIG;
import com.mpqi.myjiujiujintu.util.JLog;
import com.mpqi.myjiujiujintu.util.Options;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 首页 产品经理推荐
 * 
 * @author mpqi-i7
 *
 */
public class IndexManagerAdapter extends BaseAdapter implements
		OnScrollListener {
	/**
	 * 当前listview是否属于滚动状态
	 */
	private boolean isScrolling;
	private List<TourismProduct> list;
	private LayoutInflater layoutinflater;
	private Context context;
	private ImageLoader imageLoader;

	private class CoverHolver {
		private ImageView titleImageView;
		private TextView titleTextView;
		private TextView priceTextView;
		private TextView assessTextView;

	}

	public IndexManagerAdapter(Context context, List<TourismProduct> list) {
		super();
		this.list = list;
		this.context = context;
		layoutinflater = LayoutInflater.from(context);
		imageLoader = ImageLoader.getInstance();
	}

	public void setList(List<TourismProduct> list) {
		this.list = list;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		CoverHolver holver = null;
		TourismProduct tourismProduct = list.get(position);
		if (convertView == null) {
			convertView = layoutinflater.inflate(
					R.layout.item_fragment_index_manager_recommend, null);
			holver = new CoverHolver();
			holver.titleImageView = (ImageView) convertView
					.findViewById(R.id.item_recommend_img);
			holver.titleTextView = (TextView) convertView
					.findViewById(R.id.item_recommend_title);
			holver.priceTextView = (TextView) convertView
					.findViewById(R.id.item_recommend_money);
			holver.assessTextView = (TextView) convertView
					.findViewById(R.id.item_recommend_assess);
			convertView.setTag(holver);
		} else {
			holver = (CoverHolver) convertView.getTag();
		}
		holver.titleTextView.setText(tourismProduct.getTitle());

		String price = context.getString(R.string.calendar_yuan);
		price = String.format(price, tourismProduct.getPriceNew());
		holver.priceTextView.setText(price);

		String assess = context.getString(R.string.satisfaction);
		assess = String.format(assess, tourismProduct.getAtisfaction());
		holver.assessTextView.setText(assess);
		String url = IMGSize.getImgUrl_imageMogr(
				tourismProduct.getImgTitleUrl(), JJJCONFIG.ITEM_ICON_CROP_W,
				JJJCONFIG.ITEM_ICON_CROP_H, JJJCONFIG.ITEM_ICON_W,
				JJJCONFIG.ITEM_ICON_H);
		JLog.iTest(url);
		holver.titleImageView.setTag(url);

		imageLoader.displayImage(url, holver.titleImageView,
				Options.getListOptions(), new ImageLoadingListener() {

					@Override
					public void onLoadingStarted(String arg0, View arg1) {
						// 开始加载
					}

					@Override
					public void onLoadingFailed(String arg0, View arg1,
							FailReason arg2) {
						// 加载失败
					}

					@Override
					public void onLoadingComplete(String arg0, View arg1,
							Bitmap arg2) {
						if (arg1.getTag().toString().equals(arg0)) {
							((ImageView) arg1).setImageBitmap(arg2);
						}
					}

					@Override
					public void onLoadingCancelled(String arg0, View arg1) {
						// 加载取消
					}

				});

		return convertView;
	}

	boolean isLastRow = false;

	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		// 正在滚动时回调，回调2-3次，手指没抛则回调2次。scrollState = 2的这次不回调
		// 回调顺序如下
		// 第1次：scrollState = SCROLL_STATE_TOUCH_SCROLL(1) 正在滚动
		// 第2次：scrollState = SCROLL_STATE_FLING(2) 手指做了抛的动作（手指离开屏幕前，用力滑了一下）
		// 第3次：scrollState = SCROLL_STATE_IDLE(0) 停止滚动

		// 当滚到最后一行且停止滚动时，执行加载
		if (isLastRow
				&& scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
			// 加载元素
			isLastRow = false;
			imageLoader.pause();
		}

	}

	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {
		// 滚动时一直回调，直到停止滚动时才停止回调。单击时回调一次。
		// firstVisibleItem：当前能看见的第一个列表项ID（从0开始）
		// visibleItemCount：当前能看见的列表项个数（小半个也算）
		// totalItemCount：列表项共数

		// 判断是否滚到最后一行
		if (firstVisibleItem + visibleItemCount == totalItemCount
				&& totalItemCount > 0) {
			isLastRow = true;
			imageLoader.notify();
		}

	}

}
