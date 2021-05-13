package br.com.matrix.publi.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.matrix.publi.conta.User;

public class UserDto {
	private Long id;
	private String username;
	private String email;
	private String senha;
	private int TotalSeguidores;
	private int TotalSeguindo;

	public Long getId() {
		return id;
	}

	public UserDto(User user) {
		this.id = user.getId();
		this.username = user.getUsername();
		this.email = user.getEmail();
		this.senha = user.getSenha();
		this.TotalSeguindo = user.getUserSeguindo().size();
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public static List<UserDto> converter(List<User> user) {
		return user.stream().map(UserDto::new).collect(Collectors.toList());
	}

	public int getTotalSeguindo() {
		return TotalSeguindo;
	}

	public int getTotalSeguidores() {
		return TotalSeguidores;
	}

}
