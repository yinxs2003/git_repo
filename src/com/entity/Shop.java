package com.entity;

import java.util.Arrays;

public class Shop {
	private String name;
	private String StaffName[];

	public Shop() {
	}

	public Shop(String name, String[] staffName) {
		this.name = name;
		this.StaffName = staffName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getStaffName() {
		return StaffName;
	}

	public void setStaffName(String[] staffName) {
		StaffName = staffName;
	}

	@Override
	public String toString() {
		return "Shop [name=" + name + ", StaffName=" + Arrays.toString(StaffName) + "]";
	}
}
