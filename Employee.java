package com.avega.training.pojo;

import java.sql.Date;
import java.util.Objects;

public class Employee {
	private String emp_id;
	private String emp_name;
	private int salary;
	private String department;
	private Date doj;

	public Employee() {
	}

	public Employee(String emp_id, String emp_name, int salary, String department, Date doj) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.salary = salary;
		this.department = department;
		this.doj = doj;
	}

	public String getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_name=" + emp_name + ", salary=" + salary + ", department="
				+ department + ", doj=" + doj + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(emp_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(emp_id, other.emp_id);
	}

}
