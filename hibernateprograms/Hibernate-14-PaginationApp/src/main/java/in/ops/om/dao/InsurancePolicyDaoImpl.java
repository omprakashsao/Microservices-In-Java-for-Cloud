package in.ops.om.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import in.ops.om.entity.InsurancePolicy1;
import in.ops.om.util.HibernateUtil;

public class InsurancePolicyDaoImpl implements InsurancePolicyDao {

	@Override
	public long getTotalRecordCount() {
		
		Session session = HibernateUtil.getSession();
		Query query = session.getNamedQuery("GET_POLICIES_COUNT");
		List<Long>  list = query.getResultList();
		
		return list.get(0);
	}

	@Override
	public List<InsurancePolicy1> getPageData(int pageSize, int startPos) {
		Session session = HibernateUtil.getSession();
		Query query = session.getNamedQuery("GET_ALL_POLICIES");
		
		//Perform Pagination...
		query.setFirstResult(startPos);
		query.setMaxResults(pageSize);
		
		List<InsurancePolicy1> list = query.getResultList();
		
		return list;
	}

	
}
