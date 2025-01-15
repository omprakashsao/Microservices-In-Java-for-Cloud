package com.ops.om;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ops.utility.DBUtil;

public class ResultTypeApp1 {

	public static void main(String[] args) {
		
		try(Connection connection = DBUtil.getDBConnection()){
			
			try(Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)){
				try(ResultSet rs = stmt.executeQuery("select * from student")){
					System.out.println("forward direction cursor movement....");
					System.out.println("ROLL_NO\tNAME\tMARKS");
					while(rs.next()) {
						System.out.println(rs.getObject(1)+" "+rs.getObject(2)+" "+rs.getObject(3));
					}
					System.out.println();
					System.out.println("backward direction cursor movement....");
					System.out.println("ROLL_NO\tNAME\tMARKS");
					
					while(rs.previous()) {
						System.out.println(rs.getObject(1)+" "+rs.getObject(2)+" "+rs.getObject(3));
					}
					
					System.out.println();
					//first record
					rs.first();
					System.out.println(rs.getObject(1)+" "+rs.getObject(2)+" "+rs.getObject(3));
					
					System.out.println();
					//last record
					rs.last();
					System.out.println(rs.getObject(1)+" "+rs.getObject(2)+" "+rs.getObject(3));
					
					//cursor before first record
					rs.beforeFirst();
					// if execute below statement give exception because cursor is above of first record
				//	System.out.println(rs.getObject(1)+" "+rs.getObject(2)+" "+rs.getObject(3));
					
					//cursor after last record
					rs.afterLast();
					// similarly give exception
					//System.out.println(rs.getObject(1)+" "+rs.getObject(2)+" "+rs.getObject(3));
					
					rs.first();
					
					rs.absolute(5);// give 5th record from top(1st record)
					System.out.println(rs.getObject(1)+" "+rs.getObject(2)+" "+rs.getObject(3));
					
					rs.absolute(-5);// give 5th record from bottom (last record)
					System.out.println(rs.getObject(1)+" "+rs.getObject(2)+" "+rs.getObject(3));
					
					
					//current curson position --> 5th record from bottom
					rs.relative(4);//go to after 5th record from current cursor position (suppose current position 2 then 2+5=7)
					System.out.println(rs.getObject(1)+" "+rs.getObject(2)+" "+rs.getObject(3));
					
					//current cursor position : 3 rd record from top
					rs.relative(-4);// go to upward at 5 th record from current cursor position
					System.out.println(rs.getObject(1)+" "+rs.getObject(2)+" "+rs.getObject(3));
					
					rs.beforeFirst();
					
					System.out.println("cursor pointing to the first row :: "+ rs.isFirst());
					System.out.println("cursor pointing to the last row :: "+ rs.isLast());
					System.out.println("cursor pointing to the before first row :: "+ rs.isBeforeFirst());
					rs.afterLast();
					System.out.println("cursor pointing to the after last row :: "+ rs.isAfterLast());
					
				}
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
