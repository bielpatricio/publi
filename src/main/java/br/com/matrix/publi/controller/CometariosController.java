package br.com.matrix.publi.controller;

import java.net.URI;
import java.util.List;

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
import br.com.matrix.publi.controller.dto.ComentarioDto;
import br.com.matrix.publi.controller.dto.PostDto;
import br.com.matrix.publi.controller.form.ComentarioForm;
import br.com.matrix.publi.controller.form.PostForm;
import br.com.matrix.publi.repository.ComentarioRepository;

@RestController
@RequestMapping("/comentarios")
public class CometariosController {
	
	@Autowired
	private ComentarioRepository comentarioRepository;
	
	@GetMapping
	public List<ComentarioDto> lista() {
		List<Comentario> comentario = comentarioRepository.findAll();
		return ComentarioDto.converter(comentario);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<ComentarioDto> publicarComent(@RequestBody ComentarioForm form, UriComponentsBuilder uriBuilder){
		Comentario comentario = form.converter();
		comentarioRepository.save(comentario);
		
		URI uri = uriBuilder.path("/comentarios/{id}").buildAndExpand(comentario.getId()).toUri();
		return ResponseEntity.created(uri).body(new ComentarioDto(comentario));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id){
		comentarioRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
