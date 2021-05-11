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

import br.com.matrix.publi.conta.Like;
import br.com.matrix.publi.conta.Post;
import br.com.matrix.publi.conta.User;
import br.com.matrix.publi.controller.dto.LikeDto;
import br.com.matrix.publi.repository.LikeRepository;
import br.com.matrix.publi.repository.PostRepository;
import br.com.matrix.publi.repository.UserRepository;

@RestController
@RequestMapping("/likes")
public class LikeController {
	@Autowired
	private LikeRepository likeRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public List<LikeDto> lista() {
		List<Like> like = likeRepository.findAll();
		return LikeDto.converter(like);
	}

	
	@PostMapping("/{user_id}/{post_id}")
	@Transactional
	public ResponseEntity<?> seguir(@PathVariable("user_id") Long user_id, @PathVariable("post_id") Long post_id){
		
		Post post = postRepository.getOne(post_id);
		User user = userRepository.getOne(user_id);
		
		Like like_test = likeRepository.findByUserAndPost(user, post);
		
		System.out.println(like_test);
		if(like_test==null) {
			Like like = new Like(user, post);
			likeRepository.save(like);
		}
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{user_id}/{post_id}")
	@Transactional
	public ResponseEntity<?> remover_like(@PathVariable("user_id") Long user_id, @PathVariable("post_id") Long post_id){
		Post post = postRepository.getOne(post_id);
		User user = userRepository.getOne(user_id);
		
		Like like_test = likeRepository.findByUserAndPost(user, post);
		if(like_test!=null) {
			likeRepository.deleteById(like_test.getId());
		}
		return ResponseEntity.ok().build();
	}
}
