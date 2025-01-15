package com.ops.om;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.Scanner;

import com.ops.utility.DBUtil;

public class InsertApp {

	//private static final String QUERY_INSERT = "insert into student values(1002,'Shaksham',87)";

	public static void main(String[] args) {
		
		Connection connection = null;
		Statement stmt = null;
		int rowCount=0;
		Scanner sc = null;
		
	    try {
			connection =	DBUtil.getDBConnection();
			if(connection != null)
			stmt = connection.createStatement();
			
			 sc= new Scanner(System.in);
			 System.out.println("Enter student roll_no :  ");
			int roll_no = sc.nextInt();
			 System.out.println("Enter student name :  ");
			String name = sc.next();
			
			 System.out.println("Enter student marks :  ");
			int marks = sc.nextInt();
			String InsertQuery="insert into student values("+roll_no+",'"+name+"',"+marks+")";
			if(stmt != null)
			   rowCount =stmt.executeUpdate(InsertQuery);
			if(rowCount == 0)
				System.out.println("failure of intsertion...");
			else
				System.out.println("Record inserted sucessfully....");
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.cleanUpResources(null, stmt, connection);
			if(sc !=null) {
				sc.close();
			}
		}
        

	}

}
