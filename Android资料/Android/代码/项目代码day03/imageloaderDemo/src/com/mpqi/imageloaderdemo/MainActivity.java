package com.mpqi.imageloaderdemo;

import com.mpqi.imageloaderdemo.util.IMGSize;
import com.mpqi.imageloaderdemo.util.Options;
import com.nostra13.universalimageloader.core.ImageLoader;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends Activity {
	private ImageView limageView1, limageView2, limageView3, limageView4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		limageView1 = (ImageView) findViewById(R.id.imageView1);
		limageView2 = (ImageView) findViewById(R.id.imageView2);
		limageView3 = (ImageView) findViewById(R.id.imageView3);
		limageView4 = (ImageView) findViewById(R.id.imageView4);

		// 默认显示图片 没有任何显示配置
		ImageLoader.getInstance().displayImage(
				"http://qiniuphotos.qiniudn.com/gogopher.jpg", limageView1);

		// 显示网络图片 并有显示配置 有加载时的默认图片 并把网络加载的图片缓存到本地磁盘
		ImageLoader.getInstance().displayImage(
				"http://ac-sxp70bmr.clouddn.com/3a97974a4deaa02b.jpg", limageView2,
				Options.getListOptions());

		ImageLoader.getInstance().displayImage(
				IMGSize.getImgUrl_imageView("http://ac-sxp70bmr.clouddn.com/3a97974a4deaa02b.jpg",
						20, 45, 1), limageView3, Options.getListOptions());

		ImageLoader.getInstance().displayImage(
				IMGSize.getImgUrl_imageMogr("http://ac-sxp70bmr.clouddn.com/3a97974a4deaa02b.jpg",
						230, 50, 150, 150), limageView4,
				Options.getListOptions());

		// 手动清除缓存目录下的图片文件
		// ImageLoader.getInstance().clearDiscCache();
	}
}
