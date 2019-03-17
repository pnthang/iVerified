package ca.gtem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ca.gtem.model.Unit;

@RepositoryRestResource(path = "/packages")
public interface PackageRepository extends JpaRepository<Unit,Long> {

}