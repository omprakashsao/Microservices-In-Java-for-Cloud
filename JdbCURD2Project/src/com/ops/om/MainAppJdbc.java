package com.ops.om;

import java.sql.SQLException;
import java.util.Scanner;

import com.ops.controller.IStudentController;
import com.ops.dto.StudentDto;
import com.ops.factory.StudentControllerFactory;

public class MainAppJdbc {

   public static void main(String[] args) {
	 
	   Scanner sc = null;
	   IStudentController controller = StudentControllerFactory.getStudentController();
	   StudentDto student = new StudentDto();
	   
	   sc = new Scanner(System.in);
	   
	  System.out.println("Enter the student roll no");
	  Integer roll_no = sc.nextInt();
	  
	  System.out.println("Enter the student name ");
	  String name  =sc.next();
	  
	   System.out.println("Enter marks");
	   Integer marks = sc.nextInt();
	   
	   student.setRoll_no(roll_no);
	   student.setName(name);
	   student.setMarks(marks);
	   
	   try {
		System.out.println("No of rows inserted is :: "+controller.insertRecord(student));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("Row is not inserted...");
	}
	   
	   sc.close();
}

}
