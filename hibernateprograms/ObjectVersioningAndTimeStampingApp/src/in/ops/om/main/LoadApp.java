package in.ops.om.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ops.om.bean.MobileCustomerInfo;
import in.ops.om.util.HibernateUtil;

public class LoadApp {

	public static void main(String[] args) {
		
		Session session = null;
	    MobileCustomerInfo info = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			
			 session = HibernateUtil.getSession();
			 if(session!= null) {
				 
				  info = session.get(MobileCustomerInfo.class, 1);
				  
				  if(info!= null) {
					  System.out.println(info);
					  
					   transaction = session.beginTransaction();
					  
					   if(transaction!= null) {
						   
						   info.setBalance(info.getBalance()+1000.0f);
						   
						   flag = true;
					   }
					  
				  }
				 
			 }
			
			
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(flag) {
				transaction.commit();
				System.out.println("record is succesfully updated");
				System.out.println(info);
			}else {
				transaction.rollback();
			}
			if(session != null) {
				session.close();
			}
			
			HibernateUtil.closeSessionFactory();
		}

	}

}
