package com.Campus.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Enterprise entity. @author MyEclipse Persistence Tools
 */

public class Enterprise implements java.io.Serializable {

	// Fields

	private Integer QId;
	private String QName;
	private String QPwd;
	private Timestamp QDate;
	private String QXingzhi;
	private String QGuimo;
	private String QArea;
	private String QYoubian;
	private String QEmail;
	private String QPhone;
	private String QMiaoshu;
	private List<Job> jobs;

	// Constructors

	/** default constructor */
	public Enterprise() {
	}

	/** minimal constructor */
	public Enterprise(Integer QId, Timestamp QDate) {
		this.QId = QId;
		this.QDate = QDate;
	}

	/** full constructor */
	public Enterprise(Integer QId, String QName, String QPwd, Timestamp QDate,
			String QXingzhi, String QGuimo, String QArea, String QYoubian,
			String QEmail, String QPhone, String QMiaoshu, Set jobs) {
		this.QId = QId;
		this.QName = QName;
		this.QPwd = QPwd;
		this.QDate = QDate;
		this.QXingzhi = QXingzhi;
		this.QGuimo = QGuimo;
		this.QArea = QArea;
		this.QYoubian = QYoubian;
		this.QEmail = QEmail;
		this.QPhone = QPhone;
		this.QMiaoshu = QMiaoshu;
	}

	// Property accessors

	public Integer getQId() {
		return this.QId;
	}

	

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public void setQId(Integer QId) {
		this.QId = QId;
	}

	public String getQName() {
		return this.QName;
	}

	public void setQName(String QName) {
		this.QName = QName;
	}

	public String getQPwd() {
		return this.QPwd;
	}

	public void setQPwd(String QPwd) {
		this.QPwd = QPwd;
	}

	public Timestamp getQDate() {
		return this.QDate;
	}

	public void setQDate(Timestamp QDate) {
		this.QDate = QDate;
	}

	public String getQXingzhi() {
		return this.QXingzhi;
	}

	public void setQXingzhi(String QXingzhi) {
		this.QXingzhi = QXingzhi;
	}

	public String getQGuimo() {
		return this.QGuimo;
	}

	public void setQGuimo(String QGuimo) {
		this.QGuimo = QGuimo;
	}

	public String getQArea() {
		return this.QArea;
	}

	public void setQArea(String QArea) {
		this.QArea = QArea;
	}

	public String getQYoubian() {
		return this.QYoubian;
	}

	public void setQYoubian(String string) {
		this.QYoubian = string;
	}

	public String getQEmail() {
		return this.QEmail;
	}

	public void setQEmail(String QEmail) {
		this.QEmail = QEmail;
	}

	public String getQPhone() {
		return this.QPhone;
	}

	public void setQPhone(String QPhone) {
		this.QPhone = QPhone;
	}

	public String getQMiaoshu() {
		return this.QMiaoshu;
	}

	public void setQMiaoshu(String QMiaoshu) {
		this.QMiaoshu = QMiaoshu;
	}

}