package in.ops.om.main;

import java.time.LocalDate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ops.om.bean.Card_Payment;
import in.ops.om.bean.ChequePayment;
import in.ops.om.util.HibernateUtil;

public class AdvanceORMInheritanceMappingTBSC {

	public static void main(String[] args) {
		
		Session session = null;
		Transaction transaction = null;
		
		boolean flag = false;
		
		try {	
			  	session = HibernateUtil.getSession();
			  	if(session != null) {
			  		transaction = session.beginTransaction();
			  		
			  		ChequePayment cheque = new ChequePayment();
			  		cheque.setAmount(18000.0f);
			  		cheque.setChequeNo(1);
			  		cheque.setChequeType("all");
			  		cheque.setExpiryDate(LocalDate.of(2025, 12, 18));
			  	    
			  	    session.save(cheque);
			  	    
			  	    Card_Payment card = new Card_Payment();
			  	    card.setAmount(810000.0f);
			  	    card.setCardNo(1923);
			  	    card.setCardType("Visa");
			  	    card.setPaymentGateway("ICC");
			  	    
			  	    session.save(card);
			  	    
			  	    
			  		
			  		flag = true;
			  	}
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(flag) {
				transaction.commit();
			}else {
				transaction.rollback();
				
			}
			
			if(session != null) {
				session.close();
				HibernateUtil.closeSessionFactory();
			}
		}

	}

}
