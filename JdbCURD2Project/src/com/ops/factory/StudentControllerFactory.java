package com.ops.factory;

import com.ops.controller.IStudentController;
import com.ops.controller.StudentControllerImpl;

public class StudentControllerFactory {

	    private static IStudentController  controller= null;
	    
	    public static IStudentController getStudentController() {
	    	if(controller == null)
	    		controller = new StudentControllerImpl();
	    		
	    	return controller;
	    }
	    
}
