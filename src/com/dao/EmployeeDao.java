package com.dao;

import java.util.List;

import com.beans.Employee;

public interface EmployeeDao {
	Employee getEmployeeBySn(String sn);

	List<Employee> getEmployees();

	void updateEmployee(Employee emp);

	int deleteEmployeeBySn(String sn);

	List<Employee> getAll();
}
