package com.ops.dto;

public class StudentBo {

	private Integer sid;
    private Integer  roll_no ;
	private String name ;
	private Integer marks;
	private String status;
	
	public Integer getSid() {
		return sid;
	}
	
	
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	
	public Integer getRoll_no() {
		return roll_no;
	}


	public void setRoll_no(Integer roll_no) {
		this.roll_no = roll_no;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getMarks() {
		return marks;
	}


	public void setMarks(Integer marks) {
		this.marks = marks;
	}


	@Override
	public String toString() {
		return "StudentBo [sid=" + sid + ", roll_no=" + roll_no + ", name=" + name + ", marks=" + marks + ", status="
				+ status + "]";
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	


	
	
	
}
