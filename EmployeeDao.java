package com.avega.company.dao;

import java.util.List;
import java.util.Set;

import com.avega.company.exception.EmployeeNotFoundException;
import com.avega.company.pojo.Employee;
import com.avega.company.pojo.Skill;

public interface EmployeeDao {

	List<Employee> getAllEmployees();

	List<Employee> getEmployeeByname(String name);

	Employee getEmployee(String id) throws EmployeeNotFoundException;

	boolean addEmployee(Employee employee);

	boolean deleteEmployee(Employee employee);

	Employee updateEmployee(Employee employee) throws EmployeeNotFoundException;
	
	boolean assignSkillsToEmoloyee(Set<Skill> skills, String employeeId);

}
