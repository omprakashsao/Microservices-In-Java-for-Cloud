package in.ops.om.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.ops.om.bean.BankAccount;
import in.ops.om.bean.Card_Payment;
import in.ops.om.bean.ChequePayment;
import in.ops.om.bean.Employee;
import in.ops.om.bean.Payment;
import in.ops.om.bean.Student_Component;




public class HibernateUtil {
	
	static SessionFactory sessionFactory = null;

	static {
		  sessionFactory = new Configuration()
				  			.configure()
				  			.addAnnotatedClass(Payment.class)
				  			.addAnnotatedClass(Card_Payment.class)
				  			.addAnnotatedClass(ChequePayment.class)
				  			.buildSessionFactory();
		 
		 
		
	}
	
	public static Session getSession() {
		
		Session  session = null;
		if(sessionFactory != null) {
		session = sessionFactory.openSession();
		}
		
		return session;
	}
	
	public static void closeSessionFactory() {
		if(sessionFactory != null) {
			sessionFactory.close();
		}
	}

}
