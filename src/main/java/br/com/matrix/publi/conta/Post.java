package br.com.matrix.publi.conta;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Post {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String mensagem;
//	@ManyToOne
//	private User user;
	private LocalDateTime dataPulicacao;
	@OneToMany(mappedBy = "post")
	private List<Comentario> comentario = new ArrayList<>();
	@OneToMany(mappedBy = "post")
	private List<Like> like = new ArrayList<>();
	
	public Post() {
		
	}
	public Post(/*User user,*/ String mensagem) {
		this.mensagem = mensagem;
//		this.user = user;
	}
	
	public Long getId() {
		return id;
	}
	public String getMensagem() {
		return mensagem;
	}
//	public User getUser() {
//		return user;
//	}
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
