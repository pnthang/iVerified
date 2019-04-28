package ca.gtem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import ca.gtem.model.Producer;

public interface ProducerRepository extends JpaRepository<Producer,Long> {

}

