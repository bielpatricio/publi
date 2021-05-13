package br.com.matrix.publi.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.matrix.publi.conta.Comentario;
import br.com.matrix.publi.conta.Post;
import br.com.matrix.publi.conta.User;
import br.com.matrix.publi.controller.dto.ComentarioDto;
import br.com.matrix.publi.controller.form.ComentarioForm;
import br.com.matrix.publi.repository.ComentarioRepository;
import br.com.matrix.publi.repository.PostRepository;
import br.com.matrix.publi.repository.UserRepository;

@RestController
@RequestMapping("/comentario")
public class CometariosController {

	@Autowired
	private ComentarioRepository comentarioRepository;

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private UserRepository userRepository;

	@GetMapping
	public List<ComentarioDto> lista() {
		List<Comentario> comentario = comentarioRepository.findAll();
		return ComentarioDto.converter(comentario);
	}

	@PostMapping("/{user_id}/{post_id}")
	@Transactional
	public ResponseEntity<ComentarioDto> publicarComent(@RequestBody ComentarioForm form,
			UriComponentsBuilder uriBuilder, @PathVariable("user_id") Long user_id,
			@PathVariable("post_id") Long post_id) {

		Post post = postRepository.getOne(form.getPost_id());
		User user = userRepository.getOne(form.getUser_id());

		Comentario comentario = form.converter(user, post);
		comentarioRepository.save(comentario);

		URI uri = uriBuilder.path("/comentario/{user_id}/{post_id}s").buildAndExpand(comentario.getId()).toUri();
		return ResponseEntity.created(uri).body(new ComentarioDto(comentario));
	}

	@GetMapping("/{post_id}/{id}")
	public ResponseEntity<ComentarioDto> especificar(@PathVariable("post_id") Long post_id,
			@PathVariable("id") Long id) {

		Optional<Post> post = postRepository.findById(post_id);
		Optional<Comentario> comentario = comentarioRepository.findById(id);

		if (post.isPresent())
			if (comentario.isPresent()) {
				ComentarioDto comentarioDto = new ComentarioDto(comentario.get());
				return ResponseEntity.status(200).body(comentarioDto);
			} else {
				return ResponseEntity.status(404).build();
			}
		else {
			return ResponseEntity.status(404).build();
		}

	}

	@GetMapping("{post_id}/comentarios")
	public ResponseEntity<List<ComentarioDto>> especificar(@PathVariable("post_id") Long post_id) {

		Optional<Post> post = postRepository.findById(post_id);

		if (post.isPresent()) {
			List<ComentarioDto> comentarioDto = ComentarioDto.converter(post.get().getComentario());

			return ResponseEntity.status(200).body(comentarioDto);

		} else {
			return ResponseEntity.status(404).build();
		}

	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable("id") Long id) {
		Comentario comentario = comentarioRepository.getOne(id);

		if (comentario != null) {
			comentarioRepository.deleteById(comentario.getId());
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

}
