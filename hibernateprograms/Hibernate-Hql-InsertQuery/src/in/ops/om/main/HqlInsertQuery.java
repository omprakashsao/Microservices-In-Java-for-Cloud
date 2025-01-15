package in.ops.om.main;

import in.ops.om.bean.dao.InsurancePolicyDaoImpl;

public class HqlInsertQuery {
	public static void main(String[] args) {
		
		InsurancePolicyDaoImpl dao = new InsurancePolicyDaoImpl();
		System.out.println(dao.transferInsurancePolicy(32));
	}
}
