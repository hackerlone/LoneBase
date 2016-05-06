package gxa.db;

import java.sql.Date;
import java.sql.Timestamp;



/*
 * 业主信息实体类
 * */
public class Yz implements java.io.Serializable {
	private String o_id; 		//业主编号
	private String o_xm; 		//业主姓名
	private String o_nl; 		//业主年龄
	private String o_jtzz; 		//业主住址
	private String o_sfzhm;		//业主身份证号
	private Timestamp o_rzsj; 		//入住时间
	private String o_lxfs; 		//业主联系方式
	private String w_id; 		//住房编号
	private String o_pwd;
	public Yz() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Yz(String o_id, String o_xm, String o_nl, String o_jtzz,
			String o_sfzhm, Timestamp o_rzsj, String o_lxfs, String w_id,
			String o_pwd) {
		super();
		this.o_id = o_id;
		this.o_xm = o_xm;
		this.o_nl = o_nl;
		this.o_jtzz = o_jtzz;
		this.o_sfzhm = o_sfzhm;
		this.o_rzsj = o_rzsj;
		this.o_lxfs = o_lxfs;
		this.w_id = w_id;
		this.o_pwd = o_pwd;
	}
	public String getO_id() {
		return o_id;
	}
	public void setO_id(String o_id) {
		this.o_id = o_id;
	}
	public String getO_xm() {
		return o_xm;
	}
	public void setO_xm(String o_xm) {
		this.o_xm = o_xm;
	}
	public String getO_nl() {
		return o_nl;
	}
	public void setO_nl(String o_nl) {
		this.o_nl = o_nl;
	}
	public String getO_jtzz() {
		return o_jtzz;
	}
	public void setO_jtzz(String o_jtzz) {
		this.o_jtzz = o_jtzz;
	}
	public String getO_sfzhm() {
		return o_sfzhm;
	}
	public void setO_sfzhm(String o_sfzhm) {
		this.o_sfzhm = o_sfzhm;
	}
	public Timestamp getO_rzsj() {
		return o_rzsj;
	}
	public void setO_rzsj(Timestamp o_rzsj) {
		this.o_rzsj = o_rzsj;
	}
	public String getO_lxfs() {
		return o_lxfs;
	}
	public void setO_lxfs(String o_lxfs) {
		this.o_lxfs = o_lxfs;
	}
	public String getW_id() {
		return w_id;
	}
	public void setW_id(String w_id) {
		this.w_id = w_id;
	}
	public String getO_pwd() {
		return o_pwd;
	}
	public void setO_pwd(String o_pwd) {
		this.o_pwd = o_pwd;
	}
	

}
