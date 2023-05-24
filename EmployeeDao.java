package com.avega.training.dao;

import java.util.List;

import com.avega.training.pojo.Employee;

public interface EmployeeDao {

	List<Employee> getAllEmployees();

	Employee getEmployeeById(String emp_id);
	
	boolean addEmployee(Employee employee);
	
	boolean removeEmployee(String emp_id);
	
	boolean updateEmployee(Employee employee);
	
	

}
