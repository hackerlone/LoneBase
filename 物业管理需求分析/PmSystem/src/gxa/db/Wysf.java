package gxa.db;

import java.sql.Timestamp;

public class Wysf {
	private String sh_id; //编号
	private String sh_zl;	//
	private String sh_bzjg; //标价
	private Timestamp sh_time; //收费时间
	private String sh_leibie;  //收取类别
	private String o_id;
	public Wysf() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Wysf(String sh_id, String sh_zl, String sh_bzjg, Timestamp sh_time,
			String sh_leibie, String o_id) {
		super();
		this.sh_id = sh_id;
		this.sh_zl = sh_zl;
		this.sh_bzjg = sh_bzjg;
		this.sh_time = sh_time;
		this.sh_leibie = sh_leibie;
		this.o_id = o_id;
	}
	public String getSh_id() {
		return sh_id;
	}
	public void setSh_id(String sh_id) {
		this.sh_id = sh_id;
	}
	public String getSh_zl() {
		return sh_zl;
	}
	public void setSh_zl(String sh_zl) {
		this.sh_zl = sh_zl;
	}
	public String getSh_bzjg() {
		return sh_bzjg;
	}
	public void setSh_bzjg(String sh_bzjg) {
		this.sh_bzjg = sh_bzjg;
	}
	public Timestamp getSh_time() {
		return sh_time;
	}
	public void setSh_time(Timestamp sh_time) {
		this.sh_time = sh_time;
	}
	public String getSh_leibie() {
		return sh_leibie;
	}
	public void setSh_leibie(String sh_leibie) {
		this.sh_leibie = sh_leibie;
	}
	public String getO_id() {
		return o_id;
	}
	public void setO_id(String o_id) {
		this.o_id = o_id;
	}
	
	
}
