package br.com.matrix.publi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.matrix.publi.conta.User;
import br.com.matrix.publi.controller.dto.UserDto;
import br.com.matrix.publi.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public List<UserDto> lista(String username) {
		
		if (username == null) {
			List<User> user = userRepository.findAll();
			return UserDto.converter(user);
		} else {
			List<User> user = userRepository.findByUsername(username);
			return UserDto.converter(user);
		}
	}

}
