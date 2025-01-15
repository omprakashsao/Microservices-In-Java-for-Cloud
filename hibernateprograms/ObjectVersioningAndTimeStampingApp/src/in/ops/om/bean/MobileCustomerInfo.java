package in.ops.om.bean;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name= "customer_info")
public class MobileCustomerInfo implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cno;
	
	@Column(name = "c_name" , length = 30)
	private String cname;
	
	@Column(name = "c_address" , length = 40)
	private String caddr;
	
	@Column(name = "c_balance")
	private float balance;
	
	@CreationTimestamp
	private LocalDateTime openAccount;
	
	@UpdateTimestamp
	private LocalDateTime lastUpdated;
	
	@Version
	private Integer versionCount;

	public Integer getCno() {
		return cno;
	}

	public void setCno(Integer cno) {
		this.cno = cno;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCaddr() {
		return caddr;
	}

	public void setCaddr(String caddr) {
		this.caddr = caddr;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public LocalDateTime getOpenAccount() {
		return openAccount;
	}

	public void setOpenAccount(LocalDateTime openAccount) {
		this.openAccount = openAccount;
	}

	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public Integer getVersionCount() {
		return versionCount;
	}

	public void setVersionCount(Integer versionCount) {
		this.versionCount = versionCount;
	}

	@Override
	public String toString() {
		return "MobileCustomerInfo [cno=" + cno + ", cname=" + cname + ", caddr=" + caddr + ", balance=" + balance
				+ ", openAccount=" + openAccount + ", lastUpdated=" + lastUpdated + ", versionCount=" + versionCount
				+ "]";
	}
	
	

}
