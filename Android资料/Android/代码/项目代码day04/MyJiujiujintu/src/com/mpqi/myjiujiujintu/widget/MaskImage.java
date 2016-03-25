package com.mpqi.myjiujiujintu.widget;

import com.mpqi.myjiujiujintu.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * 底部图片遮罩层渲染
 * 
 * @author mpqi
 *
 */
public class MaskImage extends ImageView {
	int mImageSource = 0; // 图片资源
	int mMaskSource = 0; // 底层图片资源
	RuntimeException mException;

	/**
	 * AttributeSet 属性
	 */
	public MaskImage(Context context, AttributeSet attrs) {
		super(context, attrs);
		TypedArray a = getContext().obtainStyledAttributes(attrs,
				R.styleable.MaskImage, 0, 0);

		mImageSource = a.getResourceId(R.styleable.MaskImage_image, 0);
		mMaskSource = a.getResourceId(R.styleable.MaskImage_mask, 0);

		if (mImageSource == 0 || mMaskSource == 0) {// 任意一个为空，就拋错
			mException = new IllegalArgumentException(
					a.getPositionDescription()
							+ ": The content attribute is required and must refer to a valid image.");
		}

		if (mException != null)
			throw mException;
		refresh();
		a.recycle();// 回收资源
	}

	/**
	 * 主要代码实现
	 */
	public void refresh() {
		// 获取图片的资源文件 背景图 绿色 或 灰色
		Bitmap original = BitmapFactory.decodeResource(getResources(),
				mImageSource);
		// 获取遮罩层图片 各种导航图片
		Bitmap mask = BitmapFactory.decodeResource(getResources(), mMaskSource);
		// 定义空的结果图片 用于设置给imageview src 显示出来
		Bitmap result = Bitmap.createBitmap(mask.getWidth(), mask.getHeight(),
				Config.ARGB_8888);

		// 生命绘制的工具
		// 为结果图 reslut 申明一张画布 用于绘制效果
		Canvas canvas = new Canvas(result);
		// 申明一只特殊的画笔 用于绘制 渲染效果
		Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		// 为画笔设置渲染 遮罩 效果 叠加重复的部分，显示下面的内容
		paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));

		// 开始绘制最终效果图片
		// 绘制背景 （方形的绿色、灰色）
		canvas.drawBitmap(original, 0, 0, null);
		// 绘制遮罩层 导航图片
		canvas.drawBitmap(mask, 0, 0, paint);

		// 笔 释放资源
		paint.setXfermode(null);

		// 设置图片控件显示的图片资源
		setImageBitmap(result);
		// 为图片设置居中
		setScaleType(ScaleType.CENTER);
	}

	public void setmImageSource(int mImageSource) {
		this.mImageSource = mImageSource;
	}

	public void setmMaskSource(int mMaskSource) {
		this.mMaskSource = mMaskSource;
	}

}
