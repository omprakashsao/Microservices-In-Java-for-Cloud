package in.ops.om.main;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ops.om.bean.Address;
import in.ops.om.bean.BankAccount;
import in.ops.om.bean.Student_Component;
import in.ops.om.util.HibernateUtil;

public class AdvanceORMComponentMapping {

	public static void main(String[] args) {
		
		Session session = null;
		Transaction transaction = null;
		Address address;
		Student_Component student = null;
		boolean flag = false;
		
		try {	
			  	session = HibernateUtil.getSession();
			  	if(session != null) {
			  		transaction = session.beginTransaction();
			  		
			  		address = new Address("bhilai", "459003", "chhattisgarh");
			  	    student = new Student_Component("op", 23, address);
			  	    
			  	    session.save(student);
			  		
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
