package com.ops.om;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.ops.utility.DBUtil;

public class StoredProcedureApp2 {

	private static final String SQL_CALL_QUERY = "{CALL  GET_PRODUCTDETAILS_BY_NAME(?,?)}";

	public static void main(String[] args) {
	
		Connection connection = null;
	CallableStatement cst = null;
	Scanner sc =null;

	try {
		connection = DBUtil.getDBConnection();
		
		if(connection != null) {
		cst	=connection.prepareCall(SQL_CALL_QUERY);
		}
		
		sc = new Scanner(System.in);
		
			System.out.println("Enter the id of product to get product details: ");
			String id1 =sc.next();
			
			System.out.println("Enter the id of product to get product details: ");
			String id2 =sc.next();


			//set input param
			cst.setString(1, id1);
			cst.setString(2, id2);
			
			
			
			cst.execute();
			
			boolean flag = false;
			ResultSet rs =cst.getResultSet();
			while(rs.next()) {
				flag=true; 
				System.out.println("pid "+rs.getObject(1)+"\npname "+rs.getObject(2)+"\n price "+rs.getObject(3)+"\n quantity"+rs.getObject(4));
			}
			
		
			if(flag) {
				System.out.println("Record is available ...");
			}
			else
				System.out.println("Record is not available....");
			
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
