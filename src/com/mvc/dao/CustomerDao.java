package com.mvc.dao;

import java.util.List;

import com.mvc.entity.Customer;

public interface CustomerDao {
	List<Customer> getAll();

	Customer getCustomerByName(String name);
}
