package com.avega.training.clinet;

import java.sql.Date;

import com.avega.training.dao.EmployeeDao;
import com.avega.training.daoImpl.EmployeeDaoImpl;
import com.avega.training.pojo.Employee;

public class TestClient {

	public static void main(String[] args) {
						
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		employeeDao.getAllEmployees().forEach(emp -> System.out.println(emp));
//		employeeDao.addEmployee(new Employee("E104", "Naveen", 20000, "Senior Developer", Date.valueOf("2011-04-21")));
//		System.out.println(employeeDao.getEmployeeById("E104"));
//		employeeDao.removeEmployee("E104");
//		employeeDao.updateEmployee(new Employee("E102", "Samuvel", 30000, "Testor", Date.valueOf("2018-05-12")));
	}

}
