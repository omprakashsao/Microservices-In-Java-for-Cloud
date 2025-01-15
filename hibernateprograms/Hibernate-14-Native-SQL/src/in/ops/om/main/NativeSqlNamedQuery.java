package in.ops.om.main;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import in.ops.om.bean.InsurancePolicy;
import in.ops.om.util.HibernateUtil;

public class NativeSqlNamedQuery {
	
	public static void main(String[] args) {
		
	Session session = null;

		
		try {
			session = HibernateUtil.getSession();
			
			NativeQuery<Object[]> query = session.getNamedNativeQuery("SpecificColumn");
			
			//query.setParameter("max1", 23);
			//query.setParameter("max2", 45);
			
			List<Object[]> list = query.getResultList();
			list.forEach(obj->{
				for (Object data : obj) {
					System.out.print(data+ " ");
				}
				System.out.println();
			});
			
			//particular column
            NativeQuery<String> query1 = session.getNamedNativeQuery("SpecificColumn1");
			
			//query.setParameter("max1", 23);
			//query.setParameter("max2", 45);
			
			List<String> list1 = query1.getResultList();
			list1.forEach(obj1->System.out.println(obj1));
			
			
			
			
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
