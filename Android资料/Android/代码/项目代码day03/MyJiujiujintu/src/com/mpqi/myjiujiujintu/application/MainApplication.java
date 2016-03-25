package com.mpqi.myjiujiujintu.application;

import java.io.File;

import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVObject;
import com.mpqi.myjiujiujintu.bean.ADPic;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;

import android.app.Application;

public class MainApplication extends Application{

	@Override
	public void onCreate() {
		super.onCreate();
		AVObject.registerSubclass(ADPic.class);
		AVOSCloud.initialize(this,
				"sxp70bmrjxib2w1rzppp0sli0ffjeexu193dlc50v27n0135",
				"los07ul613fo1pfzrfvv5lrp69umailbbwlldv98p3r3etdb");
		initimagelodaer();
	}
	
	/**
	 * 初始化 imagelaoder 框架配置
	 */
	private void initimagelodaer(){
		//配置缓存路径
		File cacheDir = StorageUtils.getOwnCacheDirectory(this,"MPQI/Cache" );
		// 1.完成ImageLoaderConfiguration的配置
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
				this)
				// max width, max,height，即保存的每个缓存文件的最大长宽
				// .memoryCacheExtraOptions(400, 400)
				// 线程池内加载的数量
				.threadPoolSize(3)
				// 线程优先级
				.threadPriority(Thread.NORM_PRIORITY - 2)
				// 硬盘缓存50MB
				.discCacheSize(50 * 1024 * 1024)
				// 将保存的时候的URI名称用MD5
				.discCacheFileNameGenerator(new Md5FileNameGenerator())
				// 将保存的时候的URI名称用HASHCODE加密
				.discCacheFileNameGenerator(new HashCodeFileNameGenerator())
				.tasksProcessingOrder(QueueProcessingType.LIFO)
				// 缓存的File数量
				.discCacheFileCount(100)
				// 自定义缓存路径
				.discCache(new UnlimitedDiscCache(cacheDir))
				.defaultDisplayImageOptions(DisplayImageOptions.createSimple())
				// connectTimeout (5 s), readTimeout (30 s)超时时间
				.imageDownloader(
						new BaseImageDownloader(this, 5 * 1000, 30 * 1000))
				.build();
		ImageLoader.getInstance().init(config);
	}
	
	/**
	 * 初始化广告图片
	 */
	private void initADPics() {
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
