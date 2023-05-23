package com.avega.company.daoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.avega.company.dao.EmployeeDao;
import com.avega.company.exception.EmployeeNotFoundException;
import com.avega.company.pojo.Employee;
import com.avega.company.pojo.Skill;

public class EmployeeDaoImpl implements EmployeeDao {

	List<Employee> employees = new ArrayList<>();

	@Override
	public List<Employee> getAllEmployees() {
		return employees;
	}

	@Override
	public List<Employee> getEmployeeByname(String name) {
		List<Employee> employeeByname = new ArrayList<>();
		employees.forEach(emp -> {
			if (emp.getName().equalsIgnoreCase(name))
				employeeByname.add(emp);
		});
		return employeeByname;
	}

	@Override
	public Employee getEmployee(String id) throws EmployeeNotFoundException  {
		Employee emp = null;
		for (Employee employee : employees) {
			if (employee.getId().equalsIgnoreCase(id))
				emp = employee;
		}
		if(emp == null) {
			 throw new EmployeeNotFoundException();
 		}
		return emp;
	}

	@Override
	public boolean addEmployee(Employee employee) {
		return employees.add(employee);
	}

	@Override
	public boolean deleteEmployee(Employee employee) {
		return employees.remove(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Employee update = null;
		try {
			update = getEmployee(employee.getId());
		} catch (EmployeeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		update.setName(employee.getName());
		update.setDoj(employee.getDoj());
		update.setSalary(employee.getSalary());
		update.setSkills(employee.getSkills());
		return update;
	}

	@Override
	public boolean assignSkillsToEmoloyee(Set<Skill> skills, String employeeId) {
		boolean isSkillAdd = false;
		for (Employee employee : employees) {
			if (employee.getId().equalsIgnoreCase(employeeId)) {
				employee.setSkills(skills);
				if (employee.getSkills().equals(skills))
					isSkillAdd = true;
			}
		}
		return isSkillAdd;
	}

}
