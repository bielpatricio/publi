package br.com.matrix.publi.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.matrix.publi.model.Comentario;
import br.com.matrix.publi.model.Post;
import br.com.matrix.publi.model.User;

public class ComentarioForm {
	@NotNull
	@NotEmpty
	private String mensagem;
	@NotNull
	@NotEmpty
	private Long user_id;
	@NotNull
	@NotEmpty
	private Long post_id;

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Long getPost_id() {
		return post_id;
	}

	public void setPost_id(Long post_id) {
		this.post_id = post_id;
	}

	public Comentario converter(User user, Post post) {
		return new Comentario(user, post, mensagem);
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

}
