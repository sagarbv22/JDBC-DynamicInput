package com.jdbc.main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.jdbc.co.JdbcUtil;

public class InsertDynamic {

	public static void main(String[] args) {
		
		
		//Establish the connection with DB
		Connection connection;
		try {
			connection = JdbcUtil.getConnection();
			
			//Create a Statement and Execute the Query
			Statement statement = connection.createStatement();
			
			Scanner sc = new Scanner(System.in);
			//taking the values from user
			System.out.println("Enter the firstName::");
			String firstName = sc.next();
			System.out.println("Enter the lastName::");
			String lastName = sc.next();
			System.out.println("Enter the Profession::");
			String profession = sc.next();
			System.out.println("Enter the city::");
			String city = sc.next();
			
			//formatting the string value to query
			String insertQuery = String.format("Insert into friends(firstName, lastName, profession, city) values('%s','%s', '%s', '%s')",
					firstName, lastName,profession, city);
			
			//Execute the query
			int countRow = statement.executeUpdate(insertQuery);
			
			System.out.println("No of rows affected::"+ countRow);
			
			//closing the resource
			JdbcUtil.cleanUp(connection, statement);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		
		
		
	}

}
