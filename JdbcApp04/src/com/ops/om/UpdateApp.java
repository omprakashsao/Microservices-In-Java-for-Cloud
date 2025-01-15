package com.ops.om;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.ops.utility.DBUtil;

public class UpdateApp {

	//private static final String QUERY_UPDATE = "update student set  name = 'mohan das' where roll_no = 1001";

	public static void main(String[] args) {
		
		  Connection connection = null;
		  Statement stmt = null;
		  int test = 0;
		  Scanner sc = null;
		  
		try {
			connection = DBUtil.getDBConnection();
			if(connection != null)
				 stmt = connection.createStatement();
			sc = new Scanner(System.in);
			System.out.println("Enter the new name ");
			String name = sc.next();
			System.out.println("Enter student roll_no");
			int roll_no = sc.nextInt();
			String updateRecord = "update student set  name = '"+name+"' where roll_no = "+roll_no;
			if(stmt != null)
				test=stmt.executeUpdate(updateRecord);
			if(test ==0)
				System.out.println("Record not be updated..");
			else
				System.out.println("Record updated successfully");
				
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.cleanUpResources(null, stmt, connection);
		}

	}

}
