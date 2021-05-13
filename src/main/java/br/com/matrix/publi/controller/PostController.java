package br.com.matrix.publi.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.matrix.publi.conta.Post;
import br.com.matrix.publi.conta.User;
import br.com.matrix.publi.controller.dto.PostDto;
import br.com.matrix.publi.controller.form.PostForm;
import br.com.matrix.publi.repository.PostRepository;
import br.com.matrix.publi.repository.UserRepository;

@RestController
@RequestMapping("/post")
public class PostController {
	@Autowired
	private PostRepository postRepository;

	@Autowired
	private UserRepository userRepository;

	@GetMapping
	public List<PostDto> lista() {
		List<Post> post = postRepository.findAll();
		return PostDto.converter(post);
	}

	@PostMapping("/{user_id}")
	@Transactional
	public ResponseEntity<PostDto> publicar(@RequestBody @Validated PostForm form, UriComponentsBuilder uriBuilder,
			@PathVariable("user_id") Long user_id) {
		User user = userRepository.getOne(user_id);
		Post post = form.converter(user);
		postRepository.save(post);

		URI uri = uriBuilder.path("/post/{user_id}").buildAndExpand(post.getId()).toUri();
		return ResponseEntity.created(uri).body(new PostDto(post));
	}

	@GetMapping("/{post_id}")
	public ResponseEntity<PostDto> especificar(@PathVariable("post_id") Long post_id) {

		Optional<Post> post = postRepository.findById(post_id);

		if (post.isPresent()) {
			PostDto postDto = new PostDto(post.get());

			return ResponseEntity.status(200).body(postDto);
		} else {
			return ResponseEntity.status(404).build();
		}
	}

	@DeleteMapping("/{post_id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable("post_id") Long post_id) {
		Post post = postRepository.getOne(post_id);

		if (post != null) {
			postRepository.deleteById(post.getId());
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
}
