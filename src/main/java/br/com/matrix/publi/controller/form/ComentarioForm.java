package br.com.matrix.publi.controller.form;

import br.com.matrix.publi.conta.Comentario;

public class ComentarioForm {
	
	private String mensagem;
	private Long post_id;

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Comentario converter() {
		return new Comentario(mensagem);
	}

	public Long getPost_id() {
		return post_id;
	}

	public void setPost_id(Long post_id) {
		this.post_id = post_id;
	}

}
