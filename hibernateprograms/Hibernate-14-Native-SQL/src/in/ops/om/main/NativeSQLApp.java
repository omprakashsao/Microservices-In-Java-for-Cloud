package in.ops.om.main;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import in.ops.om.bean.InsurancePolicy;
import in.ops.om.util.HibernateUtil;

public class NativeSQLApp {
	public static void main(String[] args) {
		
		
		Session session = null;

		
		try {
			session = HibernateUtil.getSession();
			if(session != null) {
				
				//Native sql query for mapping with Entity
				NativeQuery<InsurancePolicy> query = session.createSQLQuery("select * from insurancepolicy where tenure>= :max1 and tenure<=:max2");
				
				//set parameter
				query.setParameter("max1", 30);
				query.setParameter("max2", 45);
				
				//Mapping with class
				query.addEntity(InsurancePolicy.class);
				
				//execute and fetch data
				List<InsurancePolicy> list = query.getResultList();
				list.forEach(obj-> System.out.println(obj));
				
				System.out.println("**********************************************");
				
				//Native sql query for without mapping Entity
				NativeQuery<Object[]> query1 = session.createSQLQuery("select * from insurancepolicy where tenure>= :max1 and tenure<=:max2");
				
				//set parameter
				query1.setParameter("max1", 36);
				query1.setParameter("max2", 45);
				
				
				
				//execute and fetch data
				List<Object[]> list1 = query1.getResultList();
				
				list1.forEach(obj->{
					for(Object data : obj) {
						System.out.print(data + " ");
					}
					System.out.println();
				});
				
				
				
			}
	
			
			
		}catch(HibernateException he) {
			he.printStackTrace();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			
			if(session!=null) {
				session.close();
				}
			HibernateUtil.closeSessionFactory();
		}
	}

}
