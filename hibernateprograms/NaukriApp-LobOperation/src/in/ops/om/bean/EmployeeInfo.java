package in.ops.om.bean;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "Registrantion_Data")
public class EmployeeInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "e_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer eId;
	
	@Column(name= "e_name")
	private String  eName;
	
	@Column(name= "e_address")
	private String  eAddress;
	
	@Lob
	private byte[] profileImage;
	
	@Lob
	private char[] resume;
	
	public Integer geteId() {
		return eId;
	}
	public void seteId(Integer eId) {
		this.eId = eId;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String geteAddress() {
		return eAddress;
	}
	public void seteAddress(String eAddress) {
		this.eAddress = eAddress;
	}
	public byte[] getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(byte[] profileImage) {
		this.profileImage = profileImage;
	}
	public char[] getResume() {
		return resume;
	}
	public void setResume(char[] resume) {
		this.resume = resume;
	}
	
	
	@Override
	public String toString() {
		return "EmployeeInfo [eId=" + eId + ", eName=" + eName + ", eAddress=" + eAddress + ", profileImage="
				+ Arrays.toString(profileImage) + ", resume=" + Arrays.toString(resume) + "]";
	}
	
	
	
}
