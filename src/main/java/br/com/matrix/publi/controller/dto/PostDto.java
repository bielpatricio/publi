package br.com.matrix.publi.controller.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.matrix.publi.model.Post;

public class PostDto {
	private Long id;
	private String mensagem;
	private UserDto user;
	private LocalDateTime dataPulicacao;
	private List<ComentarioDto> comentario = new ArrayList<>();
	private List<LikeDto> like = new ArrayList<>();
	private int TotalLikes;
	private int TotalComentarios;

	public PostDto(Post post) {
		this.id = post.getId();
		this.mensagem = post.getMensagem();
		this.user = new UserDto(post.getUser());
		this.dataPulicacao = post.getDataPulicacao();
		this.comentario.addAll(post.getComentario().stream().map(ComentarioDto::new).collect(Collectors.toList()));
		this.like.addAll(post.getLike().stream().map(LikeDto::new).collect(Collectors.toList()));
		this.TotalLikes = post.getLike().size();
		this.TotalComentarios = post.getComentario().size();
	}

	public String getMensagem() {
		return mensagem;
	}

	public LocalDateTime getDataPulicacao() {
		return dataPulicacao;
	}

	public List<ComentarioDto> getComentario() {
		return comentario;
	}

	public UserDto getUser() {
		return user;
	}

	public Long getId() {
		return id;
	}

	public List<LikeDto> getLike() {
		return like;
	}

	public static List<PostDto> converter(List<Post> post) {
		return post.stream().map(PostDto::new).collect(Collectors.toList());
	}

	public int getTotalLikes() {
		return TotalLikes;
	}

	public int getTotalComentarios() {
		return TotalComentarios;
	}

}
