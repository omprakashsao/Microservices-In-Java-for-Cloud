package com.ops.repository;

import java.sql.SQLException;

import com.ops.dto.Student;

public interface IStudentRepo {

	  //Create 
	  // Read
	  // Update
	  // Delete
	
	  public  int insertRecord(Student student) throws SQLException;
	  
	  
}
