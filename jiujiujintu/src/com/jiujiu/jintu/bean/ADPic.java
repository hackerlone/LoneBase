package com.jiujiu.jintu.bean;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

/**
 * 广告图片
 * 
 * @author mpqi-i7
 *
 */
@AVClassName("ADPic")
public class ADPic extends AVObject {
	private String imgUrl;
	private String adType;//类型
	private int position; //下标指针

	public final static String IMGURL_TEXT = "imgUrl";
	public final static String ADTYPE_TEXT = "adType";
	public final static String POSTION_TEXT = "position";

	public final static String TYPE_INDEX_PHONE = "index_phone";// 首页手机特卖
	public final static String TYPE_INDEX_THEME = "index_theme";// 首页主题游
	public final static String TYPE_INDEX_TOP = "index_top";// 顶部横滑广告

	public ADPic() {
	}

	public String getImgUrl() {
		return getString(IMGURL_TEXT);
	}

	public void setImgUrl(String imgUrl) {
		put(IMGURL_TEXT, imgUrl);
	}

	public String getAdType() {
		return getString(ADTYPE_TEXT);
	}

	public void setAdType(String adType) {
		put(ADTYPE_TEXT, adType);
	}

	public int getPosition() {
		return getInt(POSTION_TEXT);
	}

	public void setPosition(int position) {
		put(POSTION_TEXT, position);
	}

}
