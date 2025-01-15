package in.ops.om.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.ops.om.bean.EmployeeInfo;
import in.ops.om.bean.InsurancePolicy;
import in.ops.om.util.HibernateUtil;

public class LoadApp {

	public static void main(String[] args) {
		
		Session session = null;
		Query<InsurancePolicy> query = null;
		
		try {
			
			 session = HibernateUtil.getSession();
			 if(session!= null) {
				 
				  query = session.createQuery("FROM in.ops.om.bean.InsurancePolicy");
				  
				  List<InsurancePolicy> resultList = query.getResultList();
				   resultList.forEach(policy->System.out.println(policy));
				   
				   System.out.println("Working with named parameterd..");
				   
				   query = session.createQuery("FROM  in.ops.om.bean.InsurancePolicy WHERE PolicyName IN (:org1, :org2)");
				   
				   query.setString("org1", "LIC");
				   query.setString("org2", "SBI");
				   
				   List<InsurancePolicy> resultList2 = query.getResultList();
				   resultList2.forEach(System.out::println);
				   
				   
			 }
			
			
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			
			if(session != null) {
				session.close();
			}
			
			HibernateUtil.closeSessionFactory();
		}

	}

}
