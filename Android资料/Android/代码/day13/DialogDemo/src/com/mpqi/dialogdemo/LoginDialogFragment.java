package com.mpqi.dialogdemo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class LoginDialogFragment extends DialogFragment {

	public interface LoginInputListener {
		public void onLoginInputComplete(String username, String password);
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
		LayoutInflater layoutInflater = getActivity().getLayoutInflater();
		final View view = layoutInflater.inflate(
				R.layout.fragment_dialog_login, null);
		dialog.setView(view)
				.setPositiveButton("Sign in", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						LoginInputListener loginactivity = (LoginInputListener) getActivity();

						EditText usernameEditText = (EditText) view
								.findViewById(R.id.id_txt_username);
						EditText pwdEditText = (EditText) view
								.findViewById(R.id.id_txt_password);

						loginactivity.onLoginInputComplete(usernameEditText
								.getText().toString(), pwdEditText.getText()
								.toString());
					}
				}).setNegativeButton("Cancel", null);
		return dialog.create();
	}
}
