package ca.gtem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ca.gtem.model.City;

@RepositoryRestResource(path = "/cities")
public interface CityRepository extends JpaRepository<City,Long> {

}
