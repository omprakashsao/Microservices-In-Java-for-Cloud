package com.ops.om;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
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

public class InsertApp2Resumetxt {

	private static final String SELECT_SQL_QUERY = "insert into employee(`ename`,`eaddress`,`resume`) values(?,?,?)";

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
			  System.out.println("Enter the name: ");
			  String name = sc.next();
			  
			  System.out.println("Enter the address: ");
			  String address = sc.next();
			  
			  pStmt.setString(1, name);
			  pStmt.setString(2, address);
			  pStmt.setCharacterStream(3, new FileReader(new File("C:\\Users\\kajal\\OneDrive\\Documents\\intro vid.txt")));
			
			 
			  
			if(pStmt!=null )
				 rowCount = pStmt.executeUpdate();
			
			if(rowCount == 0)
				System.out.println("Record is not iserted....");
			else
				System.out.println("Record is inserted sucessfully....");
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.cleanUpResources(null, pStmt, connection);
			if(sc !=null) {
				sc.close();
			}
		}
        

	}

}
