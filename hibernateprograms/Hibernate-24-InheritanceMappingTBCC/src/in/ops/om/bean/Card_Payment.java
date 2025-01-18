package in.ops.om.bean;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="CARD_TBCC")

public class Card_Payment extends Payment {

	
	private static final long serialVersionUID = 1L;
	
	private Integer cardNo;
	private String cardType;
	private String paymentGateway;
	public Integer getCardNo() {
		return cardNo;
	}
	public void setCardNo(Integer cardNo) {
		this.cardNo = cardNo;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getPaymentGateway() {
		return paymentGateway;
	}
	public void setPaymentGateway(String paymentGateway) {
		this.paymentGateway = paymentGateway;
	}
	
	
	@Override
	public String toString() {
		return "Card_Payment [cardNo=" + cardNo + ", cardType=" + cardType + ", paymentGateway=" + paymentGateway + "]";
	}
	
	
	

}
