package com.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.beans.Employee;
import com.dao.EmployeeDao;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public Employee getEmployeeBySn(String sn) {
		String hql = "from Employee where sn = ?";
		Employee emp = (Employee) getSession().createQuery(hql).setString(0, sn).uniqueResult();
		return emp;
	}

	@Override
	public List<Employee> getEmployees() {
		return null;
	}

	@Override
	public void updateEmployee(Employee emp) {

	}

	@Override
	public int deleteEmployeeBySn(String sn) {
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAll() {
		String hql = "from Employee";
		List<Employee> empList = getSession().createQuery(hql).list();
		return empList;
	}

}
