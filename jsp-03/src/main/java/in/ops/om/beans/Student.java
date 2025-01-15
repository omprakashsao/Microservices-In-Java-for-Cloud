package in.ops.om.beans;

public class Student {
	
	private String name;
	private Integer age;
	private String address;
	
	static {
      System.out.println("Student.class file is loading....");
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", address=" + address + "]";
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



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public Student() {
		// TODO Auto-generated constructor stub
		System.out.println("Student object is created...");
	}

}
