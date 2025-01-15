package in.ops.om.main;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import in.ops.om.bean.Student;
import in.ops.om.util.HibernateUtil;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Configuration configuration = new Configuration();
//		configuration.configure();
//		
//		SessionFactory sessionFactory = configuration.buildSessionFactory();
//		Session session = sessionFactory.openSession();
//		Transaction transaction = session.beginTransaction();
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		
		try {
			session = HibernateUtil.getSession();
			if(session!=null)
				transaction = session.beginTransaction();
			
			if(transaction != null) {
//				
				Student student = new Student();
				student.setSname("Ram sukhdev");
				student.setSage(22);
				student.setSaddress("Bhopal");
				
				Serializable id = session.save(student);
				flag= true;
//				System.out.println("record is save sucessfully which id is : "+id);
			}
			
			
			
		}catch(HibernateException he) {
			he.printStackTrace();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(flag) {
				transaction.commit();
			}else {
				transaction.rollback();
			}
			HibernateUtil.closeSessionFactory();
		}
		

	}

}
