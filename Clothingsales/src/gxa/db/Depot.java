package gxa.db;

import java.util.HashSet;
import java.util.Set;

/**
 * depot entity. @author MyEclipse Persistence Tools
 */

public class Depot implements java.io.Serializable {

	// Fields

	private Integer d_id;
	private String d_name;
	private Integer e_id;
	private String e_name;
	private String d_site;
	public Depot() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Depot(Integer d_id, String d_name, Integer e_id, String e_name,
			String d_site) {
		super();
		this.d_id = d_id;
		this.d_name = d_name;
		this.e_id = e_id;
		this.e_name = e_name;
		this.d_site = d_site;
	}
	public Integer getD_id() {
		return d_id;
	}
	public void setD_id(Integer d_id) {
		this.d_id = d_id;
	}
	public String getD_name() {
		return d_name;
	}
	public void setD_name(String d_name) {
		this.d_name = d_name;
	}
	public Integer getE_id() {
		return e_id;
	}
	public void setE_id(Integer e_id) {
		this.e_id = e_id;
	}
	public String getE_name() {
		return e_name;
	}
	public void setE_name(String e_name) {
		this.e_name = e_name;
	}
	public String getD_site() {
		return d_site;
	}
	public void setD_site(String d_site) {
		this.d_site = d_site;
	}
	
	
}