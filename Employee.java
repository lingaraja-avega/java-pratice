package com.avega.company.pojo;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public class Employee {

	private String id;
	private String name;
	private LocalDate doj;
	private double salary;
	private Set<Skill> skills;

	public Employee() {
	}

	public Employee(String id, String name, LocalDate doj, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.doj = doj;
		this.salary = salary;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Set<Skill> getSkills() {
		return skills;
	}

	public void setSkills(Set<Skill> skills) {
		this.skills = skills;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
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
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "EmployeeDao [id=" + id + ", name=" + name + ", doj=" + doj + ", salary=" + salary + "]";
	}

}
