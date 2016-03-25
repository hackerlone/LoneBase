package com.mpqi.myminecontentprovider.bean;

public class Person {
	private Integer id;
	private String name;
	private String phone;
	private Integer salary;

	public Person(String name, String phone, Integer salary) {
		this.name = name;
		this.phone = phone;
		this.salary = salary;
	}

	public Person(Integer id, String name, String phone, Integer salary) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.salary = salary;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", phone=" + phone
				+ ", salary=" + salary + "]";
	}

}
