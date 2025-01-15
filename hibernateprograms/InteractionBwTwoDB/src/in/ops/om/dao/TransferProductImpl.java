package in.ops.om.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ops.om.bean.Product;
import in.ops.om.util.MySql1HibernateUtil;
import in.ops.om.util.MySql2HibernateUtil;

public class TransferProductImpl implements TransferProduct {

	@Override
	public String transferProductById(Integer id) {
		
		Session session = null, session2 = null;
		Product product = null;
		Transaction transaction = null;
		boolean flag = false;
		
		String status = "";
		 session = MySql1HibernateUtil.getSession();
		 if(session!= null) {
			  product = session.get(Product.class, id);
		 }
		 
		 try {
			 if(product!=null) {
				 session2 = MySql2HibernateUtil.getSession();
				 if(session2 != null) {
					 transaction = session2.beginTransaction();
					 if(transaction!= null) {
						 session2.save(product);
						
						 flag= true;
					 }
				 }
			 }
			
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch(Exception e){
			e.printStackTrace();
		}  finally {
			if(flag) {
				transaction.commit();
				 status = "product is transfered sucessfully one DB to another...";
			}else {
				transaction.rollback();
				status = "some error occur while tranfer the product , try again...";
			}
		}
		return status;
	}

}
