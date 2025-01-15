package com.ops.service;

import java.sql.SQLException;

import com.ops.dto.Student;

public interface IStudentService {
	
	public int insertRecord(Student student) throws SQLException;

}
