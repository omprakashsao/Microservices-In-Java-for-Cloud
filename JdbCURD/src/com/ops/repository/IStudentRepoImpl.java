package com.ops.repository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.ops.dto.Student;
import com.ops.utility.JdbcUtil;

public class IStudentRepoImpl implements IStudentRepo {

	private static Connection connection = null;
	
	static {
		     try {
				connection = JdbcUtil.getDBConnection();
			} catch (IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	@Override
	public int insertRecord(Student student) throws SQLException {
		// TODO Auto-generated method stub
		Statement stmt = null;
		if (connection  != null) {
			stmt =connection.createStatement();
		}
		String sqlQuery = null;
		
		sqlQuery = String.format("insert into student values(%d,'%s',%d)",student.getRoll_no(),student.getName(),student.getMarks());
		if(stmt != null  && sqlQuery != null)
		              return  stmt.executeUpdate(sqlQuery);
		
		
		return 0;
	}

}
