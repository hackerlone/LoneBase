package com.Campus.entity;

import java.util.HashSet;
import java.util.Set;

import com.Campus.dao.VitaDao;

/**
 * Vita entity. @author MyEclipse Persistence Tools
 */

public class Vita implements java.io.Serializable {

	// Fields

	private Integer JId;
	private Student student;
	private String JFace;
	private String JDizhi;
	private String JByxx;
	private String JZy;
	private String JGzjl;
	private String JXl;
	private String JJianjie;
	private Set models = new HashSet(0);
	private Set jzs = new HashSet(0);
	// Constructors

	/** default constructor */
	public Vita() {
	}

	/** minimal constructor */
	public Vita(Integer JId) {
		this.JId = JId;
	}

	/** full constructor */
	public Vita(Integer JId, Student student, String JFace, String JDizhi,
			String JByxx, String JZy, String JGzjl, String JXl,
			String JJianjie, Set jzs, Set models) {
		this.JId = JId;
		this.student = student;
		this.JFace = JFace;
		this.JDizhi = JDizhi;
		this.JByxx = JByxx;
		this.JZy = JZy;
		this.JGzjl = JGzjl;
		this.JXl = JXl;
		this.JJianjie = JJianjie;
		this.jzs = jzs;
		this.models = models;
	}

	// Property accessors

	public Integer getJId() {
		return this.JId;
	}

	public void setJId(Integer JId) {
		this.JId = JId;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getJFace() {
		return this.JFace;
	}

	public void setJFace(String JFace) {
		this.JFace = JFace;
	}

	public String getJDizhi() {
		return this.JDizhi;
	}

	public void setJDizhi(String JDizhi) {
		this.JDizhi = JDizhi;
	}

	public String getJByxx() {
		return this.JByxx;
	}

	public void setJByxx(String JByxx) {
		this.JByxx = JByxx;
	}

	public String getJZy() {
		return this.JZy;
	}

	public void setJZy(String JZy) {
		this.JZy = JZy;
	}

	public String getJGzjl() {
		return this.JGzjl;
	}

	public void setJGzjl(String JGzjl) {
		this.JGzjl = JGzjl;
	}

	public String getJXl() {
		return this.JXl;
	}

	public void setJXl(String JXl) {
		this.JXl = JXl;
	}

	public String getJJianjie() {
		return this.JJianjie;
	}

	public void setJJianjie(String JJianjie) {
		this.JJianjie = JJianjie;
	}

	public Set getJzs() {
		return this.jzs;
	}

	public void setJzs(Set jzs) {
		this.jzs = jzs;
	}

	public Set getModels() {
		return this.models;
	}

	public void setModels(Set models) {
		this.models = models;
	}

	

}