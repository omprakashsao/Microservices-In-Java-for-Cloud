package in.ops.om.main;

import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.ops.om.bean.Product;
import in.ops.om.util.HibernateUtil;

public class QBC_DeleteQueryApp {
	private static Order desc;
	

	public static void main(String[] args) {
		
		Session session = null;
		Transaction transaction = null;
		Integer count = 0;
		boolean flag = false;
		try {
			//delete from product where teamsize between (90 , 10)
			
			session = HibernateUtil.getSession();
			 transaction = session.beginTransaction();
			 CriteriaBuilder builder = session.getCriteriaBuilder();
			 
			 CriteriaDelete<Product> criteriaDelete = builder.createCriteriaDelete(Product.class);
			 
			  Root<Product> root = criteriaDelete.from(Product.class);
			  
			   criteriaDelete.where(builder.between(root.get("teamSize"), 10, 90));
			 
			 Query<Integer> query = session.createQuery(criteriaDelete);
			 count = query.executeUpdate();
			 
			flag = true;
			 
					
		} catch (HibernateException he) {
			he.printStackTrace();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
				if(flag) {
					transaction.commit();
					System.out.println("No. of Records are deleted : "+count);
				}
			
			if(session != null) {
				session.close();
			}
			 HibernateUtil.closeSessionFactory();
		}
		
	}
}
