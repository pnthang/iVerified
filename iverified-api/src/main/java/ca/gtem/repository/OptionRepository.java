package ca.gtem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ca.gtem.model.Option;

public interface OptionRepository extends JpaRepository<Option,Long> {

}
