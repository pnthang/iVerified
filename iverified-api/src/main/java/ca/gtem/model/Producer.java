package ca.gtem.model;

import javax.persistence.*;

import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

@Entity
@Component
public class Producer extends Vendor {	
			
	@OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "producer")
	@JsonIgnore
    private Set<Product> product = new HashSet<>();

	/**
	 * @return the product
	 */
	public Set<Product> getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Set<Product> product) {
		this.product = product;
	}
}
