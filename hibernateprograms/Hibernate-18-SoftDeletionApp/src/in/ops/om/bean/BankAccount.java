package in.ops.om.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@FilterDef(name = "filter_for_bank_status", parameters = {
		@ParamDef(type = "string", name = "param1"),
		@ParamDef(type = "string", name = "param2")
})
@Filter(name = "filter_for_bank_status", condition = "status not in ( :param1, :param2 )")
@SQLDelete(sql = "update bankaccount set status = 'blocked' where bankId = ?")
@Where(clause = "status not in ('blocked', 'closed') ")
public class BankAccount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bankId;
	private String bankName;
	private Float  bankbalance;
	private String holderName;
	private String status;
	public Integer getBankId() {
		return bankId;
	}
	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public Float getBankbalance() {
		return bankbalance;
	}
	public void setBankbalance(Float bankbalance) {
		this.bankbalance = bankbalance;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "BankAccount [bankId=" + bankId + ", bankName=" + bankName + ", bankbalance=" + bankbalance + ", status="
				+ status + "]";
	}
	
	
	

}
