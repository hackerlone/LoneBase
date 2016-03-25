package com.jiujiu.jintu.fragment;

import java.util.List;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;
import com.jiujiu.jintu.R;
import com.jiujiu.jintu.bean.TypeGroup;
import com.jiujiu.jintu.util.IMGSize;
import com.jiujiu.jintu.util.JJJCONFIG;
import com.jiujiu.jintu.util.JLog;
import com.jiujiu.jintu.util.Options;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;

import android.support.v4.app.Fragment;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * 附近 分类
 * 
 * @author mpqi-i7
 *
 */
public class MainTypeFragment extends Fragment  {

	private ListView ltypeListView;
	private List<TypeGroup> lTypeGroups;
	private ImageLoader imageLoader;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_type, container, false);
		initViews(view);
		initListview();
		return view;

	}

	private void initViews(View view) {
		ltypeListView = (ListView) view.findViewById(R.id.type_list);
		imageLoader = ImageLoader.getInstance();
	}

	private void initListview() {
		AVQuery<TypeGroup> query = new AVQuery<TypeGroup>(
				TypeGroup.class.getSimpleName());
		// 根据 createdAt 字段升序显示数据
		query.orderByAscending(TypeGroup.POSITION_TEXT);
		query.findInBackground(new FindCallback<TypeGroup>() {

			@Override
			public void done(List<TypeGroup> arg0, AVException arg1) {
				if (arg0 != null && arg0.size() != 0) {
					lTypeGroups = arg0;
					ltypeListView.setAdapter(new TypeAdapter());
				}

			}
		});
	}

	private class TypeAdapter extends BaseAdapter {
		private class CoverHover {
			private ImageView imageView;
			private TextView title1TextView;
			private TextView title2TextView;
		}

		LayoutInflater inflater;

		public TypeAdapter() {
			inflater = LayoutInflater.from(getActivity());
		}

		@Override
		public int getCount() {
			return lTypeGroups.size();
		}

		@Override
		public Object getItem(int position) {
			return lTypeGroups.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			CoverHover hover = null;
			TypeGroup typeGroup = lTypeGroups.get(position);
			if (convertView == null) {
				convertView = inflater.inflate(R.layout.item_fragment_type, null);
				hover = new CoverHover();
				hover.imageView = (ImageView) convertView
						.findViewById(R.id.item_type_title_img);
				hover.title1TextView = (TextView) convertView
						.findViewById(R.id.item_type_title_text);
				hover.title2TextView = (TextView) convertView
						.findViewById(R.id.item_type_title2_text);
				convertView.setTag(hover);
			} else {
				hover = (CoverHover) convertView.getTag();
			}
			hover.title1TextView.setText(typeGroup.getTitle1());
			hover.title2TextView.setText(typeGroup.getTitle2());
			String url = IMGSize.getImgUrl_imageView(typeGroup.getImgUrl(),
					JJJCONFIG.ITEM_ICON_W, JJJCONFIG.ITEM_ICON_H, 2);

			JLog.iTest(url);
			hover.imageView.setTag(url);

			imageLoader.displayImage(url, hover.imageView,
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

	}
}
