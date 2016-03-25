package gxa.db;

import java.util.HashSet;
import java.util.Set;

/**
 * depot entity. @author MyEclipse Persistence Tools
 */

public class Integral implements java.io.Serializable {

	// Fields

	private Integer i_id;
	private String i_gname;
	private Integer i_fenzhi;
	public Integral() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integral(Integer i_id, String i_gname, Integer i_fenzhi) {
		super();
		this.i_id = i_id;
		this.i_gname = i_gname;
		this.i_fenzhi = i_fenzhi;
	}
	public Integer getI_id() {
		return i_id;
	}
	public void setI_id(Integer i_id) {
		this.i_id = i_id;
	}
	public String getI_gname() {
		return i_gname;
	}
	public void setI_gname(String i_gname) {
		this.i_gname = i_gname;
	}
	public Integer getI_fenzhi() {
		return i_fenzhi;
	}
	public void setI_fenzhi(Integer i_fenzhi) {
		this.i_fenzhi = i_fenzhi;
	}
	
	
	
	
}