package gxa.db;

import java.sql.Date;
import java.sql.Timestamp;



/*
 * 业主信息实体类
 * */
public class Wgxx implements java.io.Serializable {
	private String w_id; 		
	private String w_xm; 		
	private String w_nl; 		
	private String w_sg; 		
	private String w_jtzz;		
	private String w_jg; 		
	private String w_sfzhm; 		
	private String w_lxfs; 	
	private Timestamp  w_time;
	private String zy_id;
	private String w_pwd;
	public Wgxx() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Wgxx(String w_id, String w_xm, String w_nl, String w_sg,
			String w_jtzz, String w_jg, String w_sfzhm, String w_lxfs,
			Timestamp w_time, String zy_id, String w_pwd) {
		super();
		this.w_id = w_id;
		this.w_xm = w_xm;
		this.w_nl = w_nl;
		this.w_sg = w_sg;
		this.w_jtzz = w_jtzz;
		this.w_jg = w_jg;
		this.w_sfzhm = w_sfzhm;
		this.w_lxfs = w_lxfs;
		this.w_time = w_time;
		this.zy_id = zy_id;
		this.w_pwd = w_pwd;
	}
	public String getW_id() {
		return w_id;
	}
	public void setW_id(String w_id) {
		this.w_id = w_id;
	}
	public String getW_xm() {
		return w_xm;
	}
	public void setW_xm(String w_xm) {
		this.w_xm = w_xm;
	}
	public String getW_nl() {
		return w_nl;
	}
	public void setW_nl(String w_nl) {
		this.w_nl = w_nl;
	}
	public String getW_sg() {
		return w_sg;
	}
	public void setW_sg(String w_sg) {
		this.w_sg = w_sg;
	}
	public String getW_jtzz() {
		return w_jtzz;
	}
	public void setW_jtzz(String w_jtzz) {
		this.w_jtzz = w_jtzz;
	}
	public String getW_jg() {
		return w_jg;
	}
	public void setW_jg(String w_jg) {
		this.w_jg = w_jg;
	}
	public String getW_sfzhm() {
		return w_sfzhm;
	}
	public void setW_sfzhm(String w_sfzhm) {
		this.w_sfzhm = w_sfzhm;
	}
	public String getW_lxfs() {
		return w_lxfs;
	}
	public void setW_lxfs(String w_lxfs) {
		this.w_lxfs = w_lxfs;
	}
	public Timestamp getW_time() {
		return w_time;
	}
	public void setW_time(Timestamp w_time) {
		this.w_time = w_time;
	}
	public String getZy_id() {
		return zy_id;
	}
	public void setZy_id(String zy_id) {
		this.zy_id = zy_id;
	}
	public String getW_pwd() {
		return w_pwd;
	}
	public void setW_pwd(String w_pwd) {
		this.w_pwd = w_pwd;
	}
	
	}
	