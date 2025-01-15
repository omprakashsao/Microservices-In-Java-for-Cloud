package com.ops.om;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;

import com.ops.utility.DBUtil;


public class MainApp {

	private static final String SQL_INSERT_QUERY = "insert into accout_info(`accno`,`address`,`balance`) values(?,?,?)";
	

	//private static final String SQL_SELECT_QUERY = "select `name`,`photo` from person where id = ?";

	public static void main(String[] args) {
		
		Connection indianConnection = null;
		Connection elahabadConnection = null;
		PreparedStatement pstmt = null;
	    Statement stmt = null;
		ResultSet rs = null;
		Scanner sc = null;
		 int rowCount =0;
		
		 try {
			      elahabadConnection = DBUtil.getelahabadDBConnection();
			      indianConnection = DBUtil.getIndianDBConnection();
			      
			      if (elahabadConnection !=  null)
			    	  stmt =elahabadConnection.createStatement();
			      
			      if(indianConnection != null)
			    	  pstmt = indianConnection.prepareStatement(SQL_INSERT_QUERY );
			      
			      if(stmt!=null) {
			    	  String selectQuery = "select  accno,address,balance from acc_info";
					     rs=stmt.executeQuery(selectQuery);   	 
			      }
			      
			      while(rs.next()) {
			    	  if(pstmt!= null) {
				    	  pstmt.setInt(1, (int) rs.getObject(1));
				    	  pstmt.setString(2, (String) rs.getObject(2));
				    	  pstmt.setInt(3, (int) rs.getObject(3));
				    	  
				    	  rowCount =pstmt.executeUpdate();
				    	  
				      }
			      }
			      if(rowCount==0) {
			    	  System.out.println("isertion failure....");
			      }
			      else {
			    	  System.out.println("elahabad db successfully merged with indianbank");
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
			DBUtil.cleanUpResources(rs, pstmt, indianConnection);
		   if(sc!= null)
			   sc.close();
		}

	}

	/*
	 * private static String converToImage(InputStream binaryStream) throws
	 * IOException {
	 * 
	 * String location = "download.jpg"; FileOutputStream fos = new
	 * FileOutputStream(location); byte[] b =new byte[1024];
	 * while(binaryStream.read(b)>0) { fos.write(b); } fos.flush(); fos.close();
	 * binaryStream. close();
	 * 
	 * // int data =binaryStream.read(); // while(data!= -1) { // fos.write(data);
	 * // data = binaryStream.read(); // }
	 * 
	 * return "sucessfully downloaded"; }
	 */

	

}
