package com.ops.service;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import org.apache.commons.beanutils.BeanUtils;

import com.ops.dto.StudentBo;
import com.ops.dto.StudentDto;
import com.ops.factory.StudentRepoFactory;
import com.ops.repository.IStudentRepoImpl;

public class IStudentServiceImpl implements IStudentService {

	


@Override
public String insertRecord(StudentDto sdto) throws SQLException {
	// TODO Auto-generated method stub
	 StudentBo sbo= null;
	IStudentRepoImpl obj = null; 
	
	sbo = new StudentBo();
	 obj =StudentRepoFactory.getStudentRepo();
	 
	 sbo.setMarks(sdto.getMarks());
	 sbo.setName(sdto.getName());
	 sbo.setRoll_no(sdto.getRoll_no());
	 
	 if(sdto.getMarks() >= 60) {
		 sbo.setStatus("****PASS******");
	 }
	 else {
		 sbo.setStatus("----FAIL-----");
	 }
	 
	 String status = obj.insertRecord(sbo);
	 
	 if(status.equalsIgnoreCase("success")) {
		 return status;
	 }
	 else {
		 status = "insertion failed with return 0";
	 }
	 
	
	
	return status;
}

@Override
public StudentDto readRecord(int sid) {
	// TODO Auto-generated method stub
	
	IStudentRepoImpl repo = StudentRepoFactory.getStudentRepo();
	StudentBo sbo = repo.readRecord(sid);
	
	StudentDto sdto = null;
	
	sdto = new StudentDto();
	
	try {
		BeanUtils.copyProperties(sdto, sbo);
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InvocationTargetException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return sdto;
}

@Override
public String deleteRecord(Integer sid) {
	// TODO Auto-generated method stub
	
	IStudentRepoImpl repo = StudentRepoFactory.getStudentRepo();
	String status = repo.deleteRecord(sid);
	return status;
}

@Override
public String updateRecord(StudentDto sdto) {
	// TODO Auto-generated method stub
	
	IStudentRepoImpl repo = StudentRepoFactory.getStudentRepo();
	StudentBo sbo = null;
	sbo = new StudentBo();
	try {
		BeanUtils.copyProperties(sbo, sdto);
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InvocationTargetException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	String status = repo.updateRecord(sbo);
	
	return  status;
}
	

}
