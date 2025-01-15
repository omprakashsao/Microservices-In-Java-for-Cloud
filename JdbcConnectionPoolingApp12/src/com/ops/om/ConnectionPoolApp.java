package com.ops.om;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ops.utility.DBUtil;

public class ConnectionPoolApp {

	public static void main(String[] args) {
		try(Connection connection = DBUtil.getDBConnection()){
			try(Statement stmt = connection.createStatement()){
				try(ResultSet rs =stmt.executeQuery("select * from student")){
					while(rs.next()) {
						System.out.println(rs.getObject(1)+"\t"+rs.getObject(2)+"\t"+rs.getObject(3));
					}
				}
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
