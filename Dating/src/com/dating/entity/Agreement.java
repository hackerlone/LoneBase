package com.dating.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import annotation.Bean;
import annotation.Column;
import annotation.Id;

/**
 * AbstractAgreement entity provides the base persistence definition of the
 * Agreement entity. @author MyEclipse Persistence Tools
 */
@Bean("agreement")
public class Agreement{

	// Fields
	@Id("y_id")
	private Integer YId;
	@Column("y_name")
	private String YName;
	@Column("y_ms")
	private String YMs;
	@Column("y_fs")
	private String YFs;
	@Column("y_yhsj")
	private String YYhsj;
	@Column("y_area")
	private String YArea;
	@Column("y_bz")
	private String YBz;
	// Constructors

	/** default constructor */
	public Agreement() {
	}

	/** minimal constructor */
	public Agreement(String YYhsj) {
		this.YYhsj = YYhsj;
	}

	/** full constructor */
	public Agreement(String YName, String YMs, String YFs,
			String YYhsj, String YArea, String YBz) {
		this.YName = YName;
		this.YMs = YMs;
		this.YFs = YFs;
		this.YYhsj = YYhsj;
		this.YArea = YArea;
		this.YBz = YBz;
	}

	// Property accessors

	public Integer getYId() {
		return this.YId;
	}

	public void setYId(Integer YId) {
		this.YId = YId;
	}

	public String getYName() {
		return this.YName;
	}

	public void setYName(String YName) {
		this.YName = YName;
	}

	public String getYMs() {
		return this.YMs;
	}

	public void setYMs(String YMs) {
		this.YMs = YMs;
	}

	public String getYFs() {
		return this.YFs;
	}

	public void setYFs(String YFs) {
		this.YFs = YFs;
	}

	public String getYYhsj() {
		return this.YYhsj;
	}

	public void setYYhsj(String YYhsj) {
		this.YYhsj = YYhsj;
	}

	public String getYArea() {
		return this.YArea;
	}

	public void setYArea(String YArea) {
		this.YArea = YArea;
	}

	public String getYBz() {
		return this.YBz;
	}

	public void setYBz(String YBz) {
		this.YBz = YBz;
	}


}