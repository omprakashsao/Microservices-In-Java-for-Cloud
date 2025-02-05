package in.ops.om.main;

import java.util.List;

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

public class QBCApplication2 {
	private static Order desc;

	public static void main(String[] args) {
		
		Session session = null;
		try {
			// select .. from product where pId >=  param1 and pId <= param order by desc projectName
			 session = HibernateUtil.getSession();
			 
			 CriteriaBuilder builder = session.getCriteriaBuilder();
			 CriteriaQuery<Product> cQuery = builder.createQuery(Product.class);
			 Root<Product> root = cQuery.from(Product.class);
			 //select .. from product where teamSize between (10,20) and projectName 's%'
			  
			 
			 cQuery.select(root)
			 .where(
					 builder.and(
							 builder.between(root.get("teamSize"), 10, 46),
							 builder.like(root.get("productName"), "s%")));
			 Query<Product> query = session.createQuery(cQuery);
			 List<Product> list = query.getResultList();
			 list.forEach(System.out::println);
						 
			
			 
//			 ParameterExpression<Integer> parameter1 = builder.parameter(Integer.class);
//			 ParameterExpression<Integer> parameter2 = builder.parameter(Integer.class);
//			 
//			 Predicate p1 = builder.ge(parameter1, root.get("productId"));
//			 Predicate p2 = builder.le(parameter2, root.get("productId"));
//			 
//			 Predicate and = builder.and(p1, p2);
//			 
//			 cQuery.where(and);
//			 desc = builder.desc(root.get("productName"));
//			 
//			cQuery.orderBy(desc);
//			 
//			 Query<Product> query = session.createQuery(cQuery);
//			 
//			 query.setParameter(parameter1, 5);
//			 query.setParameter(parameter2, 1);
//			 
//			 List<Product> list = query.getResultList();
//			 list.forEach(System.out::println);
//               
			 
			 /*
			  // select .. where project in teamName ('oppo', 'LG') order by asc productName
			 cQuery.select(root).where(root.get("teamName").in("oppo", "LG"))
			 .orderBy(builder.asc( root.get("productName")));
			 
			 Query<Product> query = session.createQuery(cQuery);
			 List<Product> list = query.getResultList();
			 list.forEach(System.out::println);
			 
			*/
			 
			  
			 
			
			
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
