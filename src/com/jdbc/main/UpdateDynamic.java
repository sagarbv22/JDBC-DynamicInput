package com.jdbc.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.jdbc.co.JdbcUtil;

public class UpdateDynamic {

	public static void main(String[] args) {
		
		try {
			Connection connection = JdbcUtil.getConnection();
			
			//Create a Statement and Execute the Query
			Statement statement = connection.createStatement();
			
			Scanner sc = new Scanner(System.in);
			//taking the values from user
			System.out.println("Enter the city ");
			String city = sc.next();
			System.out.println("Enter the Id::");
			int id = sc.nextInt();
			
			String updateQuery = String.format("update friends set city ='%s'where id = %d" , city, id);
			
			//Execute the query
			int countRow = statement.executeUpdate(updateQuery);
			
			System.out.println("No of rows affected::"+ countRow);
			
			//closing the resource
			JdbcUtil.cleanUp(connection, statement);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}
