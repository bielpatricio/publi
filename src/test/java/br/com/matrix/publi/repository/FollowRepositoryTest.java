package br.com.matrix.publi.repository;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.matrix.publi.model.Follow;
import br.com.matrix.publi.model.User;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
class FollowRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private FollowRepository followRepository;

	@Test
	void findByUserSeguindoAndUserSeguidoTest() {
		User user1 = userRepository.getOne((long) 1);
		User user2 = userRepository.getOne((long) 2);
		Follow follow = followRepository.findByUserSeguindoAndUserSeguido(user1, user2);
		Assert.assertNotNull(follow);

	}

	@Test
	void NotFindByUserSeguindoAndUserSeguidoTest() {
		User user1 = userRepository.getOne((long) 1);
		User user2 = userRepository.getOne((long) 4);
		Follow follow = followRepository.findByUserSeguindoAndUserSeguido(user1, user2);
		Assert.assertNull(follow);

	}

}
