package com.entity;

import java.io.Serializable;

public class User implements Serializable {
	private String userId;
	private String userName;
	private String passWord;
	private String sex;
	private int age;
	private String phoneNumber;
	private String address;
	private int power;
	private String powerName;

	public User(String userId, String userName, String passWord, String sex, int age, String phoneNumber,
			String address, int power, String powerName) {
		this.userId = userId;
		this.userName = userName;
		this.passWord = passWord;
		this.sex = sex;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.power = power;
		this.powerName = powerName;
	}

	public User() {

	}

	public User(String userId, String userName, String passWord, int power, String powerName) {
		this.userId = userId;
		this.userName = userName;
		this.passWord = passWord;
		this.power = power;
		this.powerName = powerName;
	}

	public String getPowerName() {
		return powerName;
	}

	public void setPowerName(String powerName) {
		this.powerName = powerName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}
}