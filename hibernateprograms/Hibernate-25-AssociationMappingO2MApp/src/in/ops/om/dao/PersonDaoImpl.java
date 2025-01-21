package in.ops.om.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.ops.om.bean.Person;
import in.ops.om.bean.PhoneNumber;
import in.ops.om.util.HibernateUtil;

public class PersonDaoImpl implements PersonDao {

	@Override
	public void insertRecordsByParent() {
		
		Session session = null;
		Transaction transaction = null;
		
		boolean flag = false;
		
		try {	
			  	session = HibernateUtil.getSession();
			  	if(session != null) {
			  		transaction = session.beginTransaction();
			  		PhoneNumber number1 = new PhoneNumber();
			  		number1.setType("normal");
			  		number1.setMobileNo(123454321L);
			  		number1.setProvider("jio");
			  		
			  		PhoneNumber number2 = new PhoneNumber();
			  		number2.setMobileNo(45521423L);
			  		number2.setProvider("airtel");
			  		number2.setType("all");
			  		
			  		Person person = new Person();
			  		person.setPname("om");
			  		person.setPaddress("bhilai3");
			  		person.setNumbers(Set.of(number1, number2));
			  		
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
				System.out.println("insertion successful...");
			}else {
				transaction.rollback();
				System.out.println("insertion not successful...");
			}
			
			if(session != null) {
				session.close();
				HibernateUtil.closeSessionFactory();
			}
		}

		
	}

	@Override
	public void loadRecordByParent() {
		
Session session = null;
		
		try  {	
				session = HibernateUtil.getSession();
				
				Query<Person> query = session.createQuery("from Person");
				List<Person> list = query.getResultList();
				list.forEach(System.out::println);
			
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
	public void addChildToExistingParent() {
		
		Session session = null;
		Transaction transaction = null;
		
		boolean flag = false;
		
		try {	
			  	session = HibernateUtil.getSession();
			  	if(session != null) {
			  		transaction = session.beginTransaction();
			  		
			  		Person person = session.get(Person.class, 1);
			  		Set<PhoneNumber> number = person.getNumbers();
			  		 PhoneNumber number2 = new PhoneNumber();
			  		 number2.setMobileNo(34827384L);
			  		 number2.setProvider("Tata docomo");
			  		 number2.setType("normal-type");
			  		 
			  		number.add(number2);
			  		
			  		flag = true;
			  	}
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(flag) {
				transaction.commit();
				System.out.println("insertion successful...");
			}else {
				transaction.rollback();
				System.out.println("insertion not successful...");
			}
			
			if(session != null) {
				session.close();
				HibernateUtil.closeSessionFactory();
			}
		}
		
	}



}
