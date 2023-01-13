package com.jdbc.main;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.jdbc.co.JdbcUtil;

public class DeleteDynamic {

	public static void main(String[] args) {
		//Establish the connection with DB
		
		try {
			Connection connection = JdbcUtil.getConnection();
			
			//Create a Statement and Execute the Query
			Statement statement = connection.createStatement();
			
			Scanner sc = new Scanner(System.in);
			//taking the values from user
			System.out.println("Enter the Id::");
			int id = sc.nextInt();
			
			String deleteQuery = ("delete from friends where id ="+ id);
			
			//Execute the query
			int countRow = statement.executeUpdate(deleteQuery);
			
			System.out.println("No of rows affected::"+ countRow);
			
			//closing the resource
			JdbcUtil.cleanUp(connection, statement);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}
