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
	public Customer getCustomerByName(String username) {
		String queryString = "from Customer where username=?";
//		Customer c = (Customer) sessionFactory.getCurrentSession().createQuery(queryString).setString(0, username).uniqueResult();
		Customer c = (Customer) sessionFactory.getCurrentSession().get(Customer.class, 1);
		System.out.println("select :" + c);
		return c;
	}
}
