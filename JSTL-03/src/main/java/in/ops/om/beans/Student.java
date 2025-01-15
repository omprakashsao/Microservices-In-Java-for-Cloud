package in.ops.om.beans;

public class Student {

	
	private Integer sid;
	private String sname;
	private Integer sage;
	private String saddress;
	
	
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
	
	public Student(Integer sid, String sname, Integer sage, String saddress) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sage = sage;
		this.saddress= saddress;
		System.out.println("Student construtor is called..");
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", sage=" + sage + ", saddress=" + saddress + "]";
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	
	

}
