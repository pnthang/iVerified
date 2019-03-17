package ca.gtem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ca.gtem.model.ProductCategory;

@RepositoryRestResource(path = "/product-categories")
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Long> {

}
