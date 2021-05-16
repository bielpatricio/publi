package br.com.matrix.publi.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.matrix.publi.controller.dto.UserDto;
import br.com.matrix.publi.controller.dto.UserGitDto;
import br.com.matrix.publi.controller.dto.GitDto;
import br.com.matrix.publi.controller.form.UserForm;
import br.com.matrix.publi.model.User;
import br.com.matrix.publi.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping
	@Cacheable(value = "userList")
	public List<UserDto> lista(String username) {

		List<User> user = userRepository.findAll();
		return UserDto.converter(user);
	}

	@GetMapping("/github/{user}")
	public UserGitDto listarUserGit(@PathVariable("user") String user) {
		RestTemplate restTemplate = new RestTemplate();
		GitDto userGit = restTemplate.getForObject("https://api.github.com/users/" + user, GitDto.class);

		User userR = userRepository.findByUsername(user);
		UserGitDto userGitDto = new UserGitDto(userR, userGit);
		return userGitDto;
	}

	@PostMapping
	@Transactional
	@CacheEvict(value = "userList", allEntries = true)
	public ResponseEntity<UserDto> cadastrar(@RequestBody @Valid UserForm form, UriComponentsBuilder uriBuilder) {
		User user = form.converter();
		userRepository.save(user);

		URI uri = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).body(new UserDto(user));
	}

	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "userList", allEntries = true)
	public ResponseEntity<?> remover(@PathVariable Long id) {

		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			userRepository.deleteById(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.status(404).build();
		}
	}

}
