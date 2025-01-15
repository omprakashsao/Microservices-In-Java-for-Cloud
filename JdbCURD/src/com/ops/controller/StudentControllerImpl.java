package com.ops.controller;

import java.sql.SQLException;

import com.ops.dto.Student;
import com.ops.factory.StudentServiceFactory;
import com.ops.service.IStudentService;

public class StudentControllerImpl implements IStudentController {

    IStudentService service = 	 StudentServiceFactory.getStudentService();
	@Override
	public int insertRecord(Student student) throws SQLException {

		
			int rowAffected = service.insertRecord(student);
			return rowAffected;
		
		
	}

}
