package br.com.matrix.publi.repository;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.matrix.publi.model.Like;
import br.com.matrix.publi.model.Post;
import br.com.matrix.publi.model.User;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
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
	}

	@Test
	void NotfindByUserAndPostTest() {

		User user = userRepository.getOne((long) 1);
		Post post = postRepository.getOne((long) 4);
		Like like = likeRepository.findByUserAndPost(user, post);
		Assert.assertNull(like);
	}

	@Test
	void NotfindByUserAndPostTest2() {

		User user = userRepository.getOne((long) 4);
		Post post = postRepository.getOne((long) 1);
		Like like = likeRepository.findByUserAndPost(user, post);
		Assert.assertNull(like);
	}
}
