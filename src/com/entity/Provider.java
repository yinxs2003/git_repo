package com.entity;

import java.io.Serializable;

public class Provider implements Serializable {
	private static final long serialVersionUID = 1L;
	private String providerId;
	private String providerName;
	private String providerDesc;
	private String providerMobile;
	private String providerAddress;

	public Provider() {
	}

	public Provider(String providerId, String providerName, String providerDesc, String providerMobile,
			String providerAddress) {
		this.providerId = providerId;
		this.providerName = providerName;
		this.providerDesc = providerDesc;
		this.providerMobile = providerMobile;
		this.providerAddress = providerAddress;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getProviderDesc() {
		return providerDesc;
	}

	public void setProviderDesc(String providerDesc) {
		this.providerDesc = providerDesc;
	}

	public String getProviderMobile() {
		return providerMobile;
	}

	public void setProviderMobile(String providerMobile) {
		this.providerMobile = providerMobile;
	}

	public String getProviderAddress() {
		return providerAddress;
	}
}
