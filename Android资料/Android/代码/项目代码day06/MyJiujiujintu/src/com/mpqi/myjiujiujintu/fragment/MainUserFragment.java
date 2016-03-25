package com.mpqi.myjiujiujintu.fragment;

import com.avos.avoscloud.AVUser;
import com.mpqi.myjiujiujintu.LoginActivity;
import com.mpqi.myjiujiujintu.R;
import com.mpqi.myjiujiujintu.RegisterActivity;
import com.mpqi.myjiujiujintu.util.JJJCONFIG;
import com.mpqi.myjiujiujintu.widget.MaskImage;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainUserFragment extends Fragment {

	private Button lLoginBtn, lRegisterBtn, lLogoutBtn;
	private View user_moreView;
	private MaskImage lheadMaskImage;
	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_user, container, false);
		initViews(view);
		return view;

	}

	private void initViews(View view) {
		lLoginBtn = (Button) view.findViewById(R.id.user_btn_login);
		lRegisterBtn = (Button) view.findViewById(R.id.user_btn_regist);
		lLogoutBtn = (Button) view.findViewById(R.id.user_btn_logout);
		lheadMaskImage = (MaskImage) view.findViewById(R.id.user_head);
		// user_moreView = view.findViewById(R.id.user_more);
		BtnOnClickListener btnOnClickListener = new BtnOnClickListener();
		lLoginBtn.setOnClickListener(btnOnClickListener);
		lRegisterBtn.setOnClickListener(btnOnClickListener);
		lLogoutBtn.setOnClickListener(btnOnClickListener);
		// user_moreView.setOnClickListener(btnOnClickListener);
		
		isLogin();
	}

	private class BtnOnClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			int id = v.getId();
			switch (id) {
			case R.id.user_btn_login:
				Intent intent1 = new Intent(getActivity(), LoginActivity.class);
				getActivity().startActivityForResult(intent1, JJJCONFIG.LOGIN_RESULT);
				break;
			case R.id.user_btn_regist:
				Intent intent = new Intent(getActivity(),
						RegisterActivity.class);
				getActivity().startActivityForResult(intent, JJJCONFIG.REGIST_RESULT);
				break;
			case R.id.user_btn_logout:
				AVUser.logOut();
				isLogin();
				break;
			// case R.id.user_more:
			// startActivity(new Intent(getActivity(),
			// MoreConfigActivity.class));
			// break;
			}

		}

	}

	public void isLogin() {
		AVUser avUser = AVUser.getCurrentUser();
		if (avUser == null) {// Ã»ÓÐµÇÂ¼
			lLogoutBtn.setVisibility(View.GONE);
			lheadMaskImage.setVisibility(View.GONE);
			lLoginBtn.setVisibility(View.VISIBLE);
			lRegisterBtn.setVisibility(View.VISIBLE);
		} else {// µÇÂ¼ÁË
			lLogoutBtn.setVisibility(View.VISIBLE);
			lheadMaskImage.setVisibility(View.VISIBLE);
			lLoginBtn.setVisibility(View.GONE);
			lRegisterBtn.setVisibility(View.GONE);
		}
	}


}
