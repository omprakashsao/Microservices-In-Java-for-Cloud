package com.ops.factory;

import com.ops.repository.IStudentRepoImpl;

public class StudentRepoFactory {

	private static IStudentRepoImpl studentRepo = null;
	
	public static IStudentRepoImpl getStudentRepo() {
		if(studentRepo == null)
			studentRepo = new IStudentRepoImpl();
		
			return studentRepo;
	}
}
