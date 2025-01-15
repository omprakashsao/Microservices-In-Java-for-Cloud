package in.ops.om.main;




import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ops.om.bean.MobileCustomerInfo;
import in.ops.om.util.HibernateUtil;

public class SaveOrUpdateApp {
	
	
	public static void main(String[] args) {
		
		Transaction transaction = null;	
		boolean flag = false;
		Session session = null;
		MobileCustomerInfo info = null;
		
		
		
		try {
			
			 session = HibernateUtil.getSession();
			
			 if(session!= null ) {
				
				  transaction = session.beginTransaction();
				  if(transaction != null) {
				           
					   info = new MobileCustomerInfo();
					   info.setCname("Aayush");
					   info.setCaddr("Sector 6 Bhilai");
					   info.setBalance(1000.0f);
					  
					   session.save(info);
				             
				   
				   
				   flag = true;	   
 
			 }
			
			
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
	



