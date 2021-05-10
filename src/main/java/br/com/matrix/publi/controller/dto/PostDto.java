package br.com.matrix.publi.controller.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.matrix.publi.conta.Comentario;
import br.com.matrix.publi.conta.Like;
import br.com.matrix.publi.conta.Post;
import br.com.matrix.publi.conta.User;

public class PostDto {
	private Long id;
	private String mensagem;
//	private User user;
	private LocalDateTime dataPulicacao;
	private List<Comentario> comentario = new ArrayList<>();
	private List<Like> like = new ArrayList<>();
	
	public PostDto(Post post) {
		this.mensagem = post.getMensagem();
//		this.user = post.getUser();
	}

	public String getMensagem() {
		return mensagem;
	}

	public LocalDateTime getDataPulicacao() {
		return dataPulicacao;
	}

	public List<Comentario> getComentario() {
		return comentario;
	}

//	public User getUser() {
//		return user;
//	}

	public Long getId() {
		return id;
	}

	public List<Like> getLike() {
		return like;
	}
	public static List<PostDto> converter(List<Post> post) {
		return post.stream().map(PostDto::new).collect(Collectors.toList());
	}
	
}
