package com.jiujiu.jintu.adapter;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class DefaultImgPagerAdapter extends PagerAdapter{
	
	private List<ImageView> limgList;
	
	public DefaultImgPagerAdapter(List<ImageView> limgList) {
		this.limgList = limgList;
	}

	public int getCount() {
		return limgList.size();
	}

	public Object instantiateItem(ViewGroup container, int position) {
		container.addView(limgList.get(position));
		return limgList.get(position);
	}

	public boolean isViewFromObject(View view, Object object) {
		if (view == object) {
			return true;
		} else {
			return false;
		}
	}

	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView((View) object);
		object = null;
	}

}
