package ca.gtem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ca.gtem.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier,Long> {

}


