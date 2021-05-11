package br.com.matrix.publi.controller.dto;


import java.util.List;
import java.util.stream.Collectors;

import br.com.matrix.publi.conta.Follow;
import br.com.matrix.publi.conta.User;

public class FollowDto {
	private Long id;
	private UserDto userSeguido;
	private UserDto userSeguindo;
	
	public FollowDto(Follow follow) {
		this.id = follow.getId();
		this.userSeguido = new UserDto(follow.getUserSeguido());
		this.userSeguindo = new UserDto(follow.getUserSeguindo());
	}
	
	public Long getId() {
		return id;
	}
	public UserDto getUserSeguido() {
		return userSeguido;
	}
	public UserDto getUserSeguindo() {
		return userSeguindo;
	}
	
	public static List<FollowDto> converter(List<Follow> follow) {
		return follow.stream().map(FollowDto::new).collect(Collectors.toList());
	}

}
