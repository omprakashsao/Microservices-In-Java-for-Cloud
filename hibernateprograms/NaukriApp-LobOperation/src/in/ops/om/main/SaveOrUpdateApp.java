package in.ops.om.main;




import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ops.om.bean.EmployeeInfo;
import in.ops.om.util.HibernateUtil;

public class SaveOrUpdateApp {
	
	
	public static void main(String[] args) {
		
		Transaction transaction = null;	
		boolean flag = false;
		Session session = null;
		EmployeeInfo info = null;
		byte[] image = null;
		char[] resume = null;
		FileInputStream fis = null;
		BufferedReader br = null;
		
		try {
			
			 session = HibernateUtil.getSession();
			
			 if(session!= null ) {
				
				  transaction = session.beginTransaction();
				  if(transaction != null) {
				            info = new EmployeeInfo();
				            String imageLoc = "C:\\Users\\kajal\\OneDrive\\Pictures\\WhatsApp Image 2024-08-02 at 12.54.09_48c704d4.jpg";
				            String resumeLoc = "D:\\TypingTest Certificate.pdf";
				            
				            //input the image file
				            fis = new FileInputStream(new File(imageLoc));
				                  int size = fis.available();
				            image = new byte[size];
				            fis.read(image);
				            
				            //input the resume file
				            File file = new File(resumeLoc);
				            br = new BufferedReader(new FileReader(file));
				            
				            resume = new char[(int) file.length()];
				            br.read(resume);
				            
				            info.seteAddress("Balaji Tirupati");
				            info.seteName("Nitin Manjunath");
				            info.setProfileImage(image);
				            info.setResume(resume);
				             
				            session.saveOrUpdate(info);
				             
				   
				   
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
	



