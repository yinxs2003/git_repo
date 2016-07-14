package com.entity;

import java.io.Serializable;

public class Bill implements Serializable {
	private static final long serialVersionUID = 1L;
	private String billId;
	private String commodityName;
	private int commodityQuantity;
	private String commodityUnit;
	private double sumPrice;
	private int havePay;
	private String providerId;
	private String commodityDesc;

	public Bill() {
	}

	public Bill(String billId, String commodityName, int commodityQuantity, String commodityUnit, double sumPrice,
			int havePay, String providerId, String commodityDesc) {
		this.billId = billId;
		this.commodityName = commodityName;
		this.commodityQuantity = commodityQuantity;
		this.commodityUnit = commodityUnit;
		this.sumPrice = sumPrice;
		this.havePay = havePay;
		this.providerId = providerId;
		this.commodityDesc = commodityDesc;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public int getCommodityQuantity() {
		return commodityQuantity;
	}

	public void setCommodityQuantity(int commodityQuantity) {
		this.commodityQuantity = commodityQuantity;
	}

	public String getCommodityUnit() {
		return commodityUnit;
	}

	public void setCommodityUnit(String commodityUnit) {
		this.commodityUnit = commodityUnit;
	}

	public double getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(double sumPrice) {
		this.sumPrice = sumPrice;
	}

	public int getHavePay() {
		return havePay;
	}

	public void setHavePay(int havePay) {
		this.havePay = havePay;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public String getCommodityDesc() {
		return commodityDesc;
	}

	public void setCommodityDesc(String commodityDesc) {
		this.commodityDesc = commodityDesc;
	}

	public String getBillId() {
		return billId;
	}
}