package in.ops.om.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.ops.om.bean.EmployeeInfo;
import in.ops.om.util.HibernateUtil;

public class LoadApp {

	public static void main(String[] args) {
		
		Session session = null;
		EmployeeInfo info = null;
		
		try {
			
			 session = HibernateUtil.getSession();
			 if(session!= null) {
				 
				  info = session.get(EmployeeInfo.class, 2);
				  
				  System.out.println(info.geteName());
				  System.out.println(info.geteAddress());
				  
				  
				  FileWriter fw = new FileWriter(new File("C:\\Users\\kajal\\OneDrive\\Pictures\\resume1.txt"));
				  fw.write(info.getResume());
				  fw.flush();
				  fw.close();
				  
				  FileOutputStream fos = new FileOutputStream(new File("C:\\\\Users\\\\kajal\\\\OneDrive\\\\Pictures\\\\profileImage1.jpg"));
				  fos.write(info.getProfileImage());
				  
				  fos.flush();
				  fos.close();
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
