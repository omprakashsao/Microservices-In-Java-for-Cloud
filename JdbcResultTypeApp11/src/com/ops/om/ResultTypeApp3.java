package com.ops.om;

import java.io.IOException;
import java.net.Socket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ops.utility.DBUtil;

public class ResultTypeApp3 {

	public static void main(String[] args) {
		
		try(Connection connection = DBUtil.getDBConnection()){
			
			try(Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)){
				try(ResultSet rs = stmt.executeQuery("select * from student")){
					// delete operation..
				    System.out.println("delete operation");
					rs.last();
					rs.deleteRow();
					System.out.println("row is deleted sucessfully..");
					
					System.out.println("update operation");
					while(rs.next()) {
						// Update operation using ResultSet
						int marks = rs.getInt(3);
						if(marks>=75) {
							marks = 99;
						}
						rs.updateInt(3, marks);
						rs.updateRow();
						
						
					}
					System.out.println("record update successfully...");
					
	
					// Insert operation using ResultSet
					/*
					rs.moveToInsertRow();
					rs.updateInt(1, 9011);
					rs.updateString(2, "aman sahu");
					rs.updateInt(3, 71);
					rs.insertRow();
				System.out.println("row updated successfully....");
				*/
				
				
					
				}
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
