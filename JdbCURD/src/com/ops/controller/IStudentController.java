package com.ops.controller;

import java.sql.SQLException;

import com.ops.dto.Student;

public interface IStudentController {
	
	   //Create 
	  // Read
	  // Update
	  // Delete
	
	  public  int insertRecord(Student student) throws SQLException;

}
