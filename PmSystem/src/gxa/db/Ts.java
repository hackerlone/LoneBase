package gxa.db;

import java.sql.Date;
/*
 * 资源信息实体类
 * */
public class Ts implements java.io.Serializable {
	private Integer ly_id;
	private String o_id; 		// 业主id
	private String w_id; 		//管理id
	private String t_sy; 		//投诉原因
	public Ts() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ts(Integer ly_id, String o_id, String w_id, String t_sy) {
		super();
		this.ly_id = ly_id;
		this.o_id = o_id;
		this.w_id = w_id;
		this.t_sy = t_sy;
	}
	public Integer getLy_id() {
		return ly_id;
	}
	public void setLy_id(Integer ly_id) {
		this.ly_id = ly_id;
	}
	public String getO_id() {
		return o_id;
	}
	public void setO_id(String o_id) {
		this.o_id = o_id;
	}
	public String getW_id() {
		return w_id;
	}
	public void setW_id(String w_id) {
		this.w_id = w_id;
	}
	public String getT_sy() {
		return t_sy;
	}
	public void setT_sy(String t_sy) {
		this.t_sy = t_sy;
	}
	
	
}
