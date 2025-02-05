package in.ops.om.main;

import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
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

public class QBC_UpdateQueryApp {
	private static Order desc;
	

	public static void main(String[] args) {
		
		Session session = null;
		Transaction transaction = null;
		Integer count = 0;
		boolean flag = false;
		try {
			//update product set teamSize = 23 and productType = "5Gphone" where teamSize<77;
			
			session = HibernateUtil.getSession();
			 transaction = session.beginTransaction();
			 CriteriaBuilder builder = session.getCriteriaBuilder();
			 
			 CriteriaUpdate<Product> criteriaUpdate = builder.createCriteriaUpdate(Product.class);
			 
			  Root<Product> root = criteriaUpdate.from(Product.class);
			  
			 criteriaUpdate.set(root.get("teamSize"), 23)
			 				.set("productType", "5gphone").where(builder.le(root.get("teamSize"), 77));
			 
			 Query<Integer> query = session.createQuery(criteriaUpdate);
			 count = query.executeUpdate();
			 
			flag = true;
			 
					
		} catch (HibernateException he) {
			he.printStackTrace();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
				if(flag) {
					transaction.commit();
					System.out.println("No. of Records are updated : "+count);
				}
			
			if(session != null) {
				session.close();
			}
			 HibernateUtil.closeSessionFactory();
		}
		
	}
}
