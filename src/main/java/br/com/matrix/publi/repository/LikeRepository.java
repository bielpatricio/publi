package br.com.matrix.publi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.matrix.publi.conta.Follow;
import br.com.matrix.publi.conta.Like;
import br.com.matrix.publi.conta.Post;
import br.com.matrix.publi.conta.User;

public interface LikeRepository extends JpaRepository<Like, Long> {
	
	Like findByUserAndPost(User user, Post post);

}
