package in.ops.om.main;

import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.sql.Select;

import in.ops.om.bean.Product;
import in.ops.om.util.HibernateUtil;

public class QBC_Scalar_Application3 {
	private static Order desc;
	

	public static void main(String[] args) {
		
		Session session = null;
		try {
			// select productName from product where pId >=  param1 and pId <= param order by desc projectName
			
			/*
			 session = HibernateUtil.getSession();
			 
			 CriteriaBuilder builder = session.getCriteriaBuilder();
			 CriteriaQuery<String> cQuery = builder.createQuery(String.class);
			 Root<Product> root = cQuery.from(Product.class);
			
			  
			 
			 cQuery.multiselect(root.get("productName"))
			 .where(
					 builder.and(
							 builder.ge( root.get("productId"),1),
							 builder.le( root.get("productId"),4)))
			                 .orderBy(builder.asc(root.get("productName")));
			 
			 Query<String> query = session.createQuery(cQuery);
			 List<String> list = query.getResultList();
			 list.forEach(System.out::println);
				*/		 
			
			// select count(*) from product
			
			session = HibernateUtil.getSession();
			 
			 CriteriaBuilder builder = session.getCriteriaBuilder();
			 CriteriaQuery<Long> cQuery = builder.createQuery(Long.class);
			 Root<Product> root = cQuery.from(Product.class);
			 
			 cQuery.multiselect(builder.count(root.get("productId")));
			 
			 Query<Long> query = session.createQuery(cQuery);
			 Optional<Long> optional = query.uniqueResultOptional();
			 Long count = optional.isPresent() ? optional.get() : 0;
			 
			 System.out.println("No. of records " + count);
			
	
			  
			 
			
			
		} catch (HibernateException he) {
			he.printStackTrace();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) {
				session.close();
			}
			 HibernateUtil.closeSessionFactory();
		}
		
	}
}
