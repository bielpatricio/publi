package br.com.matrix.publi.conta;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String email;
	private String senha;
	
	@OneToMany(mappedBy = "user")
	private List<Post> post = new ArrayList<>();
	
	@OneToMany(mappedBy = "user_seguido")
	private List<Follow> user_seguido = new ArrayList<>();
	@OneToMany(mappedBy = "user_seguindo")
	private List<Follow> user_seguindo = new ArrayList<>();
	
	@OneToMany(mappedBy = "user")
	private List<Comentario> comentario = new ArrayList<>();
	@OneToMany(mappedBy = "user")
	private List<Like> like = new ArrayList<>();
	
	
	public User() {
		
	}
	public User(String username, String email, String senha) {
		this.username = username;
		this.email = email;
		this.senha = senha;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public List<User> getUser_seguido() {
		List<User> users = new ArrayList<>();
		user_seguido.forEach(follow -> {
			users.add(follow.getUser_seguido());
		});
		return users;
	}
	public void setUser_seguido(List<Follow> user_seguido) {
		this.user_seguido = user_seguido;
	}
	public List<User> getUser_seguindo() {
		List<User> users = new ArrayList<>();
		user_seguindo.forEach(follow -> {
			users.add(follow.getUser_seguindo());
		});
		return users;
	}
	public void setUser_seguindo(List<Follow> user_seguindo) {
		this.user_seguindo = user_seguindo;
	}

	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}
	public List<Comentario> getComentario() {
		return comentario;
	}
	public void setComentario(List<Comentario> comentario) {
		this.comentario = comentario;
	}
	public List<Like> getLike() {
		return like;
	}
	public void setLike(List<Like> like) {
		this.like = like;
	}
	
	
	
}
