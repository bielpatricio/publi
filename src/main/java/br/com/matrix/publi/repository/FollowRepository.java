package br.com.matrix.publi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.matrix.publi.conta.Follow;

public interface FollowRepository extends JpaRepository<Follow, Long> {

}
