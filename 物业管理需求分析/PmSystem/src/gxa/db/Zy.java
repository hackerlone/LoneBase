package gxa.db;

import java.sql.Date;
/*
 * 资源信息实体类
 * */
public class Zy implements java.io.Serializable {
	private String zy_id; 		//资源编号
	private String k_id; 		//仓库id
	private String zy_leibie; 		//资源类别
	private String zy_name; 		//资源名称
	private String zy_qingkuang;		//资源现在情况
	private String zy_waijieren; 		//资源外借人
	private String w_id; 		//管理员id
	private int ck_id; 		//仓库id
	public Zy(String zy_id, String k_id, String zy_leibie, String zy_name,
			String zy_qingkuang, String zy_waijieren, String w_id, int ck_id) {
		super();
		this.zy_id = zy_id;
		this.k_id = k_id;
		this.zy_leibie = zy_leibie;
		this.zy_name = zy_name;
		this.zy_qingkuang = zy_qingkuang;
		this.zy_waijieren = zy_waijieren;
		this.w_id = w_id;
		this.ck_id = ck_id;
	}
	public Zy() {
		super();
	}
	public String getZy_id() {
		return zy_id;
	}
	public void setZy_id(String zy_id) {
		this.zy_id = zy_id;
	}
	public String getK_id() {
		return k_id;
	}
	public void setK_id(String k_id) {
		this.k_id = k_id;
	}
	public String getZy_leibie() {
		return zy_leibie;
	}
	public void setZy_leibie(String zy_leibie) {
		this.zy_leibie = zy_leibie;
	}
	public String getZy_name() {
		return zy_name;
	}
	public void setZy_name(String zy_name) {
		this.zy_name = zy_name;
	}
	public String getZy_qingkuang() {
		return zy_qingkuang;
	}
	public void setZy_qingkuang(String zy_qingkuang) {
		this.zy_qingkuang = zy_qingkuang;
	}
	public String getZy_waijieren() {
		return zy_waijieren;
	}
	public void setZy_waijieren(String zy_waijieren) {
		this.zy_waijieren = zy_waijieren;
	}
	public int getCk_id() {
		return ck_id;
	}
	public void setCk_id(int ck_id) {
		this.ck_id = ck_id;
	}
	public String getW_id() {
		return w_id;
	}
	public void setW_id(String w_id) {
		this.w_id = w_id;
	}
	
	
	
}
