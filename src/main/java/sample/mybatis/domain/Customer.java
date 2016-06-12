package sample.mybatis.domain;

public class Customer {
	private Integer customerId;
	private String customerName;
	private Integer customerCash;// 表示顾客拥有的现金

	public Customer() {
	}

	public Customer(String customerName, Integer customerCash) {
		this.customerName = customerName;
		this.customerCash = customerCash;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getCustomerCash() {
		return customerCash;
	}

	public void setCustomerCash(Integer customerCash) {
		this.customerCash = customerCash;
	}

}
