package in.ops.om.main;




import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ops.om.bean.ProgProjId;
import in.ops.om.bean.ProgProjInfo;
import in.ops.om.util.HibernateUtil;

public class SaveOrUpdateApp {
	
	
	public static void main(String[] args) {
		
		Transaction transaction = null;
		ProgProjInfo progProjInfo= null;
		ProgProjId id = null;	
		boolean flag = false;
		Session session = null;
		
		try {
			
			 session = HibernateUtil.getSession();
			
			 if(session!= null ) {
				
				  transaction = session.beginTransaction();
				  if(transaction != null) {
				   progProjInfo = new ProgProjInfo();
				   id =  new ProgProjId();
				   
				   progProjInfo.setProgrammerName("Shivam Sahu");
				   progProjInfo.setProjectName("TESLA");
				   
				   id.setProgId("101");
				   id.setProjId("500");
				   progProjInfo.setId(id);
				   
				   session.save(progProjInfo);
				   
				   
				   flag = true;	   
 
			 }
			
			
			 }	
		} catch(HibernateException he) {
			he.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			if(transaction != null) {
				
				if(flag) {
					transaction.commit();
					System.out.println("Record is successfully inserted");
				}else {
					transaction.rollback();
				}
				
				if(session!= null) {
					session.close();
				}
				HibernateUtil.closeSessionFactory();
			}
		}
			// TODO: handle exception
		}

	}
	



