package com.ops.om;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


import com.ops.utility.DBUtil;


public class MainApp {

	public static void main(String[] args) {
		
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		
		 try {
			 
             connection = DBUtil.getDBConnection();
			 System.out.println("Connection established  : "+connection.getClass().getName());
			  
	       
			 stmt = connection.createStatement();
	         rs = stmt.executeQuery("select roll_no,name,marks from student");
	        System.out.println("roll_no\tname\t\t\tmarks");
	        while(rs.next()) {
	        	System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getInt(3));
	        }
	          
			 
			 
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}  finally {
			DBUtil.cleanUpResources(rs, stmt, connection);
		}

	}

}
