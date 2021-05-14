package br.com.matrix.publi.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "Post")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String mensagem;
	@ManyToOne
	private User user;
	@OneToMany(mappedBy = "post", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Comentario> comentario = new ArrayList<>();
	@OneToMany(mappedBy = "post", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Like> like = new ArrayList<>();
	private LocalDateTime dataPulicacao = LocalDateTime.now();

	public Post() {

	}

	public Post(User user, String mensagem) {
		this.mensagem = mensagem;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public String getMensagem() {
		return mensagem;
	}

	public User getUser() {
		return user;
	}

	public LocalDateTime getDataPulicacao() {
		return dataPulicacao;
	}

	public void setDataPulicacao(LocalDateTime dataPulicacao) {
		this.dataPulicacao = dataPulicacao;
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
