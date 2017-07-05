package com.service.impl;

import com.beans.Employee;
import com.dao.impl.EmployeeDaoImpl;
import com.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	@Qualifier("employeeDao")
	private EmployeeDaoImpl employeeDao;

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
