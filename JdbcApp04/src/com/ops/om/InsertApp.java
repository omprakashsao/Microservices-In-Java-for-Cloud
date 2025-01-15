package com.ops.om;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.ops.utility.DBUtil;

public class InsertApp {

	private static final String SELECT_SQL_QUERY = "insert into users(`username`,`dob`) values(?,?)";

	//private static final String QUERY_INSERT = "insert into student values(1002,'Shaksham',87)";

	public static void main(String[] args) {
		
		Connection connection = null;
		PreparedStatement pStmt = null;
		int rowCount=0;
		Scanner sc = null;
		
	    try {
			connection =	DBUtil.getDBConnection();
			if(connection != null)
			   pStmt =   connection.prepareStatement(SELECT_SQL_QUERY);
			
			  sc = new Scanner(System.in);
			  System.out.println("Enter the username: ");
			  String name = sc.next();
			  
			  System.out.println("Enter the dob");
			  String dob = sc.next();
			  
			  pStmt.setString(1, name);
			  pStmt.setDate(2, convertToDate(dob));
			  
			if(pStmt!=null )
				 rowCount = pStmt.executeUpdate();
			
			if(rowCount == 0)
				System.out.println("Record is not iserted....");
			else
				System.out.println("Record is inserted sucessfully....");
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.cleanUpResources(null, pStmt, connection);
			if(sc !=null) {
				sc.close();
			}
		}
        

	}

	private static Date convertToDate(String dob) throws ParseException {
		
		SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date utilDate = s.parse(dob);
		long inMs = utilDate.getTime();
		java.sql.Date sqlDate = new Date(inMs);
		return sqlDate;
	}

}
