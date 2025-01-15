package com.ops.om;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.ops.utility.DBUtil;

public class InsertApp {

	private static final String SQL_INSERT_QUERY = "insert into student(`roll_no`, `name` , `marks`) values(?,?,?) ";

	//private static final String QUERY_INSERT = "insert into student values(1002,'Shaksham',87)";

	public static void main(String[] args) {
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		int rowCount=0;
		Scanner sc = null;
		
	    try {
			connection =	DBUtil.getDBConnection();
			if(connection != null)
				 pstmt = connection.prepareStatement(SQL_INSERT_QUERY);
			
			 sc= new Scanner(System.in);
			 System.out.println("Enter student roll_no :  ");
			int roll_no = sc.nextInt();
			 System.out.println("Enter student name :  ");
			String name = sc.next();
			
			 System.out.println("Enter student marks :  ");
			int marks = sc.nextInt();

			
			pstmt.setInt(1, roll_no);
			pstmt.setString(2,name);
			pstmt.setInt(3, marks);
			
			if(sc!= null && pstmt != null)
		 rowCount =	pstmt.executeUpdate();
			
			if(rowCount == 0)
				System.out.println("failure of intsertion...");
			else
				System.out.println("Record inserted sucessfully....");
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.cleanUpResources(null, pstmt, connection);
			if(sc !=null) {
				sc.close();
			}
		}
        

	}

}
