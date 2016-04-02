package com.dating.entity;

import java.sql.Timestamp;

import annotation.Bean;
import annotation.Column;
import annotation.Id;

/**
 * AbstractYu entity provides the base persistence definition of the Yu entity. @author
 * MyEclipse Persistence Tools
 */
@Bean("yu")
public class Yu{

	// Fields
	@Column("yu_id")
	private String YUId;
	@Column("y_id")
	private String YId;
	@Column("u_id")
	private String UId;
	@Column("yu_data")
	private String yuData;
	@Column("yu_enddata")
	private String yuEnddata;
	public Yu(String yUId, String yId, String uId, String yuData,
			String yuEnddata) {
		super();
		YUId = yUId;
		YId = yId;
		UId = uId;
		this.yuData = yuData;
		this.yuEnddata = yuEnddata;
	}
	public Yu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getYUId() {
		return YUId;
	}
	public void setYUId(String yUId) {
		YUId = yUId;
	}
	public String getYId() {
		return YId;
	}
	public void setYId(String string) {
		YId = string;
	}
	public String getUId() {
		return UId;
	}
	public void setUId(String uId) {
		UId = uId;
	}
	public String getYuData() {
		return yuData;
	}
	public void setYuData(String yuData) {
		this.yuData = yuData;
	}
	public String getYuEnddata() {
		return yuEnddata;
	}
	public void setYuEnddata(String yuEnddata) {
		this.yuEnddata = yuEnddata;
	}
	
}