package gxa.db;

import java.util.HashSet;
import java.util.Set;

/**
 * Admin entity. @author MyEclipse Persistence Tools
 */

public class Customer implements java.io.Serializable {

	// Fields

	private Integer k_id;
	private Integer k_integ;
	private String k_name;
	private String k_pwd;
	private Integer k_number;
	private String k_tel;
	private Integer k_return;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(Integer k_id, Integer k_integ, String k_name, String k_pwd,
			Integer k_number, String k_tel, Integer k_return) {
		super();
		this.k_id = k_id;
		this.k_integ = k_integ;
		this.k_name = k_name;
		this.k_pwd = k_pwd;
		this.k_number = k_number;
		this.k_tel = k_tel;
		this.k_return = k_return;
	}
	public Integer getK_id() {
		return k_id;
	}
	public void setK_id(Integer k_id) {
		this.k_id = k_id;
	}
	public Integer getK_integ() {
		return k_integ;
	}
	public void setK_integ(Integer k_integ) {
		this.k_integ = k_integ;
	}
	public String getK_name() {
		return k_name;
	}
	public void setK_name(String k_name) {
		this.k_name = k_name;
	}
	public String getK_pwd() {
		return k_pwd;
	}
	public void setK_pwd(String k_pwd) {
		this.k_pwd = k_pwd;
	}
	public Integer getK_number() {
		return k_number;
	}
	public void setK_number(Integer k_number) {
		this.k_number = k_number;
	}
	public String getK_tel() {
		return k_tel;
	}
	public void setK_tel(String k_tel) {
		this.k_tel = k_tel;
	}
	public Integer getK_return() {
		return k_return;
	}
	public void setK_return(Integer k_return) {
		this.k_return = k_return;
	}
	
	
	
}