package com.mpqi.fragmentdemo.fragment;

import com.mpqi.fragmentdemo.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

public class TitleFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_title, null);
		ImageButton imButton = (ImageButton) view
				.findViewById(R.id.id_title_left_btn);
		imButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(getActivity(),
						"I'm a ImageButton in TitleFragment !",
						Toast.LENGTH_SHORT).show();
			}
		});
		return view;
	}
}
