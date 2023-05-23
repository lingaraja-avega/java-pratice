package com.avega.company.service;

import java.util.List;
import java.util.Set;

import com.avega.company.pojo.Employee;
import com.avega.company.pojo.Skill;

public interface EmployeeService {

	List<Employee> findAllEmployees();

	List<Employee> findEmployeesByname(String name);

	Employee findEmployee(String id);

	boolean createEmployee(Employee employee);

	boolean removeEmployee(Employee employee);

	Employee editEmployee(Employee employee);

	List<Employee> employeeJavaAndSpringBootSkill();

	List<String> skillsByEmployee(String empId);

	boolean loadSkillsToEmployee(Set<Skill> skills, String id);
}
