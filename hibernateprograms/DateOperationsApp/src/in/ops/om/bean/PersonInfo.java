package in.ops.om.bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.annotation.processing.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person_info")
public class PersonInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="PID")
	@GeneratedValue( strategy = GenerationType.AUTO)
	private Integer pid;
	
	@Column(name = "PNAME")
	private String pname;
	
	@Column(name= "PADDR")
	private String paddr;
	
	@Column(name = "DOB")
	private LocalDateTime dob;
	
	@Column(name = "DOM")
	private LocalDate dom;
	
	@Column(name = "DOJ")
	private LocalTime doj;
	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPaddr() {
		return paddr;
	}
	public void setPaddr(String paddr) {
		this.paddr = paddr;
	}
	public LocalDateTime getDob() {
		return dob;
	}
	public void setDob(LocalDateTime dob) {
		this.dob = dob;
	}
	public LocalDate getDom() {
		return dom;
	}
	public void setDom(LocalDate dom) {
		this.dom = dom;
	}
	public LocalTime getDoj() {
		return doj;
	}
	public void setDoj(LocalTime doj) {
		this.doj = doj;
	}
	
	@Override
	public String toString() {
		return "PersonInfo [pid=" + pid + ", pname=" + pname + ", paddr=" + paddr + ", dob=" + dob + ", dom=" + dom
				+ ", doj=" + doj + "]";
	}
	
	

}
