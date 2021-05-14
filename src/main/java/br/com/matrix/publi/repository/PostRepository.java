package br.com.matrix.publi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.matrix.publi.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
