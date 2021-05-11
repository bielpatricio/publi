package br.com.matrix.publi.controller.dto;

public class gitDto {
	private Long id;
	private String name;
	private String company;
	private String login;
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getLogin() {
		return login;
	}

}
