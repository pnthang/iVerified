package ca.gtem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ca.gtem.model.ProductSubCategory;

@RepositoryRestResource(path = "/product-subcategories")
public interface ProductSubCategoryRepository extends JpaRepository<ProductSubCategory,Long> {

}
