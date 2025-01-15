package in.ops.om.main;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.ops.om.bean.Product;
import in.ops.om.util.HibernateUtil;

public class QBCApplication {
	public static void main(String[] args) {
		
		Session session = null;
		try {
			 session = HibernateUtil.getSession();
			 
			 //create crieteriabuilder for 
			 CriteriaBuilder builder = session.getCriteriaBuilder();
			 CriteriaQuery<Product> cQuery = builder.createQuery(Product.class);
			 Root<Product> root = cQuery.from(Product.class);
			 cQuery.select(root);
			 
			 Query<Product> query = session.createQuery(cQuery);
			 List<Product> list = query.getResultList();
			 list.forEach(System.out::println);
			 
			 
			 
			 
			
			
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
