package com.avega.training.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DBUtil {
	static Connection connection = null;
	static Logger logger = Logger.getLogger(DBUtil.class.getName());

	public static Connection getConnection() {

		try {
			Class.forName("org.postgresql.Driver");

			try {
				connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc", "postgres",
						"root");
				logger.info("Successfully Connected!");
				

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return connection;
	}

}
