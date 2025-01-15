package in.ops.om.main;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.ops.om.bean.BankAccount;
import in.ops.om.util.HibernateUtil;

public class FilterApp {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Session session = null;
		
		try {
			     session = HibernateUtil.getSession();
			     
			     //Enable Filter
			     Filter filter = session.enableFilter("filter_for_bank_status");
			     filter.setParameter("param1", "blocked");
			     filter.setParameter("param2", "closed");
			     
			        CriteriaBuilder builder = session.getCriteriaBuilder();
		        CriteriaQuery<BankAccount> cquery = builder.createQuery(BankAccount.class);
		        Root<BankAccount> root = cquery.from(BankAccount.class);
		        cquery.select(root);
		        
		        Query<BankAccount> query = session.createQuery(cquery);
		        List<BankAccount> list = query.getResultList();
		        list.forEach(System.out::println);
			     
			    
			         
			         
		} catch (HibernateException e) {
			// TODO: handle exception
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			
			if(session != null) {
				session.close();
			}
			HibernateUtil.closeSessionFactory();
			
		}

	}

}
