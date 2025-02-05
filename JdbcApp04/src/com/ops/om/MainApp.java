package com.ops.om;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.ops.utility.DBUtil;


public class MainApp {

	private static final String SQL_SELECT_QUERY = "select `username`,`dob` from users where id = ?";

	public static void main(String[] args) {
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner sc = null;
		
		
		 try {
			 
             connection = DBUtil.getDBConnection();
			 
             if(connection != null) {
            	pstmt =  connection.prepareStatement(SQL_SELECT_QUERY);
             }
             sc = new Scanner(System.in);
             System.out.println("Enter the id ");
             
			int id = sc.nextInt();
             
             pstmt.setInt(1, id);
             
             if(pstmt!= null && sc != null)
              rs =pstmt.executeQuery();
             
          
             
             System.out.println("id\tusername\tdob");
             while(rs.next()) {
            	 System.out.println(id+"\t"+rs.getObject(1)+"\t"+converToString(rs.getObject(2))+"\t");
             }
//             else {
//            	 System.out.println("record not found...");
//             }
             
	          
			 
			 
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}  finally {
			DBUtil.cleanUpResources(rs, pstmt, connection);
		   if(sc!= null)
			   sc.close();
		}

	}

	private static String converToString(Object object) {
		// TODO Auto-generated method stub
		SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
		return s.format(object);
	
	}

}
