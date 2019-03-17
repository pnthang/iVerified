package ca.gtem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ca.gtem.model.OrderDetail;

@RepositoryRestResource(path = "/oder-detail")
public interface OderDetailRepository extends JpaRepository<OrderDetail,Long> {

}

