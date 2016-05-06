package gxa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Cartype entity. @author MyEclipse Persistence Tools
 */

public class CarType implements java.io.Serializable {

	// Fields

	private Integer ctId;
	//private Admin admin;
	private String ctName;
	private Integer ctPid;
	
	//private Set cars = new HashSet(0);

	// Constructors

	/** default constructor */
	public CarType() {
	}

	/** full constructor */
	public CarType(String ctName, Integer ctPid) {
		
		this.ctName = ctName;
		this.ctPid = ctPid;
		
	}

	// Property accessors

	public Integer getCtId() {
		return this.ctId;
	}

	public void setCtId(Integer ctId) {
		this.ctId = ctId;
	}


	public String getCtName() {
		return this.ctName;
	}

	public void setCtName(String ctName) {
		this.ctName = ctName;
	}

	public Integer getCtPid() {
		return this.ctPid;
	}

	public void setCtPid(Integer ctPid) {
		this.ctPid = ctPid;
	}


}