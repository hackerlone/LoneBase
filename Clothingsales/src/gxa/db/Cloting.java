package gxa.db;

import java.util.HashSet;
import java.util.Set;

/**
 * Admin entity. @author MyEclipse Persistence Tools
 */

public class Cloting implements java.io.Serializable {

	// Fields

	private String f_id;
	private Integer s_id;
	private Integer f_pid;
	private String f_name;
	private String f_brand;
	private String f_model;
	private Integer f_price;
	private String f_bid;
	private Integer f_number;
	private String f_img;
	public Cloting() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cloting(String f_id, Integer s_id, Integer f_pid, String f_name,
			String f_brand, String f_model, Integer f_price, String f_bid,
			Integer f_number, String f_img) {
		super();
		this.f_id = f_id;
		this.s_id = s_id;
		this.f_pid = f_pid;
		this.f_name = f_name;
		this.f_brand = f_brand;
		this.f_model = f_model;
		this.f_price = f_price;
		this.f_bid = f_bid;
		this.f_number = f_number;
		this.f_img = f_img;
	}
	public String getF_id() {
		return f_id;
	}
	public void setF_id(String f_id) {
		this.f_id = f_id;
	}
	public Integer getS_id() {
		return s_id;
	}
	public void setS_id(Integer s_id) {
		this.s_id = s_id;
	}
	public Integer getF_pid() {
		return f_pid;
	}
	public void setF_pid(Integer f_pid) {
		this.f_pid = f_pid;
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getF_brand() {
		return f_brand;
	}
	public void setF_brand(String f_brand) {
		this.f_brand = f_brand;
	}
	public String getF_model() {
		return f_model;
	}
	public void setF_model(String f_model) {
		this.f_model = f_model;
	}
	public Integer getF_price() {
		return f_price;
	}
	public void setF_price(Integer f_price) {
		this.f_price = f_price;
	}
	public String getF_bid() {
		return f_bid;
	}
	public void setF_bid(String f_bid) {
		this.f_bid = f_bid;
	}
	public Integer getF_number() {
		return f_number;
	}
	public void setF_number(Integer f_number) {
		this.f_number = f_number;
	}
	public String getF_img() {
		return f_img;
	}
	public void setF_img(String f_img) {
		this.f_img = f_img;
	}
	
	
	
	
	
}