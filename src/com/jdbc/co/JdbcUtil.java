package com.jdbc.co;

import java.sql.*;

public class JdbcUtil {

	public static Connection getConnection() throws SQLException {

		String url = "jdbc:mysql:///people";
		String userName = "root";
		String password = "Sagar@123";

		Connection connection = DriverManager.getConnection(url, userName, password);

		return connection;

	}

	public static void cleanUp(Connection c, Statement s) {

		
		if (s != null)
			try {
				s.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if (c != null)
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
}
