package com.mpqi.testfiledemo;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	private Button saveButton, readButton , saveSDButton;
	private EditText filenameEt, filecontentEt;
	private Context context = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		saveButton = (Button) this.findViewById(R.id.saveButton);
		readButton = (Button) this.findViewById(R.id.readButton);
		saveSDButton = (Button) this.findViewById(R.id.savesdButton);
		filenameEt = (EditText) this.findViewById(R.id.filename);
		filecontentEt = (EditText) this.findViewById(R.id.filecontent);
		saveButton.setOnClickListener(listener);
		readButton.setOnClickListener(listener);
		saveSDButton.setOnClickListener(listener);
	}

	private OnClickListener listener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			if (v == saveButton) {
				String filename = filenameEt.getText().toString();
				String filecontent = filecontentEt.getText().toString();
				FileOutputStream out = null;
				try {
					out = context
							.openFileOutput(filename, Context.MODE_PRIVATE);
					out.write(filecontent.getBytes("UTF-8"));
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						out.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			} else if (v == readButton) {
				String filename = filenameEt.getText().toString(); // 获得读取的文件的名称
				FileInputStream in = null;
				ByteArrayOutputStream bout = null;
				byte[] buf = new byte[1024];
				bout = new ByteArrayOutputStream();
				int length = 0;
				try {
					in = context.openFileInput(filename); // 获得输入流
					while ((length = in.read(buf)) != -1) {
						bout.write(buf, 0, length);
					}
					byte[] content = bout.toByteArray();
					filecontentEt.setText(new String(content, "UTF-8")); // 设置文本框为读取的内容
				} catch (Exception e) {
					e.printStackTrace();
				}
				filecontentEt.invalidate(); // 刷新屏幕
				try {
					in.close();
					bout.close();
				} catch (Exception e) {
				}
			}else if (v == saveSDButton) {
				String filename = filenameEt.getText().toString(); // 获得读取的文件的名称
				String dir = Environment.getExternalStorageDirectory().toString()+"/abc";
				File dirfile = new File(dir);        
		        if (!dirfile.exists()) {
		        	dirfile.mkdir();
		        	Log.i("test", dirfile.toString());
		        }
				File f = new File(dirfile,filename);
				FileOutputStream out = null;
				try {
					out = new FileOutputStream(f,true);
					String filecontent = filecontentEt.getText().toString();
					out.write(filecontent.getBytes("UTF-8"));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			Log.i("test", Environment.getExternalStorageDirectory().toString());
		}
	};
}
