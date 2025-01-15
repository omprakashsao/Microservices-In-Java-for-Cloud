package com.ops.om;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.ops.utility.DBUtil;

public class DyanmicQuery {

	public static void main(String[] args) {

		  Connection connection = null;
		  Statement stmt = null;
		  ResultSet rs = null;
		  boolean test = false;
		  Scanner sc = null;
		  int rowCount = 0;
		  
		try {
			connection = DBUtil.getDBConnection();
			if(connection != null)
				 stmt = connection.createStatement();
	
			System.out.println("Enter the Query for performing database operation ");
			sc = new Scanner(System.in);
			String query = sc.nextLine();
		
			if(stmt != null &&  sc  != null) {
				test=stmt.execute(query);
				sc.close();
			}
		
			if(test) {
				 rs = stmt.getResultSet();
			    while(rs.next())
			    	System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));
			}
			else if(test == false)
			{
				   rowCount =stmt.getUpdateCount();
					if(rowCount == 0)
						System.out.println("failure of intsertion...");
					else
						System.out.println("Record inserted sucessfully....");
			}
				
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.cleanUpResources(rs, stmt, connection);
		}

	}

}
