package br.com.matrix.publi.controller.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.matrix.publi.conta.Comentario;
import br.com.matrix.publi.conta.Follow;
import br.com.matrix.publi.conta.Like;
import br.com.matrix.publi.conta.Post;
import br.com.matrix.publi.conta.User;

public class UserDto {
	private Long id;
	private String username;
	private String email;
	private String senha;
	private List<PostDto> post = new ArrayList<>();
	private List<UserDto> userSeguido = new ArrayList<>();
	private List<UserDto> userSeguindo = new ArrayList<>();
	private List<ComentarioDto> comentario = new ArrayList<>();
	private List<LikeDto> like = new ArrayList<>();
	public Long getId() {
		return id;
	}
	public UserDto(User user) {
		this.id = user.getId();
		this.username = user.getUsername();
		this.email = user.getEmail();
		this.senha = user.getSenha();
		this.userSeguido.addAll(user.getUserSeguido().stream().map(UserDto::new).collect(Collectors.toList()));
		this.userSeguindo.addAll(user.getUserSeguindo().stream().map(UserDto::new).collect(Collectors.toList()));
		this.comentario.addAll(user.getComentario().stream().map(ComentarioDto::new).collect(Collectors.toList()));
		this.like.addAll(user.getLike().stream().map(LikeDto::new).collect(Collectors.toList()));
		
	}
	public String getUsername() {
		return username;
	}
	public String getEmail() {
		return email;
	}
	public String getSenha() {
		return senha;
	}
	public List<PostDto> getPost() {
		return post;
	}
	public List<UserDto> getUserSeguido() {
		return userSeguido;
	}
	public List<UserDto> getUserSeguindo() {
		return userSeguindo;
	}
	public List<ComentarioDto> getComentario() {
		return comentario;
	}
	public List<LikeDto> getLike() {
		return like;
	}

	
	public static List<UserDto> converter(List<User> user) {
		return user.stream().map(UserDto::new).collect(Collectors.toList());
	}
	
}
