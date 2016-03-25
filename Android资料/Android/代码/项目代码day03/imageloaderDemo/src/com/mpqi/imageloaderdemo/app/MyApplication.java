package com.mpqi.imageloaderdemo.app;

import java.io.File;

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

public class MyApplication extends Application{
	
	@Override
	public void onCreate() {
		super.onCreate();
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
}
