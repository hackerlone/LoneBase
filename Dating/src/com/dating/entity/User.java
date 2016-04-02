package com.dating.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import annotation.Bean;
import annotation.Column;
import annotation.Id;

/**
 * AbstractUser entity provides the base persistence definition of the User
 * entity. @author MyEclipse Persistence Tools
 */
@Bean("user")
public  class User{

	// Fields
	@Id("u_id")
	private Integer UId;
	@Column("u_name")
	private String UName;
	@Column("u_age")
	private String UAge;
	@Column("u_sex")
	private Integer USex;
	@Column("u_email")
	private String UEmail;
	@Column("u_pwd")
	private String UPwd;
	@Column("u_phone")
	private String UPhone;
	@Column("u_area")
	private String UArea;
	@Column("u_head")
	private String UHead;
	@Column("u_signature")
	private String USignature;
	// Constructors

	/** default constructor */
	public User() {
	}
	public User(Integer uId, String uName, String uAge,
			Integer uSex, String uEmail, String uPwd, String uPhone,
			String uArea, String uHead, String uSignature) {
		super();
		UId = uId;
		UName = uName;
		UAge = uAge;
		USex = uSex;
		UEmail = uEmail;
		UPwd = uPwd;
		UPhone = uPhone;
		UArea = uArea;
		UHead = uHead;
		USignature = uSignature;
	}
	public Integer getUId() {
		return UId;
	}
	public void setUId(Integer uId) {
		UId = uId;
	}

	public String getUName() {
		return UName;
	}
	public void setUName(String uName) {
		UName = uName;
	}
	public String getUAge() {
		return UAge;
	}
	public void setUAge(String uAge) {
		UAge = uAge;
	}
	public Integer getUSex() {
		return USex;
	}
	public void setUSex(Integer uSex) {
		USex = uSex;
	}
	public String getUEmail() {
		return UEmail;
	}
	public void setUEmail(String uEmail) {
		UEmail = uEmail;
	}
	public String getUPwd() {
		return UPwd;
	}
	public void setUPwd(String uPwd) {
		UPwd = uPwd;
	}
	public String getUPhone() {
		return UPhone;
	}
	public void setUPhone(String uPhone) {
		UPhone = uPhone;
	}
	public String getUArea() {
		return UArea;
	}
	public void setUArea(String uArea) {
		UArea = uArea;
	}
	public String getUHead() {
		return UHead;
	}
	public void setUHead(String uHead) {
		UHead = uHead;
	}
	public String getUSignature() {
		return USignature;
	}
	public void setUSignature(String uSignature) {
		USignature = uSignature;
	}

	
}