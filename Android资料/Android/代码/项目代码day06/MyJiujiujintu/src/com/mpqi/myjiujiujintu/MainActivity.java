package com.mpqi.myjiujiujintu;

import java.util.Timer;
import java.util.TimerTask;

import com.mpqi.myjiujiujintu.fragment.MainIndexFragment;
import com.mpqi.myjiujiujintu.fragment.MainMoreFragment;
import com.mpqi.myjiujiujintu.fragment.MainPicFragment;
import com.mpqi.myjiujiujintu.fragment.MainTypeFragment;
import com.mpqi.myjiujiujintu.fragment.MainUserFragment;
import com.mpqi.myjiujiujintu.fragment.SearchCityFragment;
import com.mpqi.myjiujiujintu.fragment.iTopTitleListener;
import com.mpqi.myjiujiujintu.fragment.SearchCityFragment.SetChoosedNameListner;
import com.mpqi.myjiujiujintu.util.JJJCONFIG;
import com.mpqi.myjiujiujintu.widget.MaskImage;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

/**
 * 主程序
 * 
 * @author mpqi
 *
 */
public class MainActivity extends Activity implements SetChoosedNameListner {
	// private ViewPager lviewPager;
	// private ArrayList<Fragment> lfragments;
	private int lcurmainMaskImageId = R.id.mainbar1;

	private SearchCityFragment lSearchCityFragment;// 定位位置
	private MainIndexFragment fragment1;// MainIndexFragment();
	private MainTypeFragment fragment2;// MainTypeFragment();
	private MainUserFragment fragment4;// MainUserFragment();
	private MainPicFragment fragment3;// MainPicFragment();
	private MainMoreFragment fragment5;// new MainMoreFragment
	private Fragment[] lfragments;

	private int lcurFragment;//当前fragment

	private boolean searchFlag = false;// true 显示定位位置内容
	private String choosedName = "成都";
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		initViewPager();
	}

	private void initView() {
		// lviewPager = (ViewPager) findViewById(R.id.mainviewPager);
		lSearchCityFragment = new SearchCityFragment();
		
	}

	private void initViewPager() {
		// lfragments = new ArrayList<Fragment>();

		fragment1 = new MainIndexFragment();
		fragment2 = new MainTypeFragment();
		fragment4 = new MainUserFragment();
		fragment3 = new MainPicFragment();
		fragment5 = new MainMoreFragment();

		lfragments = new Fragment[] { fragment1, fragment2, fragment3,
				fragment4, fragment5 };
		FragmentTransaction ftTransaction = getFragmentManager()
				.beginTransaction();
		ftTransaction.add(R.id.main_content, lfragments[4]);
		ftTransaction.add(R.id.main_content, lfragments[3]);
		ftTransaction.add(R.id.main_content, lfragments[2]);
		ftTransaction.add(R.id.main_content, lfragments[1]);
		ftTransaction.add(R.id.main_content, lfragments[0]);
		ftTransaction.hide(lfragments[4]);
		ftTransaction.hide(lfragments[3]);
		ftTransaction.hide(lfragments[2]);
		ftTransaction.hide(lfragments[1]);
		ftTransaction.commit();
		lcurFragment = 0;
		
		// lfragments.add(fragment1);
		// lfragments.add(fragment2);
		// lfragments.add(fragment3);
		// lfragments.add(fragment4);
		// lfragments.add(fragment5);

		// lviewPager.setAdapter(new FragmentPagerAdapter(
		// getSupportFragmentManager()) {
		//
		// @Override
		// public int getCount() {
		// return lfragments.size();
		// }
		//
		// @Override
		// public Fragment getItem(int arg0) {
		// return lfragments.get(arg0);
		// }
		// });
		//
		// lviewPager.setCurrentItem(0);
	}

	/**
	 * 底部菜单点击事件
	 * 
	 * @param view
	 */
	public void onclcikMainrBar(View view) {
		int id = view.getId();
		if (id == lcurmainMaskImageId) {// 如果当前点击的是当前页面的导航，则跳出该函数
			return;
		}
		// 把刚才的那个导航按钮变成灰色背景
		MaskImage maskImage = (MaskImage) findViewById(lcurmainMaskImageId);
		maskImage.setmImageSource(R.drawable.mainbarbackground_norlmal);
		maskImage.refresh();
		FragmentTransaction ftTransaction = getFragmentManager()
				.beginTransaction();
		ftTransaction.hide(lfragments[lcurFragment]);
		switch (id) {
		case R.id.mainbar1:
			lcurmainMaskImageId = R.id.mainbar1;
			lcurFragment = 0;
			((iTopTitleListener)lfragments[lcurFragment]).setLocal(choosedName);
			// lviewPager.setCurrentItem(0);
			break;
		case R.id.mainbar2:
			lcurmainMaskImageId = R.id.mainbar2;
			lcurFragment = 1;
			((iTopTitleListener)lfragments[lcurFragment]).setLocal(choosedName);
			// lviewPager.setCurrentItem(1);
			break;
		case R.id.mainbar3:
			lcurmainMaskImageId = R.id.mainbar3;
			lcurFragment = 2;
			// lviewPager.setCurrentItem(2);
			break;
		case R.id.mainbar4:
			lcurmainMaskImageId = R.id.mainbar4;
			lcurFragment = 3;
			// lviewPager.setCurrentItem(3);
			break;
		case R.id.mainbar5:
			lcurmainMaskImageId = R.id.mainbar5;
			lcurFragment = 4;
			// lviewPager.setCurrentItem(4);
			break;
		}

		// 把当前的导航按钮变成绿色背景
		maskImage = (MaskImage) findViewById(lcurmainMaskImageId);
		maskImage.setmImageSource(R.drawable.mainbarbackground_green);
		maskImage.refresh();

		maskImage = null;
		ftTransaction.show(lfragments[lcurFragment]);
		ftTransaction.commit();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (resultCode) {
		case JJJCONFIG.REGIST_RESULT_SUCCESS:// 注册成功
			Toast.makeText(this, "恭喜，注册成功", Toast.LENGTH_SHORT).show();
			fragment4.isLogin();
			break;
		case JJJCONFIG.LOGIN_RESULT_SUCCESS:// 登录成功
			Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
			fragment4.isLogin();
			break;
		}
	}

	/**
	 * 选择当前位置
	 * 
	 * @param view
	 */
	public void searchOnclick(View view) {
		switch (view.getId()) {
		case R.id.top_location_text:
			lSearchCityFragment.setChoosedName(choosedName);
			FragmentTransaction ftTransaction = getFragmentManager()
					.beginTransaction();
			ftTransaction.setCustomAnimations(
					R.anim.fragment_searchcity_silde_bottom_in, 0);
			ftTransaction.add(R.id.main_search_city_content,
					lSearchCityFragment);
			ftTransaction.commit();
			searchFlag = true;
			break;
		}
	}

	/**
	 * 菜单、返回键响应
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if (searchFlag) {
				searchFlag = false;
				FragmentTransaction ftTransaction = getFragmentManager()
						.beginTransaction();
				ftTransaction.setCustomAnimations(0,
						R.anim.fragment_searchcity_silde_bottom_out);
				ftTransaction.remove(lSearchCityFragment);
				ftTransaction.commit();
			} else {
				exitBy2Click(); // 调用双击退出函数
			}

		}
		return false;
	}

	/**
	 * 双击退出函数
	 */
	private static Boolean isExit = false;

	private void exitBy2Click() {
		Timer tExit = null;
		if (isExit == false) {
			isExit = true; // 准备退出
			Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
			tExit = new Timer();
			tExit.schedule(new TimerTask() {
				@Override
				public void run() {
					isExit = false; // 取消退出
				}
			}, 2000); // 如果2秒钟内没有按下返回键，则启动定时器取消掉刚才执行的任务

		} else {
			finish();
			System.exit(0);
		}
	}

	@Override
	public void setChoosedName(String choosedName) {
		this.choosedName = choosedName;

	}

	@Override
	public void close() {
		searchFlag = false;
		FragmentTransaction ftTransaction = getFragmentManager()
				.beginTransaction();
		ftTransaction.setCustomAnimations(0,
				R.anim.fragment_searchcity_silde_bottom_out);
		ftTransaction.remove(lSearchCityFragment);
		ftTransaction.commit();
		((iTopTitleListener)lfragments[lcurFragment]).setLocal(choosedName);
	}

	@Override
	public String getChoosedName() {
		return choosedName;
	}
}
