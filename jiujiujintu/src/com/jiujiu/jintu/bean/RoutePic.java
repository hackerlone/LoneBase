package com.jiujiu.jintu.bean;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

/**
 * 行程内容图片
 * @author mpqi-i7
 *
 */
@AVClassName("RoutePic")
public class RoutePic extends AVObject{
	private String imgUrl;
	private Route route;//行程
}
