package br.com.matrix.publi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.matrix.publi.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

}
