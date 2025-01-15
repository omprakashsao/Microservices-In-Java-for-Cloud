package in.ops.om.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ops.om.bean.Student;
import in.ops.om.util.HibernateUtil;

public class SynchronizationObjectToRecord {

	public static void main(String[] args) {
		
		Session session = null;
		Student std = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			 session = HibernateUtil.getSession();
			
			 if(session!= null) {
				 
				  std = session.get(Student.class, 2);
				  System.out.println("Befor Modification...");
				  System.out.println(std);
				  
				  System.in.read();
				  if(std!= null) {
					   transaction = session.beginTransaction();  
				  }
				  
				  if(transaction!= null) {
					   std.setSname("SauravSinha");
					   flag = true;
				   }
			 }
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if(flag) {
				transaction.commit();
				System.out.println("After modification");
				System.out.println(std);
			}
			if(session!= null) {
				session.close();
			}
			HibernateUtil.closeSessionFactory();
		}
		
	}

}
