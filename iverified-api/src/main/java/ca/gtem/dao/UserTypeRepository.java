package ca.gtem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ca.gtem.model.UserType;

@RepositoryRestResource(path = "/user-type")
public interface UserTypeRepository extends JpaRepository<UserType,Long> {

}
