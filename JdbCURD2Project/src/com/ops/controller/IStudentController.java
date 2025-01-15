package com.ops.controller;

import java.sql.SQLException;

import com.ops.dto.StudentVo;

public interface IStudentController {
	
	   //Create 
	  // Read
	  // Update
	  // Delete
	
	 // public  int insertRecord(StudentDto student) throws SQLException;
         public String insertRecord(StudentVo studentvo) ;
         public StudentVo readRecord(String sid);
         public String deleteRecord(String sid);
         public String updateRecord(StudentVo svo);
         
}
