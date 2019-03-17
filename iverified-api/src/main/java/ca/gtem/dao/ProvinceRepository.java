package ca.gtem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ca.gtem.model.Province;

@RepositoryRestResource(path = "/provinces")
public interface ProvinceRepository extends JpaRepository<Province,Long> {

}
