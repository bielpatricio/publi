package br.com.matrix.publi.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.matrix.publi.controller.dto.UserDto;
import br.com.matrix.publi.model.Follow;
import br.com.matrix.publi.model.User;
import br.com.matrix.publi.repository.FollowRepository;
import br.com.matrix.publi.repository.UserRepository;

@RestController
@RequestMapping("/follow")
public class FollowController {

	@Autowired
	private FollowRepository followRepository;

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/{seguindo_id}/{seguido_id}")
	@Transactional
	public ResponseEntity<?> seguir(@PathVariable("seguindo_id") Long seguindo_id,
			@PathVariable("seguido_id") Long seguido_id) {

		Optional<User> userSeguindo = userRepository.findById(seguindo_id);
		Optional<User> userSeguido = userRepository.findById(seguido_id);

		if (userSeguindo.isPresent() && userSeguido.isPresent()) {
			Follow follow_test = followRepository.findByUserSeguindoAndUserSeguido(userSeguindo.get(),
					userSeguido.get());
			if (follow_test == null) {
				Follow follow = new Follow(userSeguindo.get(), userSeguido.get());
				followRepository.save(follow);
				return ResponseEntity.status(201).build();
			} else {
				return ResponseEntity.status(403).build();
			}
		} else {
			return ResponseEntity.status(404).build();
		}

	}

	@DeleteMapping("/{seguindo_id}/{seguido_id}")
	@Transactional
	public ResponseEntity<?> UnFollow(@PathVariable("seguindo_id") Long seguindo_id,
			@PathVariable("seguido_id") Long seguido_id) {
		Optional<User> userSeguindo = userRepository.findById(seguindo_id);
		Optional<User> userSeguido = userRepository.findById(seguido_id);

		if (userSeguindo.isPresent() && userSeguido.isPresent()) {
			Follow follow_test = followRepository.findByUserSeguindoAndUserSeguido(userSeguindo.get(),
					userSeguido.get());
			if (follow_test != null) {
				followRepository.deleteById(follow_test.getId());
				return ResponseEntity.status(200).build();
			} else {
				return ResponseEntity.status(403).build();
			}

		} else {
			return ResponseEntity.status(404).build();
		}
	}

	@GetMapping("/{seguindo_id}/seguindo")
	public ResponseEntity<List<UserDto>> ListaSeguindo(@PathVariable("seguindo_id") Long seguindo_id) {

		Optional<User> user = userRepository.findById(seguindo_id);

		if (user.isPresent()) {
			List<UserDto> userDto = UserDto.converter(user.get().getUserSeguindo());

			return ResponseEntity.status(200).body(userDto);

		} else {
			return ResponseEntity.status(404).build();
		}
	}

	@GetMapping("/{seguido_id}/seguidores")
	public ResponseEntity<List<UserDto>> ListaSeguidores(@PathVariable("seguido_id") Long seguido_id) {

		Optional<User> user = userRepository.findById(seguido_id);

		if (user.isPresent()) {
			List<UserDto> userDto = UserDto.converter(user.get().getUserSeguido());

			return ResponseEntity.status(200).body(userDto);

		} else {
			return ResponseEntity.status(404).build();
		}
	}

}
