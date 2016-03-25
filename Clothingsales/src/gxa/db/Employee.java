package gxa.db;

import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class Employee implements java.io.Serializable {

	// Fields

	private Integer e_id;
	private Integer d_id;
	private String e_name;
	private String e_pwd;
	private Integer e_power;
	private String e_sex;
	private String e_tel;
	private String e_diploma;
	private String e_idcard;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(Integer e_id, Integer d_id, String e_name, String e_pwd,
			Integer e_power, String e_sex, String e_tel, String e_diploma,
			String e_idcard) {
		super();
		this.e_id = e_id;
		this.d_id = d_id;
		this.e_name = e_name;
		this.e_pwd = e_pwd;
		this.e_power = e_power;
		this.e_sex = e_sex;
		this.e_tel = e_tel;
		this.e_diploma = e_diploma;
		this.e_idcard = e_idcard;
	}
	public Integer getE_id() {
		return e_id;
	}
	public void setE_id(Integer e_id) {
		this.e_id = e_id;
	}
	public Integer getD_id() {
		return d_id;
	}
	public void setD_id(Integer d_id) {
		this.d_id = d_id;
	}
	public String getE_name() {
		return e_name;
	}
	public void setE_name(String e_name) {
		this.e_name = e_name;
	}
	public String getE_pwd() {
		return e_pwd;
	}
	public void setE_pwd(String e_pwd) {
		this.e_pwd = e_pwd;
	}
	public Integer getE_power() {
		return e_power;
	}
	public void setE_power(Integer e_power) {
		this.e_power = e_power;
	}
	public String getE_sex() {
		return e_sex;
	}
	public void setE_sex(String e_sex) {
		this.e_sex = e_sex;
	}
	public String getE_tel() {
		return e_tel;
	}
	public void setE_tel(String e_tel) {
		this.e_tel = e_tel;
	}
	public String getE_diploma() {
		return e_diploma;
	}
	public void setE_diploma(String e_diploma) {
		this.e_diploma = e_diploma;
	}
	public String getE_idcard() {
		return e_idcard;
	}
	public void setE_idcard(String e_idcard) {
		this.e_idcard = e_idcard;
	}
	
	
}