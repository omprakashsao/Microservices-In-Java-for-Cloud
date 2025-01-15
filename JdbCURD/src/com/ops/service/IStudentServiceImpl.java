package com.ops.service;

import java.sql.SQLException;

import com.ops.dto.Student;
import com.ops.factory.StudentRepoFactory;
import com.ops.repository.IStudentRepoImpl;

public class IStudentServiceImpl implements IStudentService {

	
  IStudentRepoImpl obj =  StudentRepoFactory.getStudentRepo();
	@Override
	public int insertRecord(Student student) throws SQLException {
		// TODO Auto-generated method stub
	
			return obj.insertRecord(student);
	
		
		
	}

}
