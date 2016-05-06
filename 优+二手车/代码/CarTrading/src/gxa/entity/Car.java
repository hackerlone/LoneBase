package gxa.entity;

import java.util.Date;

/**
 * Car entity. @author MyEclipse Persistence Tools
 */

public class Car implements java.io.Serializable {

	// Fields

	private Integer CId;
	private Integer UId;
	private Integer ctId;
	private Integer AId;
	private String brand;
	private String carseries;
	private String chexing;
	private String CArea;
	private Float kilometre;
	private Date registration;
	private Float price;
	private String image;
	private String introduce;
	private String tel;
	private String realname;
	private String area;
	private Date nianjian;
	private Date insurance;
	private String upkeep;
	private String CUse;
	private String CChange;
	private Date releasetime;

	// Constructors

	/** default constructor */
	public Car() {
	}

	/** minimal constructor */
	public Car(Integer CId) {
		this.CId = CId;
	}

	/** full constructor */
	public Car(Integer CId, Integer UId, Integer ctId, Integer AId,
			String brand, String carseries, String chexing, String CArea,
			Float kilometre, Date registration, Float price, String image,
			String introduce, String tel, String realname, String area,
			Date nianjian, Date insurance, String upkeep, String CUse,
			String CChange, Date releasetime) {
		this.CId = CId;
		this.UId = UId;
		this.ctId = ctId;
		this.AId = AId;
		this.brand = brand;
		this.carseries = carseries;
		this.chexing = chexing;
		this.CArea = CArea;
		this.kilometre = kilometre;
		this.registration = registration;
		this.price = price;
		this.image = image;
		this.introduce = introduce;
		this.tel = tel;
		this.realname = realname;
		this.area = area;
		this.nianjian = nianjian;
		this.insurance = insurance;
		this.upkeep = upkeep;
		this.CUse = CUse;
		this.CChange = CChange;
		this.releasetime = releasetime;
	}

	// Property accessors

	public Integer getCId() {
		return this.CId;
	}

	public void setCId(Integer CId) {
		this.CId = CId;
	}

	public Integer getUId() {
		return this.UId;
	}

	public void setUId(Integer UId) {
		this.UId = UId;
	}

	public Integer getCtId() {
		return this.ctId;
	}

	public void setCtId(Integer ctId) {
		this.ctId = ctId;
	}

	public Integer getAId() {
		return this.AId;
	}

	public void setAId(Integer AId) {
		this.AId = AId;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCarseries() {
		return this.carseries;
	}

	public void setCarseries(String carseries) {
		this.carseries = carseries;
	}

	public String getChexing() {
		return this.chexing;
	}

	public void setChexing(String chexing) {
		this.chexing = chexing;
	}

	public String getCArea() {
		return this.CArea;
	}

	public void setCArea(String CArea) {
		this.CArea = CArea;
	}

	public Float getKilometre() {
		return this.kilometre;
	}

	public void setKilometre(Float kilometre) {
		this.kilometre = kilometre;
	}

	public Date getRegistration() {
		return this.registration;
	}

	public void setRegistration(Date registration) {
		this.registration = registration;
	}

	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getIntroduce() {
		return this.introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Date getNianjian() {
		return this.nianjian;
	}

	public void setNianjian(Date nianjian) {
		this.nianjian = nianjian;
	}

	public Date getInsurance() {
		return this.insurance;
	}

	public void setInsurance(Date insurance) {
		this.insurance = insurance;
	}

	public String getUpkeep() {
		return this.upkeep;
	}

	public void setUpkeep(String upkeep) {
		this.upkeep = upkeep;
	}

	public String getCUse() {
		return this.CUse;
	}

	public void setCUse(String CUse) {
		this.CUse = CUse;
	}

	public String getCChange() {
		return this.CChange;
	}

	public void setCChange(String CChange) {
		this.CChange = CChange;
	}

	public Date getReleasetime() {
		return this.releasetime;
	}

	public void setReleasetime(Date releasetime) {
		this.releasetime = releasetime;
	}

}