package in.ops.om.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;





@Entity
@Table(name="ProjProjInfo2")
public class ProgProjInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProgProjId id;
	
	@Column(name = "proj_name", length = 20)
	private  String projectName;
	
	@Column(name = "prog_name", length = 20)
	private String ProgrammerName;

	public ProgProjId getId() {
		return id;
	}

	public void setId(ProgProjId id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProgrammerName() {
		return ProgrammerName;
	}

	public void setProgrammerName(String programmerName) {
		ProgrammerName = programmerName;
	}

	@Override
	public String toString() {
		return "ProgProjInfo [id=" + id + ", projectName=" + projectName + ", ProgrammerName=" + ProgrammerName + "]";
	}
	
	

}
