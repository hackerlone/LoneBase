package com.jiujiu.jintu.application;

import java.io.File;

import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVObject;
import com.jiujiu.jintu.bean.ADPic;
import com.jiujiu.jintu.bean.Route;
import com.jiujiu.jintu.bean.RoutePic;
import com.jiujiu.jintu.bean.TourismProduct;
import com.jiujiu.jintu.bean.TypeGroup;
import com.jiujiu.jintu.util.JJJCONFIG;
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

public class MainApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		AVObject.registerSubclass(TourismProduct.class);
		AVObject.registerSubclass(ADPic.class);
		AVObject.registerSubclass(TypeGroup.class);
		AVObject.registerSubclass(Route.class);
		AVObject.registerSubclass(RoutePic.class);
		AVOSCloud.initialize(this,
				"sxp70bmrjxib2w1rzppp0sli0ffjeexu193dlc50v27n0135",
				"los07ul613fo1pfzrfvv5lrp69umailbbwlldv98p3r3etdb");
		initImageLoader();
	}

	/**
	 * 初始化ImageLoader
	 */
	private void initImageLoader() {
		File cacheDir = StorageUtils.getOwnCacheDirectory(this,
				JJJCONFIG.cacheIMGDir);// 获取到缓存的目录地址
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
		ImageLoader.getInstance().init(config);// 全局初始化此配置
	}

	private void initADPics() {
		initADPic("http://ac-sxp70bmr.clouddn.com/64a17a0a47fbb16d.png",
				ADPic.TYPE_INDEX_PHONE, 0);
		initADPic("http://ac-sxp70bmr.clouddn.com/1ea3ecda6a19ade7.png",
				ADPic.TYPE_INDEX_PHONE, 1);
		initADPic("http://ac-sxp70bmr.clouddn.com/00728cd47b372260.png",
				ADPic.TYPE_INDEX_PHONE, 2);
		initADPic("http://ac-sxp70bmr.clouddn.com/27263fc96923d096.png",
				ADPic.TYPE_INDEX_PHONE, 3);
		initADPic("http://ac-sxp70bmr.clouddn.com/3bcf7a3cfe3cc768.png",
				ADPic.TYPE_INDEX_PHONE, 4);
		initADPic("http://ac-sxp70bmr.clouddn.com/c16090a2a6cf6ebc.png",
				ADPic.TYPE_INDEX_PHONE, 5);

		initADPic("http://ac-sxp70bmr.clouddn.com/7a29e92b14159f2c.png",
				ADPic.TYPE_INDEX_THEME, 0);
		initADPic("http://ac-sxp70bmr.clouddn.com/726e6b0ef37f7805.png",
				ADPic.TYPE_INDEX_THEME, 1);
		initADPic("http://ac-sxp70bmr.clouddn.com/3323ac0f1683ada0.png",
				ADPic.TYPE_INDEX_THEME, 2);
		initADPic("http://ac-sxp70bmr.clouddn.com/60f1bd52dfe79357.png",
				ADPic.TYPE_INDEX_THEME, 3);
		initADPic("http://ac-sxp70bmr.clouddn.com/56fb2a6360784f39.png",
				ADPic.TYPE_INDEX_THEME, 4);

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

	private void initTourismProducts() {
		initTourismProduct(
				"http://ac-sxp70bmr.clouddn.com/b156c81e61ad7d64.jpg", "98",
				"9849", "9995", "[国庆]<欧洲八国15日游>成都起止，卢浮宫入内，畅游欧洲");

		initTourismProduct(
				"http://ac-sxp70bmr.clouddn.com/1dc31e07d93207be.jpg", "91",
				"498", "558", "<九寨沟-黄龙双汽3日游>王牌产品，销量冠军，累计出游3万人");

		initTourismProduct(
				"http://ac-sxp70bmr.clouddn.com/836515874e288b1c.jpg", "79",
				"2580", "2680", "<稻城-亚丁单汽单飞5日游>初游首选 报名立减100元每人");

		initTourismProduct(
				"http://ac-sxp70bmr.clouddn.com/8388dab59bf53d71.jpg", "77",
				"397", "399", "<若尔盖大草原-九曲花湖3日游>赠双晚会，全程自愿消费");

		initTourismProduct(
				"http://ac-sxp70bmr.clouddn.com/7776a99b637775cb.jpg", "100",
				"3364", "3379", "<普吉岛5晚6日游>2天自由活动1晚私人沙滩国际五星，浮潜");

		initTourismProduct(
				"http://ac-sxp70bmr.clouddn.com/3a97974a4deaa02b.jpg", "99",
				"3278", "3295", "[国庆]<曼谷-芭提雅5晚6日游>热卖0自费 夜游唐人街");

		initTourismProduct(
				"http://ac-sxp70bmr.clouddn.com/2a875dd6e1a7b992.jpg", "100",
				"5315", "5335", "<日本本州6晚7日游>成都直飞大阪，双世界遗产 千年古都");

		initTourismProduct(
				"http://ac-sxp70bmr.clouddn.com/e6d0406dbc5682ad.jpg", "87",
				"3063", "3069", "<韩国首尔-济州6日游>免签证，成都起止，首进济出不走回头路");

		initTourismProduct(
				"http://ac-sxp70bmr.clouddn.com/a826c847a6c47751.jpg", "97",
				"2289", "3499", "<海南三亚5日游>4晚当地五星酒店，赠海鲜火锅，每天睡到自然醒");

	}

	private void initTypeGroups() {
		initTypeGroup("http://ac-sxp70bmr.clouddn.com/9c873571079e8898.png",
				"跟团游", "国内 出境 透明团放心游", 0);
		initTypeGroup("http://ac-sxp70bmr.clouddn.com/43688c44efc37e60.png",
				"周边游", "山水风光 一览无余", 1);
		initTypeGroup("http://ac-sxp70bmr.clouddn.com/cf36eff825910c53.png",
				"自助游", "机票+酒店 优惠省心游全球", 2);
		initTypeGroup("http://ac-sxp70bmr.clouddn.com/08007364ef2ba638.png",
				"机+酒自由选", "自在选择 任您搭配", 4);
		initTypeGroup("http://ac-sxp70bmr.clouddn.com/fddc6a42fa339125.png",
				"邮轮", "全球航线 畅游海上 超乎想象", 5);
		initTypeGroup("http://ac-sxp70bmr.clouddn.com/c0bb1a482ff6e6ef.png",
				"景点门票", "名山胜水 温泉 主题乐园门票", 6);
		initTypeGroup("http://ac-sxp70bmr.clouddn.com/a1e3e112ce45bd91.png",
				"自驾游", "景点+酒店 超值度周末", 7);
		initTypeGroup("http://ac-sxp70bmr.clouddn.com/530d71bda40fb7bc.png",
				"当地玩乐", "乐游全球 深度自由", 8);
		initTypeGroup("http://ac-sxp70bmr.clouddn.com/87ea9518c5b4545c.png",
				"签证", "旅游 商务 探亲签证", 9);
		initTypeGroup("http://ac-sxp70bmr.clouddn.com/9dec7a9dc8e8e56b.png",
				"1元夺宝", "小米手环 手机单反 1元抢夺", 10);
		initTypeGroup("http://ac-sxp70bmr.clouddn.com/0d3f2a3044453f41.png",
				"酒店", "客栈 舒适 豪华酒店", 11);
		initTypeGroup("http://ac-sxp70bmr.clouddn.com/06b6b79b48727f7f.png",
				"机票", "航协认证 更多保障 更低价格", 12);
		initTypeGroup("http://ac-sxp70bmr.clouddn.com/9680ce13e7915eff.png",
				"火车票", "手机在线预订 提前60天购票", 13);
		initTypeGroup("http://ac-sxp70bmr.clouddn.com/cb47dca4de6423ab.png",
				"久久宝", "稳健货币基金 安全可靠 随时存", 14);
		initTypeGroup("http://ac-sxp70bmr.clouddn.com/52a9c46e92013878.png",
				"牛无线", "随身WiFi无限量 漫游天下", 15);
		initTypeGroup("http://ac-sxp70bmr.clouddn.com/3bbbdbe39df8ed0e.png",
				"牛人定制", "私人定制 公司旅游 亲友包团", 16);
		initTypeGroup("http://ac-sxp70bmr.clouddn.com/db79a535b7278a35.png",
				"礼品卡购买", "送礼首选 优惠套餐返利", 17);
		initTypeGroup("http://ac-sxp70bmr.clouddn.com/132997a405bd4eee.png",
				"预订三峡旅游", "三峡观光 独家在线预约", 18);
		initTypeGroup("http://ac-sxp70bmr.clouddn.com/ffd81486bbf753c7.png",
				"购物退税", "在线申请 轻松退税", 10);
	}

	private void initTypeGroup(String imgUrl, String title1, String title2,
			int position) {
		TypeGroup typeGroup = new TypeGroup();
		typeGroup.setImgUrl(imgUrl);
		typeGroup.setTitle1(title1);
		typeGroup.setTitle2(title2);
		typeGroup.setPosition(position);
		typeGroup.saveInBackground();
	}

	private void initTourismProduct(String ImgTitleUrl, String Atisfaction,
			String PriceNew, String setPriceOld, String Title) {
		TourismProduct tProduct = new TourismProduct();
		tProduct.setImgTitleUrl(ImgTitleUrl);
		tProduct.setAtisfaction(Atisfaction);
		tProduct.setPriceNew(PriceNew);
		tProduct.setPriceOld(setPriceOld);
		tProduct.setTitle(Title);
		tProduct.saveInBackground();
	}

	private void initADPic(String imgUrl, String adType, int position) {
		ADPic adPic = new ADPic();
		adPic.setImgUrl(imgUrl);
		adPic.setAdType(adType);
		adPic.setPosition(position);
		adPic.saveInBackground();
	}
}
