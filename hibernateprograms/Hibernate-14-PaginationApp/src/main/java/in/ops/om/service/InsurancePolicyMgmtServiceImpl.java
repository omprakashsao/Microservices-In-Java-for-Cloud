package in.ops.om.service;

import java.util.ArrayList;
import java.util.List;

import in.ops.om.dao.InsurancePolicyDao;
import in.ops.om.dao.InsurancePolicyDaoImpl;
import in.ops.om.entity.InsurancePolicy1;
import in.ops.om.entity.InsurancePolicyDTO;

public class InsurancePolicyMgmtServiceImpl implements InsurancePolicyMgmtService {

	private InsurancePolicyDao dao;
	
	public InsurancePolicyMgmtServiceImpl() {
		dao = new InsurancePolicyDaoImpl();
	}
	@Override
	public long fetchPageCount(int pageSize) {
		
		long recordsCount = dao.getTotalRecordCount();
		long pageCount = recordsCount / pageSize;
		
		if(recordsCount % pageSize != 0) {
			pageCount++;
		}
		return pageCount;
	}

	@Override
	public List<InsurancePolicyDTO> fetchPageData(int pageSize, int pageNo) {
		List<InsurancePolicyDTO> listDTO = new ArrayList<>();
		List<InsurancePolicy1> entities = null;
		
		
		// print records from start position to end position
		int startPos = 0;
		
		startPos = (pageNo*pageSize)-pageSize;
		entities = dao.getPageData(pageSize, startPos);// 3, 0
		
		//convert from BO to DTO
		entities.forEach(entity ->{
			
			InsurancePolicyDTO dto = new InsurancePolicyDTO();
			dto.setPolicyId(entity.getPolicyId());
			dto.setPolicyName(entity.getPolicyName());
			dto.setPolicyType(entity.getPolicyType());
			dto.setCompany(entity.getCompany());
			dto.setTenure(entity.getTenure());
			dto.setSerialNo(listDTO.size()+1);
			listDTO.add(dto);
			}
				);
		
		
		return listDTO;
	}

}
