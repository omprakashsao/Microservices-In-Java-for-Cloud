package in.ops.om.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

@Entity
@NamedNativeQuery(query="SELECT policyName , policyType FROM insurancepolicy" , name="SpecificColumn")
@NamedNativeQuery(query="SELECT policyName FROM insurancepolicy" , name="SpecificColumn1")
public class InsurancePolicy  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer policyId;
	
	private String policyName;
	private String policyType;
	private String policyTime;
	private Integer tenure;
	public Integer getTenure() {
		return tenure;
	}
	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}
	public Integer getPolicyId() {
		return policyId;
	}
	public void setPolicyId(Integer policyId) {
		this.policyId = policyId;
	}
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public String getPolicyType() {
		return policyType;
	}
	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}
	public String getPolicyTime() {
		return policyTime;
	}
	public void setPolicyTime(String policyTime) {
		this.policyTime = policyTime;
	}
	@Override
	public String toString() {
		return "InsurancePolicy [policyId=" + policyId + ", policyName=" + policyName + ", policyType=" + policyType
				+ ", policyTime=" + policyTime + ", tenure=" + tenure + "]";
	}
	
	
	
	

}
