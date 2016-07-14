package com.entity;

public class UserRelation {
	private int power;
	private String powerName;

	public UserRelation(int power, String powerName) {
		super();
		this.power = power;
		this.powerName = powerName;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public String getPowerName() {
		return powerName;
	}

	public void setPowerName(String powerName) {
		this.powerName = powerName;
	}

}
