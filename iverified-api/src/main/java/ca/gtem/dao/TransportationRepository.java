package ca.gtem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ca.gtem.model.Transportation;

@RepositoryRestResource(path = "/transportations")
public interface TransportationRepository extends JpaRepository<Transportation,Long> {

}

