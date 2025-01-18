package in.ops.om.bean;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.Embeddable;

@Embeddable 
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String city;
	private String pincode;
	private String state;
	
	
	public Address() {
		System.out.print("object is created by 0 param...");
	}
	
	public Address(String city, String pincode, String state) {		
		this.city = city;
		this.pincode = pincode;
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Address [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	
}
