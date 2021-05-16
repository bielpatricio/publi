package br.com.matrix.publi.controller.dto;

import br.com.matrix.publi.model.User;

public class UserGitDto {
	private Long id;
	private String name;
	private String userGit;
	private String company;

	public UserGitDto(User user, GitDto gitdto) {
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
