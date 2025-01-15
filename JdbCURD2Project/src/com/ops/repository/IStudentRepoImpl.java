package com.ops.repository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ops.dto.StudentBo;
import com.ops.dto.StudentDto;
import com.ops.utility.JdbcUtil;

public class IStudentRepoImpl implements IStudentRepo {
	
		private static final String SQL_SELECT_QUERY = "select name,marks,roll_no from student where sid = ?";
		private static final String SQL_DELETE_QUERY = "delete from student where sid=?";
		private static final String SQL_UPDATE_QUERY = "UPDATE student SET name = ? , marks = ?, roll_no = ? WHERE sid = ?";
		static Connection connection = null;	
		PreparedStatement pstmt =null;
		static PreparedStatement selectPstmt = null;
		static PreparedStatement deletePstmt = null;
		static PreparedStatement updatePstmt = null;
	private final String SQL_INSERT_QUERY = "insert into student(`name` , `marks`, `roll_no`) values(?,?,?)";
	
	static {
		try {
			connection = JdbcUtil.getDBConnection();
			
			if(connection != null) {
				 selectPstmt = connection.prepareStatement(SQL_SELECT_QUERY);
			}
			
			if(connection != null) {
				 deletePstmt = connection.prepareStatement(SQL_DELETE_QUERY);
			}
			
			if(connection != null) {
				 updatePstmt = connection.prepareStatement(SQL_UPDATE_QUERY);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String insertRecord(StudentBo sbo) throws SQLException {
		// TODO Auto-generated method stub
		
		String status = "null";
		if(connection != null) {
			pstmt = connection.prepareStatement(SQL_INSERT_QUERY);
			
			pstmt.setString(1, sbo.getName());
			pstmt.setInt(2, sbo.getMarks() );
			pstmt.setInt(3, sbo.getRoll_no());
		}
		
		int flag = pstmt.executeUpdate();
		
		if(flag==1) {
			status = "success";
					
		}else {
			status = "insertion failure";
		}
		 	
		return status;
	}

	@Override
	public StudentBo readRecord(int sid) {
		StudentBo sbo = null;
		// TODO Auto-generated method stub
		try {
			selectPstmt.setInt(1, sid);
			
			ResultSet rs = selectPstmt.executeQuery();
			while(rs.next()) {
				
				sbo = new StudentBo();
				sbo.setName(rs.getString(1));
				sbo.setMarks(rs.getInt(2));
				sbo.setRoll_no(rs.getInt(3));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sbo;
	}

	@Override
	public String deleteRecord(Integer sid) {
		// TODO Auto-generated method stub
		String status = "No data";
		try {
			deletePstmt.setInt(1, sid);
			int rowCount = deletePstmt.executeUpdate();
			if(rowCount == 1) {
				status = "student information is deleted successfully";
			}
			else {
				status = "some error due data is not deleted...";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String updateRecord(StudentBo sbo) {
		// TODO Auto-generated method stub
		String status = "null";
		try {
			updatePstmt.setString(1, sbo.getName());
			updatePstmt.setInt(2, sbo.getMarks());
			updatePstmt.setInt(3, sbo.getRoll_no());
			updatePstmt.setInt(4, sbo.getSid());
			
			int rowCount = updatePstmt.executeUpdate();
			if(rowCount == 1) {
			status = "success";
			}else {
				status = "updation failure";
						
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}



}
