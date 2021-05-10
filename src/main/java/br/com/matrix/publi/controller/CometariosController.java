package br.com.matrix.publi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.matrix.publi.conta.Comentario;
import br.com.matrix.publi.controller.dto.ComentarioDto;
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

}
