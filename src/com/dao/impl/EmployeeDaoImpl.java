package com.dao.impl;

import com.beans.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("employeeDao")
public class EmployeeDaoImpl {

    private final SessionFactory sessionFactory;

    @Autowired
    public EmployeeDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Employee getEmployeeBySn(String sn) {
        String hql = "from Employee where sn = ?";
        return (Employee) getSession().createQuery(hql).setString(0, sn).uniqueResult();
    }

//    @Override
//    public List<Employee> getEmployees() {
//        String hql = "from Employee";
//        return (Employee) (getSession().createQuery(hql).list());
//
//    }

//    public void updateEmployee(Employee emp) {
//
//    }

    public int deleteEmployeeBySn(String sn) {
        return 0;
    }

    @SuppressWarnings("unchecked")
    public List<Employee> getAll() {
        String hql = "from Employee";
        return (List<Employee>) getSession().createQuery(hql).list();
    }

}
