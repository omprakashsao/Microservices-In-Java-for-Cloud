package in.ops.om.bean;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Payment implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Integer pid;
	private Float amount;
	
	
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	
	
	@Override
	public String toString() {
		return "Payment [pid=" + pid + ", amount=" + amount + "]";
	}
	
	

}
