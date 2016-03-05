package com.beans;

import java.io.Serializable;

public class Department implements Serializable{
	private static final long serialVersionUID = 7018566590922251885L;
	private Integer id;
	private String department;

	public Department() {
	}

	public Department(String department) {
		this.department = department;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", department=" + department + "]";
	}

}
