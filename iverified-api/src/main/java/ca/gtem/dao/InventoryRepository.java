package ca.gtem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ca.gtem.model.Inventory;

@RepositoryRestResource(path = "/inventories")
public interface InventoryRepository extends JpaRepository<Inventory,Long> {

}
