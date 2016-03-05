package com.beans;

import java.io.Serializable;
import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("claimVoucher")
public class ClaimVoucher implements Serializable {
	private static final long serialVersionUID = 6014774200189880393L;
	private Integer id;
	// private String nextDealSn;下一个Emp 编号
	private Employee nextEmployee;

	// private String creatorSn;创建者的Emp sn
	private Employee creator;

	private Date createTime;
	private Date modifyTime;
	private String event;
	private Double totalAccount;
	private String status;

	public ClaimVoucher() {
	}

	public ClaimVoucher(Employee nextEmployee, Employee creator, Date createTime, Date modifyTime, String event,
			Double totalAccount, String status) {
		this.nextEmployee = nextEmployee;
		this.creator = creator;
		this.createTime = createTime;
		this.modifyTime = modifyTime;
		this.event = event;
		this.totalAccount = totalAccount;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Employee getNextEmployee() {
		return nextEmployee;
	}

	public void setNextEmployee(Employee nextEmployee) {
		this.nextEmployee = nextEmployee;
	}

	public Employee getCreator() {
		return creator;
	}

	public void setCreator(Employee creator) {
		this.creator = creator;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public Double getTotalAccount() {
		return totalAccount;
	}

	public void setTotalAccount(Double totalAccount) {
		this.totalAccount = totalAccount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ClaimVoucher [id=" + id + ", nextEmployee=" + nextEmployee + ", creator=" + creator + ", createTime="
				+ createTime + ", modifyTime=" + modifyTime + ", event=" + event + ", totalAccount=" + totalAccount
				+ ", status=" + status + "]";
	}
}
