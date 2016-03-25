package com.Campus.entity;

import java.util.Date;

/**
 * Jz entity. @author MyEclipse Persistence Tools
 */

public class Jz implements java.io.Serializable {

	// Fields

	private Integer jzId;
	private Vita vita;
	private Job job;
	private Date TDate;
	private Date KDate;

	// Constructors

	/** default constructor */
	public Jz() {
	}

	/** minimal constructor */
	public Jz(Integer jzId, Vita vita, Job job) {
		this.jzId = jzId;
		this.vita = vita;
		this.job = job;
	}

	/** full constructor */
	public Jz(Integer jzId, Vita vita, Job job, Date TDate, Date KDate) {
		this.jzId = jzId;
		this.vita = vita;
		this.job = job;
		this.TDate = TDate;
		this.KDate = KDate;
	}

	// Property accessors

	public Integer getJzId() {
		return this.jzId;
	}

	public void setJzId(Integer jzId) {
		this.jzId = jzId;
	}

	public Vita getVita() {
		return this.vita;
	}

	public void setVita(Vita vita) {
		this.vita = vita;
	}

	public Job getJob() {
		return this.job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Date getTDate() {
		return this.TDate;
	}

	public void setTDate(Date TDate) {
		this.TDate = TDate;
	}

	public Date getKDate() {
		return this.KDate;
	}

	public void setKDate(Date KDate) {
		this.KDate = KDate;
	}

}