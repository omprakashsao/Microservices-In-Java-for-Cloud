package in.ops.om.main;

import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ops.om.bean.Person;
import in.ops.om.bean.PhoneNumber;
import in.ops.om.dao.PersonDaoImpl;
import in.ops.om.util.HibernateUtil;

public class MainApp {

	public static void main(String[] args) {
		
		PersonDaoImpl dao = new PersonDaoImpl();
//		dao.insertRecordsByParent();
//		dao.loadRecordByParent();
		
		dao.addChildToExistingParent();
		
	

	}

}
