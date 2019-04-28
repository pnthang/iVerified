package ca.gtem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ca.gtem.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
	public User findByUsername(String username);
	public User findByEmail(String email);
}

