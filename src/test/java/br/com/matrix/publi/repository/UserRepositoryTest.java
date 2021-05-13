package br.com.matrix.publi.repository;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.matrix.publi.conta.User;

@RunWith(SpringRunner.class)
@DataJpaTest
class UserRepositoryTest {
	
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
