package in.ops.om.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.ops.om.bean.Product;




public class MySql1HibernateUtil {
	
	static SessionFactory sessionFactory = null;

	static {
		  sessionFactory = new Configuration().configure("in/ops/om/cfgs/mysql-hibernate.cfg.xml").addAnnotatedClass(Product.class).buildSessionFactory();
		 
		 
		
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
