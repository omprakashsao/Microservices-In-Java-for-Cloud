package com.ops.om;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.ops.utility.DBUtil;

public class PassingMulitipleQueryUsingBatch {

	public static void main(String[] args) {
	
		try(Connection connection= DBUtil.getDBConnection()){
			
			try(Statement statement = connection.createStatement()){
				
				statement.addBatch("insert into student(`roll_no`,`name`,`marks`) values(009005,'jhk',68)");
				statement.addBatch("update student set marks = marks+10 where marks <=78");
			    statement.addBatch("delete from student where marks =90");
				
			    int[] arr = statement.executeBatch();
			    int rowCount = 0;
			    for (int i : arr) {
					rowCount +=  i;
				}
			    System.out.println("rows are affected is : "+ rowCount);
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
