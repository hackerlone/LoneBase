package com.mpqi.myjiujiujintu.fragment;

import java.util.ArrayList;
import java.util.List;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;
import com.mpqi.myjiujiujintu.R;
import com.mpqi.myjiujiujintu.adapter.DefaultImgPagerAdapter;
import com.mpqi.myjiujiujintu.adapter.IndexManagerAdapter;
import com.mpqi.myjiujiujintu.bean.ADPic;
import com.mpqi.myjiujiujintu.bean.TourismProduct;
import com.mpqi.myjiujiujintu.util.IMGSize;
import com.mpqi.myjiujiujintu.util.JJJCONFIG;
import com.mpqi.myjiujiujintu.util.JLog;
import com.mpqi.myjiujiujintu.util.Options;
import com.mpqi.myjiujiujintu.widget.ObservableScrollView;
import com.mpqi.myjiujiujintu.widget.iScrollViewListener;
import com.nostra13.universalimageloader.core.ImageLoader;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView.ScaleType;

public class MainIndexFragment extends Fragment {
	private ListView lrecommendListView;// 经理推荐
	private List<TourismProduct> ltourismProducts;// 经理推荐的产品集合
	private IndexManagerAdapter lIndexManagerAdapter;// 经理推荐的adapter
	/**
	 * 手机特卖广告图片
	 */
	private ImageView lADPicPhone0ImageView;
	private ImageView lADPicPhone1ImageView;
	private ImageView lADPicPhone2ImageView;
	private ImageView lADPicPhone3ImageView;
	private ImageView lADPicPhone4ImageView;
	private ImageView lADPicPhone5ImageView;

	private ImageView[] lADPicPhoneImageViews;

	/**
	 * 主题游广告图片
	 */
	private ImageView lADPicTheme0ImageView;
	private ImageView lADPicTheme1ImageView;
	private ImageView lADPicTheme2ImageView;
	private ImageView lADPicTheme3ImageView;
	private ImageView lADPicTheme4ImageView;

	private ImageView[] lADPicThemeImageViews;

	private ObservableScrollView lObservableScrollView;
	private ViewPager lviewPager;
	private ImageView[] ltips; // 装点点的ImageView数组
	private List<ImageView> limgList;
	private ViewGroup pointGroup;// 小圆点组
	private int lcurrentItem;// 当前顶部图片item
	private boolean isAutoPlay = true; // 自动播放，当手指滑动时改为FALSE
	
	// 标题区域
	private View titleView;
	private ImageView lcallImageView;
	private TextView llocationTextView;
	private EditText llocationEditText;
	private boolean isInitTopADImages = false;// true 已经初始化了
	private int mAlpha = 241;// 透明系数
	private boolean isGreen = true;// false 已经变为绿色

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_index, null);
		initViews(view);
		initViewPager();
		initPhoneADPics();
		initThemeADPics();
		initRecommendManagerListView();
		return view;
	}

	@Override
	public void onStart() {
		super.onStart();
		if (!isInitTopADImages) {
			new TimeThread().start();
			isInitTopADImages = true;
		}

	}

	private void initViews(View view) {
		pointGroup = (ViewGroup) view.findViewById(R.id.viewGroup);
		lviewPager = (ViewPager) view.findViewById(R.id.viewPager);
		lrecommendListView = (ListView) view
				.findViewById(R.id.index_recommend_list);

		lADPicPhone0ImageView = (ImageView) view
				.findViewById(R.id.index_phone_adpic0);
		lADPicPhone1ImageView = (ImageView) view
				.findViewById(R.id.index_phone_adpic1);
		lADPicPhone2ImageView = (ImageView) view
				.findViewById(R.id.index_phone_adpic2);
		lADPicPhone3ImageView = (ImageView) view
				.findViewById(R.id.index_phone_adpic3);
		lADPicPhone4ImageView = (ImageView) view
				.findViewById(R.id.index_phone_adpic4);
		lADPicPhone5ImageView = (ImageView) view
				.findViewById(R.id.index_phone_adpic5);
		lADPicPhoneImageViews = new ImageView[] { lADPicPhone0ImageView,
				lADPicPhone1ImageView, lADPicPhone2ImageView,
				lADPicPhone3ImageView, lADPicPhone4ImageView,
				lADPicPhone5ImageView };

		lADPicTheme0ImageView = (ImageView) view
				.findViewById(R.id.index_theme_img0);
		lADPicTheme1ImageView = (ImageView) view
				.findViewById(R.id.index_theme_img1);
		lADPicTheme2ImageView = (ImageView) view
				.findViewById(R.id.index_theme_img2);
		lADPicTheme3ImageView = (ImageView) view
				.findViewById(R.id.index_theme_img3);
		lADPicTheme4ImageView = (ImageView) view
				.findViewById(R.id.index_theme_img4);
		lADPicThemeImageViews = new ImageView[] { lADPicTheme0ImageView,
				lADPicTheme1ImageView, lADPicTheme2ImageView,
				lADPicTheme3ImageView, lADPicTheme4ImageView };

		lObservableScrollView = (ObservableScrollView) view
				.findViewById(R.id.fragment_index_scroll);
		lObservableScrollView
				.setScrollViewListener(new indexScrollViewListener());
		titleView = view.findViewById(R.id.fragment_index_title);
		llocationEditText = (EditText) view
				.findViewById(R.id.top_location_edt);
		llocationTextView = (TextView) view
				.findViewById(R.id.top_location_text);
		lcallImageView = (ImageView) view
				.findViewById(R.id.top_call);

		titleView.getBackground().setAlpha(0);
	}

	/**
	 * 初始化 viewpager
	 */
	private void initViewPager() {
		limgList = new ArrayList<ImageView>();// 要播放的图片
		// List<String> urls = new ArrayList<String>();
		// urls.add("http://qiniuphotos.qiniudn.com/gogopher.jpg");
		// urls.add("http://img4.imgtn.bdimg.com/it/u=984757508,3163070235&fm=21");
		// urls.add("http://img1.imgtn.bdimg.com/it/u=191698150,3774242073&fm=21&gp=0.jpg");
		// urls.add("http://img5.imgtn.bdimg.com/it/u=1606258999,420145522&fm=21&gp=0.jpg");
		// urls.add("http://img1.imgtn.bdimg.com/it/u=1023868808,2982592043&fm=21&gp=0.jpg");

		AVQuery<ADPic> query = new AVQuery<ADPic>(ADPic.class.getSimpleName());
		query.whereEqualTo(ADPic.ADTYPE_TEXT, ADPic.TYPE_INDEX_TOP);
		// 根据POSTION 下标 字段升序显示数据
		query.orderByAscending(ADPic.POSTION_TEXT);
		query.findInBackground(new FindCallback<ADPic>() {

			@Override
			public void done(List<ADPic> urls, AVException arg1) {
				String url;
				for (int i = 0, len = urls.size(); i < len; i++) {

					// 初始化图片资源
					ImageView imageView = new ImageView(getActivity());
					LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
							LayoutParams.WRAP_CONTENT,
							LayoutParams.WRAP_CONTENT);
					imageView.setScaleType(ScaleType.FIT_XY);
					params.height = JJJCONFIG.INDEX_TOP_H_DPI;// 设置图片控件的高度
					imageView.setLayoutParams(params);

					url = IMGSize.getImgUrl_imageView(urls.get(i).getImgUrl(),
							JJJCONFIG.INDEX_TOP_W, JJJCONFIG.INDEX_TOP_H, 2);

					JLog.iTest(url);
					limgList.add(imageView);
					ImageLoader.getInstance().displayImage(url, imageView);

					// 添加指示点
					ImageView point = new ImageView(getActivity());
					LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(
							LinearLayout.LayoutParams.WRAP_CONTENT,
							LinearLayout.LayoutParams.WRAP_CONTENT);
					params1.rightMargin = 15;// 设置指示点之间的距离
					params1.height = 10;
					params1.width = 10;
					point.setLayoutParams(params1);

					// 如果显示的是第一页，则将第一个指示点点亮，其他的指示点为默认状态
					if (i == 0) {
						point.setImageResource(R.drawable.point_green);
					} else {
						point.setImageResource(R.drawable.point_gray);
					}
					pointGroup.addView(point);// 将指示点加到显示的LinearLayout
				}
				lviewPager.setAdapter(new DefaultImgPagerAdapter(limgList));
				lviewPager
						.setOnPageChangeListener(new MyOnPageChangeListener());
				lcurrentItem = 0;
			}
		});

	}

	/**
	 * 初始化手机特卖图片
	 */
	private void initPhoneADPics() {

		AVQuery<ADPic> query = new AVQuery<ADPic>(ADPic.class.getSimpleName());
		query.whereEqualTo(ADPic.ADTYPE_TEXT, ADPic.TYPE_INDEX_PHONE);
		// 根据 createdAt 字段升序显示数据
		query.orderByAscending(ADPic.POSTION_TEXT);
		query.findInBackground(new FindCallback<ADPic>() {

			@Override
			public void done(List<ADPic> arg0, AVException arg1) {
				/*
				 * String imageUri = "http://site.com/image.png"; // from Web
				 * String imageUri = "file:///mnt/sdcard/image.png"; // from SD
				 * card String imageUri =
				 * "content://media/external/audio/albumart/13"; // from content
				 * provider String imageUri = "assets://image.png"; // from
				 * assets
				 */
				if (arg0 != null && arg0.size() != 0) {

					String url = null;
					for (int i = 0, len = arg0.size(); i < len; i++) {
						url = IMGSize.getImgUrl_imageView(arg0.get(i)
								.getImgUrl(), JJJCONFIG.INDEX_PHONE_W,
								JJJCONFIG.INDEX_PHONE_H, 2);
						JLog.iTest(url);
						ImageLoader.getInstance().displayImage(url,
								lADPicPhoneImageViews[i],
								Options.getListOptions());
					}
					url = null;
				}
			}
		});

	}

	/**
	 * 初始化主题广告图
	 */
	private void initThemeADPics() {
		AVQuery<ADPic> query = new AVQuery<ADPic>(ADPic.class.getSimpleName());
		query.whereEqualTo(ADPic.ADTYPE_TEXT, ADPic.TYPE_INDEX_THEME);
		// 根据 createdAt 字段升序显示数据
		query.orderByAscending(ADPic.POSTION_TEXT);
		query.findInBackground(new FindCallback<ADPic>() {

			@Override
			public void done(List<ADPic> arg0, AVException arg1) {
				String url = null;
				if (arg0 != null && arg0.size() != 0) {
					for (int i = 0, len = arg0.size(); i < len; i++) {

						if (i < 3) { // 前三个
							url = IMGSize.getImgUrl_imageView(arg0.get(i)
									.getImgUrl(),
									JJJCONFIG.INDEX_THEME_W_SMALL,
									JJJCONFIG.INDEX_THEME_H_SMALL, 2);
						} else {
							url = IMGSize.getImgUrl_imageView(arg0.get(i)
									.getImgUrl(),
									JJJCONFIG.INDEX_THEME_W_LARGE,
									JJJCONFIG.INDEX_THEME_H_LARGE, 2);
						}
						JLog.iTest(url);
						ImageLoader.getInstance().displayImage(url,
								lADPicThemeImageViews[i],
								Options.getListOptions());
					}
					url = null;
				}
			}

		});
	}
	
	/**
	 * 初始化经理推荐
	 */
	private void initRecommendManagerListView() {
		AVQuery<TourismProduct> query = new AVQuery<TourismProduct>(
				TourismProduct.class.getSimpleName());
		query.findInBackground(new FindCallback<TourismProduct>() {

			@Override
			public void done(List<TourismProduct> arg0, AVException arg1) {
				ltourismProducts = arg0;
				if (arg0 != null && arg0.size() != 0) {
					lIndexManagerAdapter = new IndexManagerAdapter(
							getActivity(), ltourismProducts);
					lrecommendListView.setAdapter(lIndexManagerAdapter);
					lrecommendListView.setOnItemClickListener(new OnItemClickListener() {

						@Override
						public void onItemClick(AdapterView<?> parent,
								View view, int position, long id) {
//							startActivity(new Intent(getActivity(),TourismDetailActivity.class));
							
						}
					});
				}
			}
		});
	}

	private class MyOnPageChangeListener implements OnPageChangeListener {

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// arg0 ==1的时辰默示正在滑动，arg0==2的时辰默示滑动完毕了，arg0==0的时辰默示什么都没做。
			switch (arg0) {
			case 1:
				isAutoPlay = false;
				break;
			case 2:
				isAutoPlay = true;
				break;
			case 0:
				isAutoPlay = true;
				break;
			}
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageSelected(int position) {
			// 改变指示点的状态
			for (int i = 0, len = limgList.size(); i < len; i++) {
				if (i == position) {
					ImageView imgPoint = (ImageView) pointGroup
							.getChildAt(position);
					imgPoint.setImageResource(R.drawable.point_green);
					break;
				}

			}
			// 设置没有在当前页面的指示点
			for (int i = 0, len = limgList.size(); i < len; i++) {
				ImageView imgPoint = (ImageView) pointGroup.getChildAt(i);
				if (i == position) {
					continue;
				} else {
					imgPoint.setImageResource(R.drawable.point_gray);
				}
			}
			lcurrentItem = position;
		}

	}

	private class TimeThread extends Thread {
		@Override
		public void run() {
			do {
				try {
					Thread.sleep(5000);
					if (isAutoPlay) {
						Message msg = new Message();
						msg.what = 1;
						mHandler.sendMessage(msg);
					}

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} while (true);
		}
	}

	private Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			switch (msg.what) {
			case 1:
				lcurrentItem += 1;
				if (lcurrentItem == limgList.size()) {
					lcurrentItem = 0;
				}
				lviewPager.setCurrentItem(lcurrentItem, false);
				break;
			default:
				break;
			}
		}
	};

	private class indexScrollViewListener implements iScrollViewListener {

		@Override
		public void onScrollChanged(ObservableScrollView scrollView, int x,
				int y, int oldx, int oldy) {
			JLog.iTest("x:" + x + "  y:" + y + "  oldx:" + oldx + "  oldy:"
					+ oldy);
			if (y < mAlpha) {
				titleView.getBackground().setAlpha(y);
				if (isGreen) {
					isGreen = false;
					llocationTextView.setTextColor(getResources().getColor(
							R.color.white));
					llocationTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_city_triangle_white, 0);//画在右边
					lcallImageView
							.setImageResource(R.drawable.mainpage_call_white_bg);
					llocationEditText
							.setBackgroundResource(R.drawable.bg_white_radius3);
				}

			} else if (y > mAlpha) {

				titleView.getBackground().setAlpha(mAlpha);
				if (!isGreen) {
					isGreen = true;
					llocationTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_city_triangle_green, 0);//画在右边
					llocationTextView.setTextColor(getResources().getColor(
							R.color.green_33bc60));
					lcallImageView
							.setImageResource(R.drawable.mainpage_call_bg);
					llocationEditText
							.setBackgroundResource(R.drawable.bg_gray_radius3);
				}

			}

		}

	}

}
