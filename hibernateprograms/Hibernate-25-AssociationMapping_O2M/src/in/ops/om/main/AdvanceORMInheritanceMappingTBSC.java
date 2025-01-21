package in.ops.om.main;

import java.time.LocalDate;
import in.ops.om.bean.Person;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ops.om.util.HibernateUtil;

public class AdvanceORMInheritanceMappingTBSC {

	public static void main(String[] args) {
		
		Session session = null;
		Transaction transaction = null;
		
		boolean flag = false;
		
		try {	
			  	session = HibernateUtil.getSession();
			  	if(session != null) {
			  		transaction = session.beginTransaction();
			  		
			  		
			  	    
			  	    
			  		
			  		flag = true;
			  	}
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(flag) {
				transaction.commit();
			}else {
				transaction.rollback();
				
			}
			
			if(session != null) {
				session.close();
				HibernateUtil.closeSessionFactory();
			}
		}

	}

}
