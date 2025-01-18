package in.ops.om.bean;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@DiscriminatorValue(value = "cheque")
@Table(name="CHEQUE_TBSC")
@PrimaryKeyJoinColumn(name="payment_id", referencedColumnName = "pid")
public class ChequePayment extends Payment {

	private static final long serialVersionUID = 1L;
	
	private Integer chequeNo;
	private String chequeType;
	private LocalDate expiryDate;
	
	public Integer getChequeNo() {
		return chequeNo;
	}
	public void setChequeNo(Integer chequeNo) {
		this.chequeNo = chequeNo;
	}
	public String getChequeType() {
		return chequeType;
	}
	public void setChequeType(String chequeType) {
		this.chequeType = chequeType;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	@Override
	public String toString() {
		return "ChequePayment [chequeNo=" + chequeNo + ", chequeType=" + chequeType + ", expiryDate=" + expiryDate
				+ "]";
	}	

}
