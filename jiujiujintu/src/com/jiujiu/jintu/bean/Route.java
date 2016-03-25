package com.jiujiu.jintu.bean;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

/**
 * 行程
 * @author mpqi-i7
 *
 */
@AVClassName("Route")
public class Route extends AVObject{
	private TourismProduct tourismProduct;//旅游产品
	private String title;//标题
	private String titleIcon;//标题Icon
	private String titleType;//标题类型
	private int position;//顺序位置
	private String content;//文字内容
}
