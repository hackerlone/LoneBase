package com.mpqi.myjiujiujintu.fragment;

import com.mpqi.myjiujiujintu.R;
import com.mpqi.myjiujiujintu.fragment.SearchCityFragment.SetChoosedNameListner;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainTypeFragment extends Fragment implements iTopTitleListener {
	private ImageView lcallImageView;
	private TextView llocationTextView;
	private EditText llocationEditText;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_type, null);
		initView(view);
		return view;
	}

	private void initView(View view) {
		llocationEditText = (EditText) view.findViewById(R.id.top_location_edt);
		llocationTextView = (TextView) view
				.findViewById(R.id.top_location_text);
		lcallImageView = (ImageView) view.findViewById(R.id.top_call);

		llocationTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0,
				R.drawable.icon_city_triangle_green, 0);// ª≠‘⁄”“±ﬂ
		llocationTextView.setTextColor(getResources().getColor(
				R.color.green_33bc60));
		lcallImageView.setImageResource(R.drawable.mainpage_call_bg);
		llocationEditText.setBackgroundResource(R.drawable.bg_gray_radius3);
		llocationTextView.setText(((SetChoosedNameListner)getActivity()).getChoosedName());	
	}

	@Override
	public void setLocal(String local) {
		llocationTextView.setText(local);

	}
}
