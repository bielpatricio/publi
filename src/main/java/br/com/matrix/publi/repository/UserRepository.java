package br.com.matrix.publi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.matrix.publi.conta.User;

public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findByUsername(String username);

}
