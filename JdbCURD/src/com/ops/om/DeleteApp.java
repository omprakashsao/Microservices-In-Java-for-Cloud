package com.ops.om;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.ops.utility.JdbcUtil;

public class DeleteApp {

	//private static final String QUERY_DELETE = "delete from student where roll_no=1022";

	public static void main(String[] args) {	 
		
		
	Connection connection = null;
	  Statement stmt = null;
	  int test = 0;
	  Scanner sc = null;
	  
	try {
		connection = JdbcUtil.getDBConnection();
		if(connection != null)
			 stmt = connection.createStatement();
		 
		 sc = new Scanner(System.in);
		System.out.println("Enter the student roll no.");
		int roll_no = sc.nextInt();
		sc.close();
		String deleteQuery="delete from student where roll_no = "+roll_no;
		
		if(stmt != null)
			test=stmt.executeUpdate(deleteQuery);
		if(test ==0)
			System.out.println("Record not be deleted..");
		else
			System.out.println("Record deleted successfully");
			
	} catch (IOException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		JdbcUtil.cleanUpResources(null, stmt, connection);
	}

	}

}
