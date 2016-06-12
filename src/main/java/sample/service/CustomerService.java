package sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sample.mybatis.domain.Customer;
import sample.mybatis.mapper.CustomerMapper;

@Service
public class CustomerService {
	@Autowired
	private CustomerMapper customerMapper;
	
	public List<Customer> findAll(){
		 return customerMapper.findAll();
	}
	
}
