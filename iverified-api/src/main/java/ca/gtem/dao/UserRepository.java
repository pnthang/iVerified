package ca.gtem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ca.gtem.model.User;

@RepositoryRestResource(path = "/users")
public interface UserRepository extends JpaRepository<User,Long> {

}

