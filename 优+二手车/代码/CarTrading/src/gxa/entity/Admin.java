package gxa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Admin entity. @author MyEclipse Persistence Tools
 */

public class Admin implements java.io.Serializable {

	// Fields

	private Integer AId;
	private String AName;
	private String APwd;
	
	// Constructors

	/** default constructor */
	public Admin() {
	}

	/** minimal constructor */
	public Admin(Integer AId) {
		this.AId = AId;
	}

	/** full constructor */
	public Admin(Integer AId, String AName, String APwd, Set users,
			Set cartypes, Set cars) {
		this.AId = AId;
		this.AName = AName;
		this.APwd = APwd;
		
	}

	// Property accessors

	public Integer getAId() {
		return this.AId;
	}

	public void setAId(Integer AId) {
		this.AId = AId;
	}

	public String getAName() {
		return this.AName;
	}

	public void setAName(String AName) {
		this.AName = AName;
	}

	public String getAPwd() {
		return this.APwd;
	}

	public void setAPwd(String APwd) {
		this.APwd = APwd;
	}

	
}