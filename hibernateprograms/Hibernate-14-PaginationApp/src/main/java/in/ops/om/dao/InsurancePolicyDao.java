package in.ops.om.dao;

import java.util.List;

import in.ops.om.entity.InsurancePolicy1;

public interface InsurancePolicyDao {
	
	public long getTotalRecordCount();
	public List<InsurancePolicy1> getPageData(int pageSize, int startPos);
}
