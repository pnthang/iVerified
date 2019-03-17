package ca.gtem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ca.gtem.model.Order;

@RepositoryRestResource(path = "/oders")
public interface OrderRepository extends JpaRepository<Order,Long> {

}