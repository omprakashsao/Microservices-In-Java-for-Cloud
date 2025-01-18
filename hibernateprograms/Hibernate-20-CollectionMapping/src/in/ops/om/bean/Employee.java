package in.ops.om.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.ListIndexBase;



@Entity
@Table(name="Employee_Collection")

public class Employee implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer eid;
	private String name;
	private Integer age;
	
	@ElementCollection
	@Column(name = "names")
	@CollectionTable(name="Emp_Friends_List" , joinColumns = @JoinColumn(referencedColumnName = "eid", name="e_id"))
	@OrderColumn(name = "fid")
	@ListIndexBase(value = 1)
	private List<String> friends;
	
	@ElementCollection
	@Column(name= "ph_no")
	@CollectionTable(name="Emp_phone" , joinColumns = @JoinColumn(referencedColumnName = "eid", name="emp_id"))
	private Set<Long> phoneNumbers;
	
//	@ElementCollection
//	@Column(name="accNo")
//	@CollectionTable(name="Emp_bank" , joinColumns = @JoinColumn(referencedColumnName = "eid", name="emp_id"))
//	@MapKey(name="bankName")
//	private Map<String , Long> bankAccounts;
	
	public Employee( String name, Integer age, List<String> friends, Set<Long> phoneNumbers) {	
		this.name = name;
		this.age = age;
		this.friends = friends;
		this.phoneNumbers = phoneNumbers;
	}

	

	public Set<Long> getPhoneNumbers() {
		return phoneNumbers;
	}

//	public Employee(String name, Integer age, List<String> friends, Set<Long> phoneNumbers,Map<String, Long> bankAccounts) {
//
//	this.name = name;
//	this.age = age;
//	this.friends = friends;
//	this.phoneNumbers = phoneNumbers;
//	this.bankAccounts = bankAccounts;
//}

	public void setPhoneNumbers(Set<Long> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public Employee() {
		System.out.println("Employee object is created by Zero param constructor...");
	}

	public Employee(String name, Integer age, List<String> friends) {
		this.name = name;
		this.age = age;
		this.friends = friends;
	}

	

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public List<String> getFriends() {
		return friends;
	}

	public void setFriends(List<String> friends) {
		this.friends = friends;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", name=" + name + ", age=" + age + ", friends=" + friends + ", phoneNumbers="
				+ phoneNumbers + "]";
	}
	
	
	
	

}
