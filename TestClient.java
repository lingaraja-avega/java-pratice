package com.avega.company.client;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.avega.company.pojo.Employee;
import com.avega.company.pojo.Skill;
import com.avega.company.serviceImpl.EmployeeServiceImpl;
import com.avega.company.serviceImpl.SkillServiceImpl;

public class TestClient {

	public static void main(String[] args) {
		
		Skill s1 = new Skill("S101", "Java");
		Skill s2 = new Skill("S102", "Spring Framework");
		Skill s3 = new Skill("S103", "SQL");
		Skill s4 = new Skill("S104", "Spring Boot");
		Skill s5 = new Skill("S105", "React");
		Skill s6 = new Skill("S106", "JavaScript");

		Set<Skill> set1 = new HashSet<>();
		set1.add(s1);
		set1.add(s2);
		set1.add(s4);
		set1.add(s5);

		Set<Skill> set2 = new HashSet<>();
		set2.add(s6);
		set2.add(s2);
		set2.add(s4);

		Set<Skill> set3 = new HashSet<>();
		set3.add(s1);
		set3.add(s3);
		set3.add(s4);

		SkillServiceImpl skillService = new SkillServiceImpl();
		skillService.createSkill(s1);
		skillService.createSkill(s2);
		skillService.createSkill(s3);
		skillService.createSkill(s4);
		skillService.createSkill(s5);
		skillService.createSkill(s6);
		
		EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
		employeeService.createEmployee(new Employee("E101", "Lingesh", LocalDate.of(2022, 01, 05), 20000));
		employeeService.createEmployee(new Employee("E102", "Kavya", LocalDate.of(2017, 04, 21), 22000));
		employeeService.createEmployee(new Employee("E103", "Gokul", LocalDate.of(2019, 11, 11), 30000));

		employeeService.loadSkillsToEmployee(set1, "E101");
		employeeService.loadSkillsToEmployee(set2, "E102");
		employeeService.loadSkillsToEmployee(set3, "E103");

//		employeeService.findAllEmployees().forEach(emp -> System.out.println(emp));
//		employeeService.skillsByEmployee("E101").forEach(sk -> System.out.println(sk));
		employeeService.employeeJavaAndSpringBootSkill().forEach(emp -> System.out.println(emp.getName()));

	}
}
