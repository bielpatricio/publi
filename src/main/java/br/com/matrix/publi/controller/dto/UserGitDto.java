package br.com.matrix.publi.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.matrix.publi.conta.Comentario;
import br.com.matrix.publi.conta.User;

public class UserGitDto {
	private Long id;
	private String name;
	private String userGit;
	private String company;
	
	
	
	
	public UserGitDto(User user, gitDto gitdto) {
		this.id = user.getId();
		this.name = gitdto.getName();
		this.userGit = gitdto.getLogin();
		this.company = gitdto.getCompany();
	}
	public String getCompany() {
		return company;
	}
	public Long getId() {
		return id;
	}
	public String getUserGit() {
		return userGit;
	}
	public String getName() {
		return name;
	}
	
	
}
