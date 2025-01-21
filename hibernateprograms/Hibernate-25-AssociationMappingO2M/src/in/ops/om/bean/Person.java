package in.ops.om.bean;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "PERSON_ONE_TO_MANY")
public class Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pid;
	private String pname;
	private String paddress;
	
	@OneToMany(targetEntity = PhoneNumber.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "person_id", referencedColumnName = "pid")
	private Set<PhoneNumber> number;
	
	
	
	public Set<PhoneNumber> getNumber() {
		return number;
	}
	public void setNumber(Set<PhoneNumber> number) {
		this.number = number;
	}
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
	public String getPaddress() {
		return paddress;
	}
	public void setPaddress(String paddress) {
		this.paddress = paddress;
	}
	
	
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", paddress=" + paddress + ", number=" + number + "]";
	}
	
	
	
	

}
