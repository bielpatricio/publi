package br.com.matrix.publi.conta;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Post {
	private Long id;
	private String mensagem;
	private User autor;
	private LocalDateTime dataPulicacao;
	private List<Comentario> comentario = new ArrayList<>();
	private List<Like> like = new ArrayList<>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public User getAutor() {
		return autor;
	}
	public void setAutor(User autor) {
		this.autor = autor;
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
