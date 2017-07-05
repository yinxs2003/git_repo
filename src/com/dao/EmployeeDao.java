package com.dao;

import com.beans.Employee;

import java.util.List;

public interface EmployeeDao {
	Employee getEmployeeBySn(String sn);

//	List<Employee> getEmployees();

	void updateEmployee(Employee emp);

	int deleteEmployeeBySn(String sn);

	List<Employee> getAll();
}
