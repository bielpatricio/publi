package br.com.matrix.publi.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.matrix.publi.model.Follow;
import br.com.matrix.publi.model.User;

public interface FollowRepository extends JpaRepository<Follow, Long> {
	
	Follow findByUserSeguindoAndUserSeguido(User userSeguindo, User userSeguido);

}
