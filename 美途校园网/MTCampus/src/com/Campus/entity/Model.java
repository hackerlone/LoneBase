package com.Campus.entity;

/**
 * Model entity. @author MyEclipse Persistence Tools
 */

public class Model implements java.io.Serializable {

	// Fields

	private Integer MId;
	private Vita vita;
	private Admin admin;
	private String MUrl;

	// Constructors

	/** default constructor */
	public Model() {
	}

	/** minimal constructor */
	public Model(Integer MId) {
		this.MId = MId;
	}

	/** full constructor */
	public Model(Integer MId, Vita vita, Admin admin, String MUrl) {
		this.MId = MId;
		this.vita = vita;
		this.admin = admin;
		this.MUrl = MUrl;
	}

	// Property accessors

	public Integer getMId() {
		return this.MId;
	}

	public void setMId(Integer MId) {
		this.MId = MId;
	}

	public Vita getVita() {
		return this.vita;
	}

	public void setVita(Vita vita) {
		this.vita = vita;
	}

	public Admin getAdmin() {
		return this.admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String getMUrl() {
		return this.MUrl;
	}

	public void setMUrl(String MUrl) {
		this.MUrl = MUrl;
	}

}