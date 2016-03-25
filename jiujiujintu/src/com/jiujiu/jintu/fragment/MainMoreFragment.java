package com.jiujiu.jintu.fragment;

import com.jiujiu.jintu.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Toast;

public class MainMoreFragment extends Fragment {
	private View clearCacheView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_more, null);
		clearCacheView = view.findViewById(R.id.more_clear_cache);
		clearCacheView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				ImageLoader.getInstance().clearDiscCache();
				Toast.makeText(getActivity(), R.string.picture_cache_cleared,
						Toast.LENGTH_SHORT).show();
			}
		});
		return view;
	}
}
