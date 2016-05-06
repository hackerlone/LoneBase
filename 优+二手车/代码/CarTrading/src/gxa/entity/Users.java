package gxa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class Users implements java.io.Serializable {

	// Fields

	private Integer UId;
	private Admin admin;
	private String UName;
	private String UPwd;
	private String UImg;
	private Integer coin;
	private String UPhone;
	private String UType;
	private String UAdress;
	private Set cars = new HashSet(0);

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** minimal constructor */
	public Users(Integer UId) {
		this.UId = UId;
	}

	/** full constructor */
	public Users(Integer UId, Admin admin, String UName, String UPwd,
			String UImg, Integer coin, String UPhone, String UType,
			String UAdress, Set cars) {
		this.UId = UId;
		this.admin = admin;
		this.UName = UName;
		this.UPwd = UPwd;
		this.UImg = UImg;
		this.coin = coin;
		this.UPhone = UPhone;
		this.UType = UType;
		this.UAdress = UAdress;
		this.cars = cars;
	}

	// Property accessors

	public Integer getUId() {
		return this.UId;
	}

	public void setUId(Integer UId) {
		this.UId = UId;
	}

	public Admin getAdmin() {
		return this.admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String getUName() {
		return this.UName;
	}

	public void setUName(String UName) {
		this.UName = UName;
	}

	public String getUPwd() {
		return this.UPwd;
	}

	public void setUPwd(String UPwd) {
		this.UPwd = UPwd;
	}

	public String getUImg() {
		return this.UImg;
	}

	public void setUImg(String UImg) {
		this.UImg = UImg;
	}

	public Integer getCoin() {
		return this.coin;
	}

	public void setCoin(Integer coin) {
		this.coin = coin;
	}

	public String getUPhone() {
		return this.UPhone;
	}

	public void setUPhone(String UPhone) {
		this.UPhone = UPhone;
	}

	public String getUType() {
		return this.UType;
	}

	public void setUType(String UType) {
		this.UType = UType;
	}

	public String getUAdress() {
		return this.UAdress;
	}

	public void setUAdress(String UAdress) {
		this.UAdress = UAdress;
	}

	public Set getCars() {
		return this.cars;
	}

	public void setCars(Set cars) {
		this.cars = cars;
	}

}