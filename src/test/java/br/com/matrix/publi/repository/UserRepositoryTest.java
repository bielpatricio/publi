package br.com.matrix.publi.repository;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.matrix.publi.model.User;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	@Test
	void findByUsernameTest() {

		String username = "Robertin";
		User user = userRepository.findByUsername(username);
		Assert.assertNotNull(user);
		Assert.assertEquals(username, user.getUsername());
	}

	@Test
	void NotfindByUsernameTest() {

		String username = "Robertina";
		User user = userRepository.findByUsername(username);
		Assert.assertNull(user);
	}

}
