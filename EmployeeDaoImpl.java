package com.avega.training.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.avega.training.dao.EmployeeDao;
import com.avega.training.dbutil.DBUtil;
import com.avega.training.pojo.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	
	static Logger logger = Logger.getLogger(EmployeeDaoImpl.class.getName());
	Connection connection = DBUtil.getConnection();
	PreparedStatement ps = null;

	@Override
	public List<Employee> getAllEmployees() {
		ResultSet rs = null;
		String query = "SELECT * FROM employee";
		List<Employee> employees = new ArrayList<>();
		try {
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				employees.add(
						new Employee(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getDate(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public boolean addEmployee(Employee employee) {
		boolean isAdded = false;
		String query = "INSERT INTO employee VALUES(?, ?, ?, ?, ?)";
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, employee.getEmp_id());
			ps.setString(2, employee.getEmp_name());
			ps.setInt(3, employee.getSalary());
			ps.setString(4, employee.getDepartment());
			ps.setDate(5, employee.getDoj());
			int count = ps.executeUpdate();
			if (count > 0) {
				logger.info("Employee added successfully!");
				isAdded = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isAdded;
	}

	@Override
	public Employee getEmployeeById(String emp_id) {
		ResultSet rs = null;
		String query = "SELECT * FROM employee";
		Employee employee = null;
		try {
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getString(1).equalsIgnoreCase(emp_id)) {
					employee = new Employee(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4),
							rs.getDate(5));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public boolean removeEmployee(String emp_id) {
		boolean isDeleted = false;
		String query = "DELETE FROM employee WHERE emp_id = ?";
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, emp_id);
			int count = ps.executeUpdate();
			if (count > 0) {
				logger.info("Employee deleted successfully!");
				isDeleted = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isDeleted;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		boolean isUpdate = false;
		String query = "UPDATE employee SET emp_name = ?, salary = ?, department = ?, doj = ? WHERE emp_id = ?";
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, employee.getEmp_name());
			ps.setInt(2, employee.getSalary());
			ps.setString(3, employee.getDepartment());
			ps.setDate(4, employee.getDoj());
			ps.setString(5, employee.getEmp_id());
			int count = ps.executeUpdate();
			if (count > 0) {
				logger.info("Employee details successfully updated!");
				isUpdate = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isUpdate;
	}
}
