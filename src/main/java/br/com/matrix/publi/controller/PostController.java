package br.com.matrix.publi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.matrix.publi.conta.Post;
import br.com.matrix.publi.controller.dto.PostDto;
import br.com.matrix.publi.controller.form.PostForm;
import br.com.matrix.publi.repository.PostRepository;

@RestController
@RequestMapping("/post")
public class PostController {
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping
	public List<PostDto> lista() {
		List<Post> post = postRepository.findAll();
		return PostDto.converter(post);
	}
	
	@PostMapping
	public void publicar(@RequestBody PostForm form){
		Post post = form.converter();
		postRepository.save(post);
	}
	
}
