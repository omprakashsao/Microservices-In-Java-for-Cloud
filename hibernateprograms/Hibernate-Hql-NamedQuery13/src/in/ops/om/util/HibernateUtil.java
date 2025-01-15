package in.ops.om.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.ops.om.bean.EmployeeInfo;
import in.ops.om.bean.InsurancePolicy;
import in.ops.om.bean.PremiumInsurancePolicy;




public class HibernateUtil {
	
	static SessionFactory sessionFactory = null;

	static {
		  sessionFactory = new Configuration()
				  			.configure()
				  			.addAnnotatedClass(InsurancePolicy.class)
				  			.addAnnotatedClass(PremiumInsurancePolicy.class)
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
