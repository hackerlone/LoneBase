package com.mpqi.leanclouddemo.bean;

import android.os.Parcel;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

@AVClassName("Post")
// 注解，用于 AvObject("Post")
public class Post extends AVObject {
	private final String pubUser = "pubUser";
	private final String content = "content";
	private final String pubUserCertificate = "pubUserCertificate";

	public Post() {
		super();
	}

	public Post(Parcel in) {
		super(in);
	}

	// 此处为我们的默认实现，当然你也可以自行实现
	public static final Creator CREATOR = AVObjectCreator.instance;

	public String getPubUser() {
		return getString(pubUser);
	}

	public void setPubUser(String pubUser) {
		put(this.pubUser, pubUser);
	}

	public String getContent() {
		return getString(content);
	}

	public void setContent(String content) {
		put(this.content, content);
	}

	public int getPubUserCertificate() {
		return getInt(pubUserCertificate);
	}

	public void setPubUserCertificate(int pubUserCertificate) {
		put(this.pubUserCertificate, pubUserCertificate);
	}

}
