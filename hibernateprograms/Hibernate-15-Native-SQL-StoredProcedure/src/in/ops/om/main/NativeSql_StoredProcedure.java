package in.ops.om.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import in.ops.om.bean.Product_Info;
import in.ops.om.util.HibernateUtil;

public class NativeSql_StoredProcedure {
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSession();
		NativeQuery<Product_Info> query = session.createSQLQuery("CALL `PRODUCT_DETATILS` ( :var)");
		query.setParameter("var", 2);
		
		
		query.addEntity(Product_Info.class);
		
		List<Product_Info> list = query.getResultList();
		list.forEach(System.out::println);
		
		
		
	}
}
