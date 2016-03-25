package com.mpqi.myjiujiujintu.application;

import com.mpqi.myjiujiujintu.bean.ADPic;

public class InitData {
	/**
	 * 初始化广告图片
	 */
	public void initADPics() {
		initADPic("http://ac-sxp70bmr.clouddn.com/728e24b003243b90.jpg",
				ADPic.TYPE_INDEX_TOP, 0);
		initADPic("http://ac-sxp70bmr.clouddn.com/490d16508a799c21.jpg",
				ADPic.TYPE_INDEX_TOP, 1);
		initADPic("http://ac-sxp70bmr.clouddn.com/4246c908a3ab4cc8.jpeg",
				ADPic.TYPE_INDEX_TOP, 2);
		initADPic("http://ac-sxp70bmr.clouddn.com/daf7b541e42bfe57.jpg",
				ADPic.TYPE_INDEX_TOP, 3);
		initADPic("http://ac-sxp70bmr.clouddn.com/2edb2c2522ca3af1.jpg",
				ADPic.TYPE_INDEX_TOP, 4);
	}

	
	private void initADPic(String imgUrl, String adType, int position) {
		ADPic adPic = new ADPic();
		adPic.setImgUrl(imgUrl);
		adPic.setAdType(adType);
		adPic.setPosition(position);
		adPic.saveInBackground();
	}
}
