package br.com.matrix.publi.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.matrix.publi.conta.Follow;
import br.com.matrix.publi.conta.User;
import br.com.matrix.publi.controller.dto.FollowDto;
import br.com.matrix.publi.controller.dto.UserDto;
import br.com.matrix.publi.repository.FollowRepository;
import br.com.matrix.publi.repository.UserRepository;

@RestController
@RequestMapping("/follow")
public class FollowController {
	
	@Autowired
	private FollowRepository followRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public List<FollowDto> lista() {
		List<Follow> follow = followRepository.findAll();
		return FollowDto.converter(follow);
	}
	
	@PostMapping("/{seguindo_id}/{seguido_id}")
	@Transactional
	public ResponseEntity<?> seguir(@PathVariable("seguindo_id") Long seguindo_id, @PathVariable("seguido_id") Long seguido_id){
		
		User userSeguindo = userRepository.getOne(seguindo_id);
		User userSeguido = userRepository.getOne(seguido_id);
		
		Follow follow_test = followRepository.findByUserSeguindoAndUserSeguido(userSeguindo, userSeguido);
		System.out.println(follow_test);
		if(follow_test==null) {
			Follow follow = new Follow(userSeguindo, userSeguido);
			followRepository.save(follow);
			
		}
		
		return ResponseEntity.ok().build();
			
	}
	
	
	@DeleteMapping("/{seguindo_id}/{seguido_id}")
	@Transactional
	public ResponseEntity<?> UnFollow(@PathVariable("seguindo_id") Long seguindo_id, @PathVariable("seguido_id") Long seguido_id){
		User userSeguindo = userRepository.getOne(seguindo_id);
		User userSeguido = userRepository.getOne(seguido_id);
		Follow follow_test = followRepository.findByUserSeguindoAndUserSeguido(userSeguindo, userSeguido);
		if(follow_test!=null) {
			followRepository.deleteById(follow_test.getId());
		}
		
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{seguindo_id}/seguindo")
	public ResponseEntity<List<UserDto>> ListaSeguindo(@PathVariable("seguindo_id") Long seguindo_id) {
		User user = userRepository.getOne(seguindo_id);
		return ResponseEntity.ok().body(UserDto.converter(user.getUserSeguindo()));
	}
	
	@GetMapping("/{seguido_id}/seguidores")
	public ResponseEntity<List<UserDto>> ListaSeguidores(@PathVariable("seguido_id") Long seguido_id) {
		User user = userRepository.getOne(seguido_id);
		return ResponseEntity.ok().body(UserDto.converter(user.getUserSeguido()));
	}

}
