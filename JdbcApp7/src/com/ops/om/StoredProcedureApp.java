package com.ops.om;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

import com.ops.utility.DBUtil;

public class StoredProcedureApp {

	private static final String SQL_CALL_QUERY = "{CALL  GET_PRODUCT_BY_ID(?,?,?,?)}";

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
			int id =sc.nextInt();

			//set input param
			cst.setInt(1, id);
			
			//register out params
			cst.registerOutParameter(2, Types.VARCHAR);
			cst.registerOutParameter(3, Types.INTEGER);
			cst.registerOutParameter(4, Types.INTEGER);
			
			cst.execute();
//			boolean flag = false;
//			ResultSet rs =cst.getResultSet();
//			while(rs.next()) {
//				flag=true;
//				System.out.println("pname"+rs.getObject(2)+"\n price "+rs.getObject(3)+"\n quantity"+rs.getObject(4));
//			}
			
			System.out.println("pname : "+cst.getString(2));
			System.out.println("price : "+cst.getInt(3));
		System.out.println("quantity : "+cst.getInt(4));
//			if(flag) {
//				System.out.println("Record is available ...");
//			}
//			else
//				System.out.println("Record is not available....");
			
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
