package in.ops.om.bean;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ProgProjId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String projId;
	
	private String progId;
	
	public String getProjId() {
		return projId;
	}
	public void setProjId(String projId) {
		this.projId = projId;
	}
	public String getProgId() {
		return progId;
	}
	public void setProgId(String progId) {
		this.progId = progId;
	}
	
	@Override
	public String toString() {
		return "ProgProjId [projId=" + projId + ", progId=" + progId + "]";
	}
	

}
