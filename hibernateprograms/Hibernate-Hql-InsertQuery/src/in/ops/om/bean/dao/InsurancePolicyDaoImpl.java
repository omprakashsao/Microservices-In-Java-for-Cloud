package in.ops.om.bean.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.criteria.CriteriaUpdate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.ops.om.bean.PersonInfo;
import in.ops.om.util.HibernateUtil;

public class InsurancePolicyDaoImpl implements InsurancePolicyDao {

	private static final String HQL_TRANSFER_POLICIES = "INSERT INTO in.ops.om.bean.PremiumInsurancePolicy(policyId,policyName, policyType, policyTime, tenure) SELECT i.policyId, i.policyName, i.policyType, i.policyTime, i.tenure FROM in.ops.om.bean.InsurancePolicy AS i WHERE i.tenure >=: min";

	@Override
	public String transferInsurancePolicy(int minTenure) {
		// TODO Auto-generated method stub
		
		Transaction transaction = null;	
		boolean flag = false;
		Session session = null;
		Query query = null;
		String msg = null;
		Integer count = null;
		
		try {
			
			 session = HibernateUtil.getSession();
			
			 if(session!= null ) {
				
				 transaction = session.beginTransaction();
	              
				 query = session.createQuery(HQL_TRANSFER_POLICIES);
	             query.setParameter("min", minTenure);
	              count = query.executeUpdate();
	             
				   
				   
				   flag = true;	   
 
			 }
			
			
			 
		} catch(HibernateException he) {
			he.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			if(transaction != null) {
				
				if(flag) {
					transaction.commit();
					msg= "No. of records inserted : "+ count;
					
				}else {
					transaction.rollback();
					msg = "No records are inserted..";
				}
				
				if(session!= null) {
					session.close();
				}
				HibernateUtil.closeSessionFactory();
			}
		}
		return msg;
	}

}
