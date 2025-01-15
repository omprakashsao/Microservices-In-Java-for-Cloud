package in.ops.om.main;

import java.io.BufferedReader;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ops.om.bean.Student;
import in.ops.om.util.HibernateUtil;

public class DeleteRecord {

	
	public static void main(String[] args) {
		
		Transaction transaction = null;
		
		Integer sid = null;
		Student std = null;
		Scanner scan =null;
		boolean flag = false;
		Session session = null;
		
		try {
			
			 session = HibernateUtil.getSession();
			
		     if(session!= null) {
		    	  scan = new Scanner(System.in);
		    	 System.out.println("Enter the sid ...");
		    	  sid = scan.nextInt();
		     }
		     if(sid != null) {
		    	 std = session.get(Student.class, sid);
		    	  transaction = session.beginTransaction();
		     }
		     if(std != null &&  transaction != null  ) {
		    	 session.delete(std);
		    	 flag= true;
		     }else {
		    	 System.out.println("Record is not found for id : "+sid);
		     }
			
		} catch(HibernateException he) {
			he.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(flag) {
				transaction.commit();
				System.out.println("Record is successfully deleted for id"+ sid);
			}else {
				transaction.rollback();
			}
			
			if(session!= null) {
				session.close();
			}
			HibernateUtil.closeSessionFactory();
		}
			// TODO: handle exception
		}


}
