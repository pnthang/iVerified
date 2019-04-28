package ca.gtem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.gtem.model.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
	public Product findBySku(String sku);
	public Product findByHash(String hash);
}
