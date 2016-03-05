package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beans.Employee;
import com.dao.EmployeeDao;
import com.service.EmployeeService;

/**
 * 员工的服务类
 */
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	// 查询
	@Override
	public Employee getEmployeeBySn(String sn) {
		Employee emp = employeeDao.getEmployeeBySn(sn);
		if (emp == null) {
			System.err.println("该用户不存在！！");
		}
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

	@Override
	public List<Employee> getAll() {
		return employeeDao.getAll();
	}
}
