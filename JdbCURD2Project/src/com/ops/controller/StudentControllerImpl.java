package com.ops.controller;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import org.apache.commons.beanutils.BeanUtils;

import com.ops.dto.StudentDto;
import com.ops.dto.StudentVo;
import com.ops.factory.StudentServiceFactory;
import com.ops.service.IStudentService;

public class StudentControllerImpl implements IStudentController {


	@Override
	public String insertRecord(StudentVo svo) {
		// TODO Auto-generated method stub
		
		StudentDto sdto = null;
		IStudentService service = null;
		
		// convert vo to dto 
		 sdto = new StudentDto();
		sdto.setName(svo.getName());
		sdto.setMarks(Integer.parseInt(svo.getMarks()));
		sdto.setRoll_no(Integer.parseInt(svo.getRoll_no()));
		
		String status = null;
		try {
			service = 	 StudentServiceFactory.getStudentService();
			 status = service.insertRecord(sdto);
			if(status.equalsIgnoreCase("success")) {
				status = "Information is inserted successfully....";
			}
			else {
				status = "Sorry insertion failure is occur..";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		return status;
	}

	@Override
	public StudentVo readRecord(String sid) {
		// TODO Auto-generated method stub
		
		IStudentService service = StudentServiceFactory.getStudentService();
		StudentDto sdto = service.readRecord(Integer.parseInt(sid));
		
	    StudentVo svo = null;
	    
	    svo = new StudentVo();
	    try {
			BeanUtils.copyProperties(svo, sdto);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return svo;
	}

	@Override
	public String deleteRecord(String sid) {
		// TODO Auto-generated method stub
		 IStudentService service = StudentServiceFactory.getStudentService();
		 String status = service.deleteRecord(Integer.parseInt(sid));
		return status;
	}

	@Override
	public String updateRecord(StudentVo svo) {
		// TODO Auto-generated method stub
		StudentDto sdto = null;
		IStudentService service = StudentServiceFactory.getStudentService();
		
		 sdto = new StudentDto();
		 try {
			BeanUtils.copyProperties(sdto, svo);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 String status = service.updateRecord(sdto);
		 
		
		return status;
	}
	

}
