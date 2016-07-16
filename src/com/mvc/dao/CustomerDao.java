package com.mvc.dao;

import com.mvc.entity.Customer;

import java.util.List;

public interface CustomerDao {
	List<Customer> getAll();

	Customer getCustomerByName(String name);

	int insert(Customer c);

	int update(Customer customer);
}
