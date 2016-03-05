package com.beans;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Employee implements Serializable {
	private static final long serialVersionUID = -4928883224796036478L;
	private String sn;
	private Postion postion;
	private Department department;
	private String name;
	private String password;
	private String status;

	public Employee() {
	}

	public Employee(String sn, Postion postion, Department department, String name, String password, String status) {
		this.sn = sn;
		this.postion = postion;
		this.department = department;
		this.name = name;
		this.password = password;
		this.status = status;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Postion getPostion() {
		return postion;
	}

	public void setPostion(Postion postion) {
		this.postion = postion;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [sn=" + sn + ", postion=" + postion + ", department=" + department + ", name=" + name
				+ ", password=" + password + ", status=" + status + "]";
	}
}
