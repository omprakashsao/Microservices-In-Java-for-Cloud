package com.ops;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.ops.controller.IStudentController;
import com.ops.dto.StudentDto;
import com.ops.dto.StudentVo;
import com.ops.factory.StudentControllerFactory;

public class MainAppJdbc {

   public static void main(String[] args) throws IOException {
	 
	
	   IStudentController controller = StudentControllerFactory.getStudentController();
	   
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	   
	   System.out.println("SELECT YOUR OPTION");
	   System.out.println("1. INSERT");
	   System.out.println("2. READ");
	   System.out.println("3. DELETE");
	   System.out.println("4. UPDATE");
	   System.out.println("5. EXIT");
	   System.out.println("SECLE ANY CHOICE BY [1/2/3/4/5]:: " );
	   String option = br.readLine();
	   
	   switch(option) {
	   case "1" : insertRecord(br, controller);
	   break;
	   case "2" : readRecord(br,controller);
	   break;
	   case "3" : deleteRecord(br,controller);
	   break;
	   case "4" : updateRecord(br, controller);
	   break;
	   case "5" : System.exit(0);
	   break;
	   }
	   
	   
	   
	   
	   
	  
}

   
private static void updateRecord(BufferedReader br, IStudentController controller) throws IOException {
	// TODO Auto-generated method stub
	
	System.out.println("Enter Your sid ");
	String sid = br.readLine();
	StudentVo svo = controller.readRecord(sid);
	
	String oldName = svo.getName();
	String oldMarks = svo.getMarks();
	String oldRoll_no = svo.getRoll_no();
	
	System.out.println("Your old_name is "+oldName + "Enter new name");
	String newName = br.readLine();
	if(newName.equals("") || newName == "") {
		svo.setName(oldName);
	}else {
		svo.setName(newName);
		
	}
	System.out.println("Your old_marks is "+oldMarks + "Enter new name");
	String newMarks = br.readLine();
	System.out.println("Your old_roll_no. is "+oldRoll_no + "Enter new name");
	String newRoll_no  = br.readLine();
	
	svo.setMarks(newMarks);
	svo.setRoll_no(newRoll_no);
	svo.setSid(sid);
	
	String status = controller.updateRecord(svo);
	if(status != null) {
		System.out.println("Record is updated successfully....");
	}
	else {
		System.out.println(status);
	}
	
	
	
	
	
	
	
}


private static void deleteRecord(BufferedReader br, IStudentController controller) throws IOException {
	// TODO Auto-generated method stub
	
	System.out.println("Enter your sid ");
	String id = br.readLine();
	
	StudentVo svo = controller.readRecord(id);
	if(svo != null) {
		 String status = controller.deleteRecord(id);
		 if(status.equalsIgnoreCase("success")) {
				status = "Information is inserted successfully.... --> application";
			}
			else {
				System.out.println(status);
			}
	}
}


private static void readRecord(BufferedReader br, IStudentController controller) throws IOException {
	// TODO Auto-generated method stub
	  
	System.out.println("Enter your sid ");
	String id = br.readLine();
	
	StudentVo svo = controller.readRecord(id);
	if(svo != null) {
		System.out.println(svo);
	}else {
		System.out.println("No data is available for sid "+id);
	}
	
	
    
}


private static void insertRecord(BufferedReader br, IStudentController controller) throws IOException {
	// TODO Auto-generated method stub
	
	System.out.println("Enter you name");
	String name = br.readLine();	
	
	System.out.println("Enter your roll_no");
	String roll_no = br.readLine();
	
	System.out.println("Enter your marks");
	String marks = br.readLine();
	
	StudentVo studentVo = new StudentVo();
	studentVo.setName(name);
	studentVo.setMarks(marks);
	studentVo.setRoll_no(roll_no);
	
	String status = controller.insertRecord(studentVo);
	if(status.equalsIgnoreCase("success")) {
		status = "Information is inserted successfully.... --> application";
	}
	else {
		System.out.println(status);
	}
		
}

}

