--------------package in.ops.om.main;

import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import in.ops.om.bean.Student;
import in.ops.om.util.HibernateUtil;

public class LoadRecordApp {

	public static void main(String[] args) {
	
		Session session = null;
//		Student std = null;
		
		Integer sid = null;
		
		try {
			session = HibernateUtil.getSession();
	
			try (Scanner scan = new Scanner(System.in)) {
				System.out.println("Enter the sid for get record...");
				sid = scan.nextInt();
			}
			Student std1 = session.get(Student.class, sid);
			// clearing session chache 
//			session.clear();
			
			//clearing std1 object from sesssion chache
			session.evict(std1);
			
			Student std3 = session.get(Student.class, 8);
			Student std2 = session.get(Student.class, sid);
//			if(std!=null) {
//				System.out.println("student name"+std.getSname());
//				System.out.println("student Age "+std.getSage());
//				System.out.println("student Address"+std.getSaddress());
//				System.out.println("student id "+std.getSid());
//			}else {
//				System.out.println("Record is not found for id :: "+ sid );
//			}
			
			
			System.out.println(std1+"hashCode value is : "+std1.hashCode());
			System.out.println(std2+"hashCode value is : "+std2.hashCode());
			System.out.println(std3+"hashCode value is : "+std3.hashCode());
			
			
		}catch(HibernateException he) {
			he.printStackTrace();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			
			if(session!=null) {
				session.close();
				}
			HibernateUtil.closeSessionFactory();
		}
		

	


	}

}
