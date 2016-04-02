package com.dating.entity;

import java.sql.Timestamp;

import annotation.Bean;
import annotation.Column;
import annotation.Id;

/**
 * AbstractBooks entity provides the base persistence definition of the Books
 * entity. @author MyEclipse Persistence Tools
 */
@Bean("books")
public class Books{

	// Fields
	@Id("uu_id")
	private Integer uuId;
	@Column("t_id")
	private Integer TId;
	@Column("u_id")
	private Integer UId;
	@Column("tu_data")
	private String tuData;
	@Column("uu_record")
	private String uuRecord;

	// Constructors

	/** default constructor */
	public Books() {
	}

	/** minimal constructor */
	public Books(Integer TId, Integer UId, String tuData) {
		this.TId = TId;
		this.UId = UId;
		this.tuData = tuData;
	}

	/** full constructor */
	public Books(Integer TId, Integer UId, String tuData,
			String uuRecord) {
		this.TId = TId;
		this.UId = UId;
		this.tuData = tuData;
		this.uuRecord = uuRecord;
	}

	// Property accessors

	public Integer getUuId() {
		return this.uuId;
	}

	public void setUuId(Integer uuId) {
		this.uuId = uuId;
	}

	public Integer getTId() {
		return this.TId;
	}

	public void setTId(Integer TId) {
		this.TId = TId;
	}

	public Integer getUId() {
		return this.UId;
	}

	public void setUId(Integer UId) {
		this.UId = UId;
	}

	public String getTuData() {
		return this.tuData;
	}

	public void setTuData(String tuData) {
		this.tuData = tuData;
	}

	public String getUuRecord() {
		return this.uuRecord;
	}

	public void setUuRecord(String uuRecord) {
		this.uuRecord = uuRecord;
	}

}