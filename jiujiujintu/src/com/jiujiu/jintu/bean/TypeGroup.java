package com.jiujiu.jintu.bean;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

/**
 * 附近 分类
 * 
 * @author mpqi-i7
 *
 */
@AVClassName("TypeGroup")
public class TypeGroup extends AVObject {
	private String imgUrl;
	private String title1; //主标题
	private String title2; //副标题
	private int position; //下标

	public final static String IMGURL_TEXT = "imgUrl";
	public final static String TITLE1_TEXT = "title1";
	public final static String TITLE2_TEXT = "title2";
	public final static String POSITION_TEXT = "position";

	public TypeGroup() {
	}

	public String getImgUrl() {
		return getString(IMGURL_TEXT);
	}

	public void setImgUrl(String imgUrl) {
		put(IMGURL_TEXT, imgUrl);
	}

	public String getTitle1() {
		return getString(TITLE1_TEXT);
	}

	public void setTitle1(String title1) {
		put(TITLE1_TEXT, title1);
	}

	public String getTitle2() {
		return getString(TITLE2_TEXT);
	}

	public void setTitle2(String title2) {
		put(TITLE2_TEXT, title2);
	}

	public int getPosition() {
		return getInt(POSITION_TEXT);
	}

	public void setPosition(int position) {
		put(POSITION_TEXT, position);
	}

}
