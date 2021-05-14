package br.com.matrix.publi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.matrix.publi.model.Like;
import br.com.matrix.publi.model.Post;
import br.com.matrix.publi.model.User;

public interface LikeRepository extends JpaRepository<Like, Long> {
	
	Like findByUserAndPost(User user, Post post);

}
