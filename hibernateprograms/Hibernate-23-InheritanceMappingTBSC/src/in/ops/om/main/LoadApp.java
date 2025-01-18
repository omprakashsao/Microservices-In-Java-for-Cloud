package in.ops.om.main;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.ops.om.bean.Card_Payment;
import in.ops.om.bean.ChequePayment;
import in.ops.om.bean.Payment;
import in.ops.om.util.HibernateUtil;

public class LoadApp {

	public static void main(String[] args) {
		
		Session session = null;
		
		try  {	
				session = HibernateUtil.getSession();
				Query<Payment> query = session.createQuery("from Payment");
				List<Payment> list = query.getResultList();
				list.forEach(System.out::println);
				
				Query<ChequePayment> query1 = session.createQuery("from ChequePayment");
				List<ChequePayment> list1 = query1.getResultList();
				list1.forEach(System.out::println);
				
				Query<Card_Payment> query2 = session.createQuery("from Card_Payment");
				List<Card_Payment> list2 = query2.getResultList();
				list2.forEach(System.out::println);
			
		} catch (HibernateException e) {
			e.printStackTrace();
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
