package com.ops.factory;

import com.ops.service.IStudentService;
import com.ops.service.IStudentServiceImpl;

public class StudentServiceFactory {
	
	private static IStudentService service = null;

	public static IStudentService getStudentService() {
		if(service == null)
			service = new IStudentServiceImpl();
		
		return service;
	}
}
