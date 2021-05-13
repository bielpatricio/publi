package br.com.matrix.publi.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.matrix.publi.conta.Post;
import br.com.matrix.publi.conta.User;

public class PostForm {

	@NotNull
	@NotEmpty
	private String mensagem;
	private Long user_id;

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Post converter(User user) {
		return new Post(user, mensagem);
	}

}
