package com.ops.repository;

import java.sql.SQLException;

import com.ops.dto.StudentBo;
import com.ops.dto.StudentDto;

public interface IStudentRepo {

	  //Create 
	  // Read
	  // Update
	  // Delete
	
	  public String insertRecord(StudentBo sbo) throws SQLException;
	  public StudentBo readRecord(int sid);
	  public String deleteRecord(Integer sid);
	  public String updateRecord(StudentBo sbo);
	  
	  
}
