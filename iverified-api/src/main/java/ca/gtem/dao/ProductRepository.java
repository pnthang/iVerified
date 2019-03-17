package ca.gtem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ca.gtem.model.Product;

@RepositoryRestResource(path = "/products")
public interface ProductRepository extends JpaRepository<Product,Long> {

}
