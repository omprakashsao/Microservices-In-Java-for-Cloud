package com.ops.om;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.ops.utility.DBUtil;

public class PassingMulitipleQueryUsingBatchwithPreparedStatement {

	private static final String SQL_INSERT_QUERY = "INSERT INTO STUDENT VALUES(?,?,?)";

	public static void main(String[] args) {
	
		try(Connection connection= DBUtil.getDBConnection()){
			
			try(PreparedStatement pStatement = connection.prepareStatement(SQL_INSERT_QUERY)){
				
				
				while(true) {
					Scanner sc = new Scanner(System.in);
					System.out.println("Enter the roll_no");
					int roll_no =sc.nextInt();
					
					System.out.println("Enter the name");
					String name= sc.next();
					
					System.out.println("Enter the marks");
					int marks = sc.nextInt();
					
					pStatement.setInt(1, roll_no);
					pStatement.setString(2, name);
					pStatement.setInt(3, marks);
					
					pStatement.addBatch();
					
					System.out.println("Do you want to enter one more record: {YES/NO}  = ");
					String option = sc.next();
					if(option.equalsIgnoreCase("no")) {
						break;
					}
						
					
				}
				pStatement.executeBatch();
				System.out.println("Record are inserted successfully.....");
				
				
			 
			  
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
