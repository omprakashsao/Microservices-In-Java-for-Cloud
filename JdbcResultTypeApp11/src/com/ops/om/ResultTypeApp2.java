package com.ops.om;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ops.utility.DBUtil;

public class ResultTypeApp2 {

	public static void main(String[] args) {
		
		try(Connection connection = DBUtil.getDBConnection()){
			
			try(Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)){
				try(ResultSet rs = stmt.executeQuery("select * from student")){
					System.out.println("forward direction cursor movement....");
					System.out.println("ROLL_NO\tNAME\tMARKS");
					while(rs.next()) {
						System.out.println(rs.getObject(1)+" "+rs.getObject(2)+" "+rs.getObject(3));
					}
				
					System.out.println("Application is paused , please update the database and here automatic update...");
					System.in.read();
					
					
					rs.beforeFirst();
					
					while(rs.next()) {
						// to get latest value using scroll sensitive
						rs.refreshRow();
						System.out.println(rs.getObject(1)+" "+rs.getObject(2)+" "+rs.getObject(3));
					}
					
					
					
					
				}
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
