package in.ops.om.main;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.ops.om.bean.Card_Payment;
import in.ops.om.bean.ChequePayment;
import in.ops.om.bean.Payment;
import in.ops.om.dao.PersonDaoImpl;
import in.ops.om.util.HibernateUtil;

public class MainApp {

	public static void main(String[] args) {
		
		PersonDaoImpl daoImpl = new PersonDaoImpl();
		daoImpl.addRecordsByParent();
		
	}

}
