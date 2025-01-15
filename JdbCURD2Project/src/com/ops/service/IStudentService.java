package com.ops.service;

import java.sql.SQLException;

import com.ops.dto.StudentDto;
import com.ops.dto.StudentVo;

public interface IStudentService {
	
	//public int insertRecord(StudentDto student) throws SQLException;
	  public String insertRecord(StudentDto sdto) throws SQLException  ;
	  public StudentDto readRecord( int sid );
	  public String deleteRecord(Integer sid);
	  public String updateRecord(StudentDto sdto);
}
