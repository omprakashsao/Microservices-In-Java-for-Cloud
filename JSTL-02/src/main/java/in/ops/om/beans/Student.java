package in.ops.om.beans;

public class Student {

	
	private Integer sid;
	private String sname;
	private Integer sage;
	
	
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String saname) {
		this.sname = saname;
	}
	public Integer getSage() {
		return sage;
	}
	public void setSage(Integer sage) {
		this.sage = sage;
	}
	
	public Student(Integer sid, String sname, Integer sage) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sage = sage;
		System.out.println("Student construtor is called..");
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", sage=" + sage + "]";
	}
	
	

}
