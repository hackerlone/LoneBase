package com.jiujiu.jintu.util;

public class IMGSize {
	private static String imageView = "?imageView/";// 生成指定规格的缩略图
	private static String imageMogr = "?imageMogr/v2/auto-orient/";// 裁剪图片

	/**
	 * 生成指定规格的缩略图
	 * 
	 * @param url
	 *            图片地址 不可以为空
	 * @param w
	 *            宽 可以为空
	 * @param h
	 *            高 可以为空
	 * 
	 * @param mode
	 *            缩略模式
	 * @return <ImageDownloadURL>?imageView/<mode> /w/<Width>
	 *         /h/<Height>/q/<Quality> /format/<Format>
	 * 
	 *         http://qiniuphotos.qiniudn.com/gogopher.jpg?imageView/1/w/200/h/
	 *         200
	 * 
	 *         <mode> 图像缩略处理的模式 <Width> 指定目标缩略图的宽度，单位：像素（px） <Height>
	 *         指定目标缩略图的高度，单位：像素（px <Quality> 指定目标缩略图的图像质量，取值范围 1-100 <Format>
	 *         指定目标缩略图的输出格式，取值范围：jpg, gif, png, webp 等图片格式
	 * 
	 *         <mode>=1 表示限定目标缩略图的宽度和高度，放大并从缩略图中央处裁剪为指定 <Width>x<Height> 大小的图片。
	 *         <mode>=2 指定 <Width> 和 <Height>，表示限定目标缩略图的长和宽，将缩略图的大小限定在指定的宽高矩形内。
	 *         <mode>=2 指定 <Width> 但不指定 <Height>，表示限定目标缩略图的宽度，高度等比缩略自适应。
	 *         <mode>=2 指定 <Height> 但不指定 <Width>，表示限定目标缩略图的高度，宽度等比缩略自适应。
	 * 
	 *         如下是 /thumbnail/<ImageSizeGeometry> 和
	 *         /crop/<ImageSizeAndOffsetGeometry> 参数规格详解。
	 * 
	 *         参考：http://docs.qiniu.com/api/v6/image-process.html
	 */
	public static String getImgUrl_imageView(String url, int w, int h, int mode) {
		if (w < 1 && h < 1) {// 如果 宽和高都为空 就返回远url
			return url;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(url);

		if (mode < 1 || mode > 2) {
			sb.append(imageView).append(2);
		} else {
			sb.append(imageView).append(mode);			
		}

		if (w > 0) {
			sb.append("/").append("w").append("/").append(w);
		}
		if (h > 0) {
			sb.append("/").append("h").append("/").append(h);
		}

		return sb.toString();
	}

	/***
	 * 高级图像处理接口（第二版）（缩略、裁剪、旋转、转化）
	 * 
	 * @param url
	 *            图片地址 不可以为空
	 * @param crop_w
	 *            裁剪的宽
	 * @param crop_h
	 *            裁剪的高
	 * @param thumbnail_w
	 *            裁剪后生成图片的宽
	 * @param thumbnail_h
	 *            裁剪后生成图片的高
	 * 
	 * @return <ImageDownloadURL>?imageMogr/v2 /auto-orient
	 *         /thumbnail/<ImageSizeGeometry> /gravity/<GravityType>
	 *         /crop/<ImageSizeAndOffsetGeometry> /quality/<ImageQuality>
	 *         /rotate/<RotateDegree> /format/<DestinationImageFormat>
	 * 
	 *         参考：http://docs.qiniu.com/api/v6/image-process.html
	 */
	public static String getImgUrl_imageMogr(String url, int crop_w,
			int crop_h, int thumbnail_w, int thumbnail_h) {
		StringBuilder sb = new StringBuilder();
		sb.append(url).append(imageMogr).append("crop/!");
		if (crop_w > 0) {
			sb.append(crop_w);
		}
		if (crop_h > 0) {
			sb.append("x").append(crop_h);
		}
		sb.append("/thumbnail/!");
		if (thumbnail_w > 0) {
			sb.append(thumbnail_w);
		}
		if (thumbnail_h > 0) {
			sb.append("x").append(thumbnail_h);
		}

		return sb.toString();
	}
}
