package in.ops.om.service;

import java.util.List;

import in.ops.om.entity.InsurancePolicyDTO;

public interface InsurancePolicyMgmtService {
	
	long fetchPageCount(int pageSize);
	List<InsurancePolicyDTO> fetchPageData(int pageSize, int pageNo);

}


