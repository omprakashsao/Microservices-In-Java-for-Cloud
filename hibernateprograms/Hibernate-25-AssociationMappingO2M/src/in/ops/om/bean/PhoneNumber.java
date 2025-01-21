package in.ops.om.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PHONE_NUMBER_ONE_TO_MANY")
public class PhoneNumber implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rgNo;
	private Long mobileNo;
	private String type;
	private String provider;
	
	public Integer getRgNo() {
		return rgNo;
	}
	public void setRgNo(Integer rgNo) {
		this.rgNo = rgNo;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	
	@Override
	public String toString() {
		return "PhoneNumber [rgNo=" + rgNo + ", mobileNo=" + mobileNo + ", type=" + type + ", provider=" + provider
				+ "]";
	}
	
	
	
	
	
}
