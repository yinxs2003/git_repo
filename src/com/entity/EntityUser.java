package com.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class EntityUser {
	private String username;
	private String password;

	// 限定日期格式
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date birth;
	private int workTime;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public int getWorkTime() {
		return workTime;
	}

	public void setWorkTime(int workTime) {
		this.workTime = workTime;
	}

	public EntityUser() {
	}

	public EntityUser(String username, String password, Date birth, int workTime) {
		this.username = username;
		this.password = password;
		this.birth = birth;
		this.workTime = workTime;
	}

	@Override
	public String toString() {
		return "EntityUser [username=" + username + ", password=" + password + ", birth=" + birth + ", workTime="
				+ workTime + "]";
	}

}
