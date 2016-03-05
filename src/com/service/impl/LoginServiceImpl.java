package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beans.Employee;
import com.dao.EmployeeDao;
import com.service.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public boolean login(Employee employee) {
		String sn = employee.getSn();
		String password = employee.getPassword();
		Employee emp = employeeDao.getEmployeeBySn(sn);
		if (emp.getPassword().equals(password)) {
			return true;
		}
		return false;
	}

}
