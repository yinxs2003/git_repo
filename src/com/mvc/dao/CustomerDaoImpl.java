package com.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.entity.Customer;

@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SqlSessionTemplate template;;

	@Override
	public List<Customer> getAll() {
		return null;
	}

	@Transactional
	@Override
	public Customer getCustomerByName(String name) {
		System.out.println(this.getClass() + " getCustomerByName " + name);
		return template.selectOne("com.mvc.mapper.CustomerDaoMapper.selectByName", name);
	}
}
