package br.com.matrix.publi.repository;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.matrix.publi.conta.Like;
import br.com.matrix.publi.conta.Post;
import br.com.matrix.publi.conta.User;

class LikeRepositoryTest {

	@Autowired
	private LikeRepository likeRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@Test
	void findByUserAndPostTest() {

		User user = userRepository.getOne((long) 1);
		Post post = postRepository.getOne((long) 1);
		Like like = likeRepository.findByUserAndPost(user, post);
		Assert.assertNotNull(like);
		Assert.assertEquals("1", like.getId());
	}
}
