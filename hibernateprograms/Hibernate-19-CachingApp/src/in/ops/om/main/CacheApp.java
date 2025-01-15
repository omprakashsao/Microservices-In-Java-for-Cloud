package in.ops.om.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.ops.om.bean.BankAccount;
import in.ops.om.util.HibernateUtil;

public class CacheApp {

	public static void main(String[] args) {
		
		Session session = null;
		
		try {
			session = HibernateUtil.getSession();
			BankAccount account = session.get(BankAccount.class, 1);
			System.out.println(account);
			
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if(session != null) {
				session.close();
			}
						
		}

	}

}
