package com.mpqi.viewpagerdemo;

import java.util.ArrayList;

import com.mpqi.viewpagerdemo.adapter.MyTestFragmentAdapter;
import com.mpqi.viewpagerdemo.fragment.TestFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

public class FragmentViewPagerActivity extends FragmentActivity {
	private ViewPager viewPager;// 页卡内容
	private ArrayList<Fragment> fragmentList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.xiabiao_main);
		initViewPager();
	}

	private void initViewPager() {
		viewPager = (ViewPager) findViewById(R.id.vPager);
		fragmentList = new ArrayList<Fragment>();
		TestFragment testFragment1 = TestFragment.newInstance("我是第一页");
		TestFragment testFragment2 = TestFragment.newInstance("我是第二页");
		TestFragment testFragment3 = TestFragment.newInstance("我是第三页");

		fragmentList.add(testFragment1);
		fragmentList.add(testFragment2);
		fragmentList.add(testFragment3);

		MyTestFragmentAdapter adapter = new MyTestFragmentAdapter(
				getSupportFragmentManager(), fragmentList);
		viewPager.setAdapter(adapter);
	}
}
