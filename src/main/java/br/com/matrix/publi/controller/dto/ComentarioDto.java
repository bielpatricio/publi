package br.com.matrix.publi.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.matrix.publi.conta.Comentario;
import br.com.matrix.publi.conta.User;

public class ComentarioDto {
	private Long id;
	private String mensagem;
	private UserDto autor;
	private LocalDateTime dataCriacao = LocalDateTime.now();
	private String nomeUser;
	
	public ComentarioDto(Comentario comentario) {
		this.id = comentario.getId();
		this.mensagem = comentario.getMensagem();
		this.autor = new UserDto(comentario.getUser());
		this.dataCriacao = comentario.getDataCriacao();
		this.nomeUser = comentario.getUser().getUsername();
	}
	
	public Long getId() {
		return id;
	}
	public String getMensagem() {
		return mensagem;
	}
	public UserDto getAutor() {
		return autor;
	}
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public static List<ComentarioDto> converter(List<Comentario> comentario) {
		return comentario.stream().map(ComentarioDto::new).collect(Collectors.toList());
	}

	public String getNomeUser() {
		return nomeUser;
	}
	
	
	
}
