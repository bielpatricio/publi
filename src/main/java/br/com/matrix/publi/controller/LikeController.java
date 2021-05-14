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

import br.com.matrix.publi.controller.dto.LikeDto;
import br.com.matrix.publi.model.Like;
import br.com.matrix.publi.model.Post;
import br.com.matrix.publi.model.User;
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
	public ResponseEntity<?> seguir(@PathVariable("user_id") Long user_id, @PathVariable("post_id") Long post_id) {

		Optional<Post> post = postRepository.findById(post_id);
		Optional<User> user = userRepository.findById(user_id);

		Like like_test = likeRepository.findByUserAndPost(user.get(), post.get());

		System.out.println(like_test);
		if (post.isPresent() && user.isPresent()) {
			Like like = new Like(user.get(), post.get());
			likeRepository.save(like);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.badRequest().build();
		}

	}

	@DeleteMapping("/{user_id}/{post_id}")
	@Transactional
	public ResponseEntity<?> remover_like(@PathVariable("user_id") Long user_id,
			@PathVariable("post_id") Long post_id) {
		Optional<Post> post = postRepository.findById(post_id);
		Optional<User> user = userRepository.findById(user_id);

		Like like_test = likeRepository.findByUserAndPost(user.get(), post.get());
		System.out.println(like_test);
		if (post.isPresent() && user.isPresent()) {
			likeRepository.deleteById(like_test.getId());
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping("{post_id}/likes")
	public ResponseEntity<List<LikeDto>> especificar(@PathVariable("post_id") Long post_id) {

		Optional<Post> post = postRepository.findById(post_id);

		if (post.isPresent()) {
			List<LikeDto> likeDto = LikeDto.converter(post.get().getLike());

			return ResponseEntity.status(200).body(likeDto);

		} else {
			return ResponseEntity.status(404).build();
		}

	}
}
