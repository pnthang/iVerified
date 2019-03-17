package ca.gtem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ca.gtem.model.Transportor;

@RepositoryRestResource(path = "/transportors")
public interface TransportorRepository extends JpaRepository<Transportor,Long> {

}