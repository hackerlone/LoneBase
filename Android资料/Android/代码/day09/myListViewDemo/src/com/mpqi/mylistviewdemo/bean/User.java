package com.mpqi.mylistviewdemo.bean;

public class User {
	private long userid;
	private int headImage;
	private String name;
	private String sex;

	public User(long userid, int headImage, String name, String sex) {
		super();
		this.userid = userid;
		this.headImage = headImage;
		this.name = name;
		this.sex = sex;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public int getHeadImage() {
		return headImage;
	}

	public void setHeadImage(int headImage) {
		this.headImage = headImage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
