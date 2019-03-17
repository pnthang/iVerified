package ca.gtem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ca.gtem.model.Country;

@RepositoryRestResource(path = "/countries")
public interface CountryRepository extends JpaRepository<Country,Long> {

}
