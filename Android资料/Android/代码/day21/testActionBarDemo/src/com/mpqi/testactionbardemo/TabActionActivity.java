 package com.mpqi.testactionbardemo;

import com.mpqi.testactionbardemo.fragement.Fragment1;
import com.mpqi.testactionbardemo.fragement.Fragment2;
import com.mpqi.testactionbardemo.fragement.Fragment3;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class TabActionActivity extends Activity implements
		ActionBar.TabListener {
	private ActionBar actionBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabaction_main);
		actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);// 导航模式必须设为NAVIGATION_MODE_Tabs

		// For each of the sections in the app, add a tab to the action bar.

		actionBar.addTab(actionBar.newTab().setText(R.string.title_section1)
				.setTabListener(this));
		actionBar.addTab(actionBar.newTab().setText(R.string.title_section2)
				.setTabListener(this));
		actionBar.addTab(actionBar.newTab().setText(R.string.title_section3)
				.setTabListener(this));

	}

	@Override
	public void onTabSelected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
		// When the given tab isselected, show the tabcontents in the
		// //container view.
		Fragment fragment3 = null;
		Fragment fragment1 = null;
		Fragment fragment2 = null;
		switch (tab.getPosition()) {
		case 0:
			if (fragment1 == null) {
				fragment1 = new Fragment1();
			}
			getFragmentManager().beginTransaction()
					.replace(R.id.container, fragment1).commit();
			break;
		case 1:
			if (fragment2 == null) {
				fragment2 = new Fragment2();
			}
			getFragmentManager().beginTransaction()
					.replace(R.id.container, fragment2).commit();
			break;
		case 2:
			if (fragment3 == null) {
				fragment3 = new Fragment3();
			}
			getFragmentManager().beginTransaction()
					.replace(R.id.container, fragment3).commit();
			break;

		default:
			break;
		}

	}

	@Override
	public void onTabUnselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	@Override
	public void onTabReselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

}