package com.mvc.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.entity.Customer;

@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getAll() {
		return null;
	}

	@Transactional
	@Override
	public Customer getCustomerByName(String name) {
		System.out.println(this.getClass() + " getCustomerByName");
		String queryString = "from Customer where name=?";
		return (Customer) sessionFactory.getCurrentSession().createQuery(queryString).setString(0, name).uniqueResult();
	}
}
