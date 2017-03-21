package com.mvc.service;

import java.util.List;

import com.mvc.entity.Customer;

public interface CustomerService {
	List<Customer> getAll();

	Customer getCustomerByName(String username);
}
