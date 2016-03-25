package gxa.db;

public class Suppliers {

	
	private Integer s_id;
	private String s_name;
	private String s_site;
	private String s_tel;
	public Suppliers() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Suppliers(Integer s_id, String s_name, String s_site, String s_tel) {
		super();
		this.s_id = s_id;
		this.s_name = s_name;
		this.s_site = s_site;
		this.s_tel = s_tel;
	}
	public Integer getS_id() {
		return s_id;
	}
	public void setS_id(Integer s_id) {
		this.s_id = s_id;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getS_site() {
		return s_site;
	}
	public void setS_site(String s_site) {
		this.s_site = s_site;
	}
	public String getS_tel() {
		return s_tel;
	}
	public void setS_tel(String s_tel) {
		this.s_tel = s_tel;
	}
	
	
	
	
}
