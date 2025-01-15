package com.ops.dto;

public class StudentVo {



	private String  roll_no ;
	private String name ;
	private String  marks;
	private  String  sid;
	

	public String getRoll_no() {
		return roll_no;
	}

	public void setRoll_no(String roll_no) {
		this.roll_no = roll_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMarks() {
		return marks;
	}

	public void setMarks(String marks) {
		this.marks = marks;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	@Override
	public String toString() {
		return "StudentDto [sid=" + sid + ", roll_no=" + roll_no + ", name=" + name + ", marks=" + marks + "]";
	}


	
	
	
}
