package in.ops.om.main;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ops.om.bean.Employee;
import in.ops.om.util.HibernateUtil;

public class AdvanceORMCollectionMapping {

	public static void main(String[] args) {
		
		Session session = null;
		Transaction transaction = null;
		
		boolean flag = false;
		
		try {	
			  	session = HibernateUtil.getSession();
			  	if(session != null) {
			  		transaction = session.beginTransaction();
			  		
			  		Employee employee = new Employee("sushant sinha", 27, List.of("neeraj","Rahul","Aadi"),
			  				Set.of(12345678L,98765403L, 79932043L));
			  		
			  	    
			  	    session.save(employee);
			  		
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
