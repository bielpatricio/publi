package br.com.matrix.publi.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.matrix.publi.conta.User;

public class UserForm {
	@NotNull @NotEmpty
	private String username;
	private String email;
	private String senha;
	
	
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
	
	public User converter() {
		return new User(username, email, senha);
	}

}
