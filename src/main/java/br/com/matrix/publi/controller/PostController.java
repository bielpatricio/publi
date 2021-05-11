package br.com.matrix.publi.controller;

import java.net.URI;
import java.util.List;

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
	
	@PostMapping
	@Transactional
	public ResponseEntity<PostDto> publicar(@RequestBody @Validated PostForm form, UriComponentsBuilder uriBuilder){
		User user = userRepository.getOne(form.getUser_id());
		Post post = form.converter(user);
		postRepository.save(post);
		
		URI uri = uriBuilder.path("/post/{id}").buildAndExpand(post.getId()).toUri();
		return ResponseEntity.created(uri).body(new PostDto(post));
	}
	
	@GetMapping("/{id}")
	public PostDto especificar(@PathVariable Long id) {
		Post post = postRepository.getOne(id);
		return new PostDto(post);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id){
		postRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
