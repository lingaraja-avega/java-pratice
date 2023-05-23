package com.avega.company.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.avega.company.dao.EmployeeDao;
import com.avega.company.dao.SkillDao;
import com.avega.company.daoImpl.EmployeeDaoImpl;
import com.avega.company.daoImpl.SkillDaoImpl;
import com.avega.company.exception.EmployeeNotFoundException;
import com.avega.company.pojo.Employee;
import com.avega.company.pojo.Skill;
import com.avega.company.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDao employeeDao = null;
	SkillDao skillDaoImpl = null;

	public EmployeeServiceImpl() {
		this.employeeDao = new EmployeeDaoImpl();
		this.skillDaoImpl = new SkillDaoImpl();
	}

	@Override
	public List<Employee> findAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	@Override
	public List<Employee> findEmployeesByname(String name) {
		return employeeDao.getEmployeeByname(name);
	}

	@Override
	public Employee findEmployee(String id) {
		Employee employee = null;
		try {
			employee = employeeDao.getEmployee(id);
		} catch (EmployeeNotFoundException e) {
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public boolean createEmployee(Employee employee) {
		return employeeDao.addEmployee(employee);
	}

	@Override
	public boolean removeEmployee(Employee employee) {
		return employeeDao.deleteEmployee(employee);
	}

	@Override
	public Employee editEmployee(Employee employee) {
		Employee emp = null;
		try {
			emp = employeeDao.updateEmployee(employee);
		} catch (EmployeeNotFoundException e) {
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public boolean loadSkillsToEmployee(Set<Skill> skills, String id) {
		return employeeDao.assignSkillsToEmoloyee(skills, id);
	}

	@Override
	public List<Employee> employeeJavaAndSpringBootSkill() {
		List<Employee> employeeByCondition = new ArrayList<>();
		for (Employee employee : employeeDao.getAllEmployees()) {
			int count = 0;
			for (Skill skill : employee.getSkills()) {
				if (skill.getSkillName().equalsIgnoreCase("Java")
						|| skill.getSkillName().equalsIgnoreCase("Spring Boot"))
					count += 1;
			}
			if (count == 2)
				employeeByCondition.add(employee);
		}
		return employeeByCondition;
	}

	@Override
	public List<String> skillsByEmployee(String empId) {
		List<String> skillNames = new ArrayList<>();
		employeeDao.getAllEmployees().forEach(emp -> {
			if (emp.getId().equalsIgnoreCase(empId)) {
				emp.getSkills().forEach(skill -> {
					skillNames.add(skill.getSkillName());
				});
			}
		});

		return skillNames;
	}

}
