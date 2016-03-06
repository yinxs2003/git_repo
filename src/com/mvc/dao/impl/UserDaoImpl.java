package com.mvc.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.mvc.dao.UserDao;
import com.mvc.entity.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	HibernateTemplate hibernateTemplate;

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAll() {
		String queryString = "from User";
		return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(queryString).list();
	}

}
