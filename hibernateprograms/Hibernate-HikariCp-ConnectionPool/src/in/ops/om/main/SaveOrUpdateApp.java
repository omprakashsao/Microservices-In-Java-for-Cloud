package in.ops.om.main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ops.om.bean.PersonInfo;
import in.ops.om.util.HibernateUtil;

public class SaveOrUpdateApp {
	
	
	public static void main(String[] args) {
		
		Transaction transaction = null;	
		boolean flag = false;
		Session session = null;
		
		try {
			
			 session = HibernateUtil.getSession();
			
			 if(session!= null ) {
				
				 transaction = session.beginTransaction();
	               
	               PersonInfo info = new PersonInfo();
	               info.setPname("555");
	               info.setPaddr("Bhilai");
	               info.setDob(LocalDateTime.of(2003, 2, 3, 13, 34));
	               info.setDoj(LocalTime.of(23, 35, 15));
	               info.setDom(LocalDate.of(2014, 11, 23));
	               
	               session.saveOrUpdate(info);
		          
				   
				   
				   flag = true;	   
 
			 }
			
			
			 
		} catch(HibernateException he) {
			he.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			if(transaction != null) {
				
				if(flag) {
					transaction.commit();
					System.out.println("Record is successfully inserted");
				}else {
					transaction.rollback();
				}
				
				if(session!= null) {
					session.close();
				}
				HibernateUtil.closeSessionFactory();
			}
		}
			// TODO: handle exception
		}

	}
	



