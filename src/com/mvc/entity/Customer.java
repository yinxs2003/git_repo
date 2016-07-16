package com.mvc.entity;

public class Customer {
	private Integer Id;
	private String name;
	private String pass;

	
	public Customer() {
	}
	
	public Customer(String name, String pass) {
		this.name = name;
		this.pass = pass;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Customer [Id=" + Id + ", name=" + name + ", pass=" + pass + "]";
	}

}
