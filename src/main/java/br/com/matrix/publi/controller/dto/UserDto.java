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
	private List<Post> post = new ArrayList<>();
	private List<Follow> user_seguido = new ArrayList<>();
	private List<Follow> user_seguindo = new ArrayList<>();
	private List<Comentario> comentario = new ArrayList<>();
	private List<Like> like = new ArrayList<>();
	public Long getId() {
		return id;
	}
	public UserDto(User user) {
		this.username = user.getUsername();
		this.email = user.getEmail();
		this.senha = user.getSenha();
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
	public List<Post> getPost() {
		return post;
	}
	public List<Follow> getUser_seguido() {
		return user_seguido;
	}
	public List<Follow> getUser_seguindo() {
		return user_seguindo;
	}
	public List<Comentario> getComentario() {
		return comentario;
	}
	public List<Like> getLike() {
		return like;
	}

	
	public static List<UserDto> converter(List<User> user) {
		return user.stream().map(UserDto::new).collect(Collectors.toList());
	}
	
}
