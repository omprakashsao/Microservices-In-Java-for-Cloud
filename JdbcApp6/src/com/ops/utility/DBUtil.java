package com.ops.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public final class DBUtil {
       
	 private DBUtil() {}
	  static  Properties p;
	 static {
		 FileInputStream fis = null;
		 try {
			 //1 establish connection b/w java application and database
			fis = new FileInputStream("D:\\All Eclips Project\\JdbcApp6\\src\\com\\ops\\properties\\database.properties");
			if(fis!= null) {
				p = new Properties();
				p.load(fis);	
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }
	 public static Connection getIndianDBConnection() throws IOException, SQLException {
		  return DriverManager.getConnection(p.getProperty("indianbank_url"), p.getProperty("user"),p.getProperty("password"));
	 }
	 public static Connection getelahabadDBConnection() throws IOException, SQLException {
		  return DriverManager.getConnection(p.getProperty("elahabadbank_url"), p.getProperty("user"),p.getProperty("password"));
	 }
	 
	 public static void cleanUpResources(ResultSet rs, Statement  stmt , Connection connection) {
		 if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	 }
}
