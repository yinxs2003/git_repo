package com.mvc.service;

import com.mvc.entity.Customer;

import java.util.List;

public interface CustomerService {
	List<Customer> getAll();

	Customer getCustomerByName(String name);

	boolean insert(Customer c);

	boolean update(Customer customer);
}
