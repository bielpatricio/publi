package br.com.matrix.publi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.matrix.publi.conta.Follow;
import br.com.matrix.publi.conta.User;

public interface FollowRepository extends JpaRepository<Follow, Long> {
	
	Follow findByUserSeguindoAndUserSeguido(User userSeguindo, User userSeguido);

}
