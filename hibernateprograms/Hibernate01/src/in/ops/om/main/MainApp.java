package in.ops.om.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.ops.om.bean.Student;
import in.pwskills.neeraj.util.Utility;

public class MainApp {

	public static void main(String[] args) {

		Session session = null;
		Boolean flag = false;
		Transaction transaction = null;

		try {
			session = Utility.getSession();

			if (session != null) {

				transaction = session.beginTransaction();

				Student student = new Student();
				student.setSname("dhoni");
				student.setAddress(null);
				student.setAge(42);
				student.setStatus("Married");

				session.saveOrUpdate(student);
				flag = true;

			}

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (transaction != null) {
					if (flag) {
						transaction.commit();
						System.out.println("Record inserted/updated succesfully");
					} else {
						transaction.rollback();
						System.out.println("Some problem with insertion/updation...");
					}
				}

				System.in.read();
				Utility.closeSessionFactory();
				if (session != null) {
					session.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

                   
}


class Utility {
	private static SessionFactory sessionFactory = null;

	static {
		if (sessionFactory == null) {
			sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		}
	}

	public static Session getSession() {
		if (sessionFactory != null) {
			return sessionFactory.openSession();
		}

		return null;
	}

	public static void closeSessionFactory() {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}
}