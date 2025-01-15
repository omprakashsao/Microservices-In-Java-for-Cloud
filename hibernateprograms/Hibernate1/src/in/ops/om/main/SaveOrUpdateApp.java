package in.ops.om.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ops.om.bean.Student;
import in.ops.om.util.HibernateUtil;

public class SaveOrUpdateApp {
	
	
	public static void main(String[] args) {
		
		Transaction transaction = null;
		BufferedReader br = null;
		Integer sid = null;
		Student std = null;
		String name = null, age = null, address = null;
		boolean flag = false;
		Session session = null;
		
		try {
			
			 session = HibernateUtil.getSession();
			
			if(session!=null) {
				
				 transaction = session.beginTransaction();
				  br = new BufferedReader(new InputStreamReader(System.in));
				 System.out.println("Enter the sid : ");
				 sid =Integer.parseInt(br.readLine());
				 
			}
			
			if(sid != null) {
				 std = session.get(Student.class, sid);
				 
			}
			if(transaction!=null && std!= null ) {
				
				System.out.println("Old Name is : "+ std.getSname() + "Enter new Name : ");
				name = br.readLine();
				if(name.equals("") || name == null) {
					std.setSname(std.getSname());
				}else {
					std.setSname(name);
				}
				
				
				System.out.println("Old Age is : "+ std.getSage() + "Enter new Age : ");
				age = br.readLine();
				if(age.equals("") || age == null) {
					std.setSage(std.getSage());
				}else {
					std.setSage(Integer.parseInt(age));					
				}
				
				System.out.println("Old Adrress is : "+ std.getSaddress() + "Enter new Adress : ");
				address = br.readLine();
				if(address.equals("") || address == null) {
					std.setSaddress(std.getSaddress());
				}else {
					std.setSaddress(address);
				}
				
				flag = true;
			}else {
				
				std = new Student();				
				//Record is not found in DB
				//std.setSid(sid);  
				//if uncomment above line then give a exception 
				// Row was updated or deleted by another transaction (or unsaved-value mapping was incorrect) : [in.ops.om.bean.Student#100]
				std.setSname("ABC");
				std.setSage(2);
				std.setSaddress("DDD");
				
				session.saveOrUpdate(std);
				
				flag = true;
			}
			
		} catch(HibernateException he) {
			he.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(flag) {
				transaction.commit();
				System.out.println("Record is successfully updated");
			}else {
				transaction.rollback();
			}
			
			if(session!= null) {
				session.close();
			}
			HibernateUtil.closeSessionFactory();
		}
			// TODO: handle exception
		}

	}


