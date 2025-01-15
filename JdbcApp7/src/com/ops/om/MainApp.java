package com.ops.om;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;

import com.ops.utility.DBUtil;


public class MainApp {

	private static final String SQL_SELECT_QUERY = "select `name`,`photo` from person where id = ?";

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
            	 // API  CODE from adding apache common io jar file
            	 System.out.println(id+"\t"+rs.getObject(1)+"\t"+IOUtils.copy(rs.getBinaryStream(2), new FileOutputStream("download1.jpg"))+"\t");
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
