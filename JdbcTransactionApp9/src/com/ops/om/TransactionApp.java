package com.ops.om;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.ops.utility.DBUtil;

public class TransactionApp {

	public static void main(String[] args) {
	
		
		try(Connection connection = DBUtil.getDBConnection()){
			try(Statement stmt = connection.createStatement()){
				System.out.println("Account Balance before transaction");
				try(ResultSet rs = stmt.executeQuery("select * from empolyee_acc")){
					
					while(rs.next()) {
						System.out.println(rs.getObject(2)+"  "+rs.getObject(3));
					}
				}
				
				//transaction begins
				System.out.println("**********Transaction begins**************");
				
				connection.setAutoCommit(false);
				
				stmt.executeUpdate("update empolyee_acc set balance = balance -1000 where name = 'om'");
				stmt.executeUpdate("update empolyee_acc set balance = balance +1000 where name = 'neeraj'");
				
				System.out.println("Do you want to transaction type [YES/NO]:  ");
				Scanner sc = new Scanner(System.in);
				String option = sc.next();
				if(option.equalsIgnoreCase("yes")) {
					connection.commit();
					System.out.println("transaction commited....");
				}
				else {
					connection.rollback();
					System.out.println("transaction rollback.....");
				}
				
				System.out.println("Account Balance after transaction");
				
              try(ResultSet rs = stmt.executeQuery("select * from empolyee_acc")){
					
					while(rs.next()) {
						System.out.println(rs.getObject(2)+"  "+rs.getObject(3));
					}
				}
				       
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
