package com.jiujiu.jintu.fragment;

import com.jiujiu.jintu.LoginActivity;
import com.jiujiu.jintu.MoreConfigActivity;
import com.jiujiu.jintu.R;
import com.jiujiu.jintu.RegisterActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class MainUserFragment extends Fragment {
	private Button lLoginBtn, lRegisterBtn;
	private View user_moreView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_user, container, false);
		initViews(view);
		return view;

	}

	private void initViews(View view) {
		lLoginBtn = (Button) view.findViewById(R.id.user_btn_login);
		lRegisterBtn = (Button) view.findViewById(R.id.user_btn_register);
		user_moreView = view.findViewById(R.id.user_more);
		BtnOnClickListener btnOnClickListener = new BtnOnClickListener();
		lLoginBtn.setOnClickListener(btnOnClickListener);
		lRegisterBtn.setOnClickListener(btnOnClickListener);
		user_moreView.setOnClickListener(btnOnClickListener);
	}

	private class BtnOnClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			int id = v.getId();
			switch (id) {
			case R.id.user_btn_login:
				startActivity(new Intent(getActivity(), LoginActivity.class));
				break;
			case R.id.user_btn_register:
				startActivity(new Intent(getActivity(), RegisterActivity.class));
				break;
			case R.id.user_more:
				startActivity(new Intent(getActivity(),
						MoreConfigActivity.class));
				break;
			}

		}

	}

}
