package com.jiujiu.jintu;

import com.jiujiu.jintu.R;
import com.jiujiu.jintu.R.id;
import com.jiujiu.jintu.R.layout;
import com.jiujiu.jintu.R.string;
import com.nostra13.universalimageloader.core.ImageLoader;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/***
 * 更多 系统配置
 * 
 * @author mpqi-i7
 *
 */
public class MoreConfigActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_more);
	}

	public void btnOnClick(View view) {
		int id = view.getId();
		switch (id) {
		case R.id.more_close:
			finish();
			break;
		case R.id.more_clear_cache:
			ImageLoader.getInstance().clearDiscCache();
			Toast.makeText(this, R.string.picture_cache_cleared,
					Toast.LENGTH_SHORT).show();
			break;
		}
	}

	/**
	 * 返回键响应
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			finish();
		}
		return false;
	}

}
