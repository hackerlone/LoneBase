package com.jiujiu.jintu;

import android.app.Activity;
import android.os.Bundle;

/**
 * 旅游产品详情
 * 
 * @author mpqi
 *
 */
public class TourismDetailActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_tourism_detail);
		initViews();
		initDetail();
		/*Drawable drawable = getResources().getDrawable(img[i]);
		drawable.setBounds(0, 0, drawable.getMinimumWidth(),
				drawable.getMinimumHeight());
		mTextView.setCompoundDrawables(drawable, null, null, null);// 设置TextView的drawableleft
		mTextView.setCompoundDrawablePadding(10);// 设置图片和text之间的间距
		mTextView.setText(mSelfSelect[i]);*/
	}
	
	private void initViews(){
		
	}
	
	/**
	 * 初始化数据
	 */
	private void initDetail(){
		
	}
}
