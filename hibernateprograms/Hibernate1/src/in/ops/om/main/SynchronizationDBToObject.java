package in.ops.om.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ops.om.bean.Student;
import in.ops.om.util.HibernateUtil;

public class SynchronizationDBToObject {


	public static void main(String[] args) {
		
		Session session = null;
		Student std = null;
		
		try {
			 session = HibernateUtil.getSession();
			
			if(session!= null) {
				 std = session.get(Student.class, 1);
				 System.out.println("Before Modificaiton...");
				 System.out.println(std);
				 
				 //Application pause
				 System.in.read();
				 
				 session.refresh(std);
				 System.out.println("After Modificaiton...");
				 System.out.println(std);
				 
			}
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			
			if(session!= null) {
				session.close();
			}
			HibernateUtil.closeSessionFactory();
		}
		
	}

	
}
