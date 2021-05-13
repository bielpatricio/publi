package br.com.matrix.publi.repository;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.matrix.publi.conta.User;

class FollowRepositoryTest {

	@Autowired
	private UserRepository repository;

	@Test
	void findByUsernameTest() {
		String username = "Gabrieltp087";
		User user = repository.findByUsername(username);
		Assert.assertNotNull(user);
		Assert.assertEquals(username, user.getUsername());
	}

}
