package br.com.matrix.publi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.matrix.publi.conta.Like;

public interface LikeRepository extends JpaRepository<Like, Long> {

}
