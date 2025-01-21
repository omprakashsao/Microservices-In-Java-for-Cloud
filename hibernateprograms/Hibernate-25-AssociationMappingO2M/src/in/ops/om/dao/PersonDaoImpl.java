package in.ops.om.dao;

import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ops.om.bean.Person;
import in.ops.om.bean.PhoneNumber;
import in.ops.om.util.HibernateUtil;

public class PersonDaoImpl implements PersonDao {

	@Override
	public void addRecordsByParent() {
		
		Session session = null;
		Transaction transaction = null;
		
		
		boolean flag = false;
		
		try {	
			  	session = HibernateUtil.getSession();
			  	if(session != null) {
			  		transaction = session.beginTransaction();
			  				Person person = new Person();
			  				person.setPname("om");
			  				person.setPaddress("bhilai");
			  				
			  				PhoneNumber number1 = new PhoneNumber();
			  				number1.setMobileNo(12344321L);
			  				number1.setType("normal");
			  				number1.setProvider("jio");
			  				
			  				PhoneNumber number2 = new PhoneNumber();
			  				number2.setMobileNo(34566543L);
			  				number2.setProvider("airtel");
			  				number2.setType("all");
			  				
			  				person.setNumber(Set.of(number1, number2));
			  				
			  				session.save(person);
			  				
			  	    
			  	    
			  		
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

	@Override
	public void loadRecordsByParent() {
		
Session session = null;
		
		try  {	
				session = HibernateUtil.getSession();
				
				
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			if(session != null) {
				session.close();
			}
			HibernateUtil.closeSessionFactory();
		}

		
	}

	@Override
	public void addChildExistingParent() {
		
		
	}

}
