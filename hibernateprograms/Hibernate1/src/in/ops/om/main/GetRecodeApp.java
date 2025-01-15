package in.ops.om.main;

import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import in.ops.om.bean.Student;
import in.ops.om.util.HibernateUtil;

public class GetRecodeApp {

	public static void main(String[] args) {
	
		Session session = null;
		Student std = null;
		
		Integer sid = null;
		
		try {
			session = HibernateUtil.getSession();
	
			try (Scanner scan = new Scanner(System.in)) {
				System.out.println("Enter the sid for get record...");
				sid = scan.nextInt();
			}
			 std = session.load(Student.class, sid);
			
             System.out.println(std);
            
           
//           if(std!= null) {
//        	
//               System.out.println("Name : "+std.getSname());
//               System.out.println("Age  : "+ std.getSage());
//               System.out.println("Saddress : "+ std.getSaddress());
//           }else {
//        	   System.out.println("Record is not found..");
//           }
		
         
			
			
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
