package br.com.matrix.publi.controller.form;

import br.com.matrix.publi.conta.Post;
import br.com.matrix.publi.repository.PostRepository;

public class PostForm {
	private String mensagem;

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Post converter() {
		return new Post(mensagem);
	}
}
