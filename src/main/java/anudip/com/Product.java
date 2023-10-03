package anudip.com;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Product {

	@Id
	private int productId;
	private String productName;
	
	@ManyToMany(mappedBy="productset")
	private Set<Company> companySet=new HashSet<Company>();

	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public Set<Company> getCompanySet() {
		return companySet;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setCompanySet(Set<Company> companySet) {
		this.companySet = companySet;
	}
	
}