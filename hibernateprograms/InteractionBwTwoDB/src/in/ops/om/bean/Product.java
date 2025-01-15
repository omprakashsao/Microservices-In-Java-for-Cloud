package in.ops.om.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_info")
public class Product implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Integer pid;
	
	@Column(name = "p_name")
	private String pname;
	
	@Column(name = "p_quantity")
	private Integer pqty;
	
	@Column(name = "p_price")
	private float pprice;

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Integer getPqty() {
		return pqty;
	}

	public void setPqty(Integer pqty) {
		this.pqty = pqty;
	}

	public float getPprice() {
		return pprice;
	}

	public void setPprice(float pprice) {
		this.pprice = pprice;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", pqty=" + pqty + ", pprice=" + pprice + "]";
	}
	
	
	

}
