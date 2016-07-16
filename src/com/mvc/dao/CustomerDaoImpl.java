package com.mvc.dao;

import com.mvc.controller.LoginController;
import com.mvc.entity.Customer;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao {

	static final Logger logger = Logger.getLogger(LoginController.class);

	@Autowired
	private SqlSessionTemplate template;

	@Override
	public List<Customer> getAll() {
		return null;
	}

	@Transactional
	@Override
	public Customer getCustomerByName(String name) {
		logger.info(this.getClass() + " getCustomerByName " + name);
		return template.selectOne("com.mvc.mapper.CustomerDaoMapper.selectByName", name);
	}

	@Override
	public int insert(Customer c) {
		logger.info(this.getClass() + " insert " + c.getName() + " " + c.getPass());
		return template.insert("com.mvc.mapper.CustomerDaoMapper.insert", c);

	}

	@Override
	public int update(Customer customer) {
		logger.info(this.getClass() + " update " + customer);
		return template.update("com.mvc.mapper.CustomerDaoMapper.update",customer);
	}
}
