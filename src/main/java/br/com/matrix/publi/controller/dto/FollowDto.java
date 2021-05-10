package br.com.matrix.publi.controller.dto;


import java.util.List;
import java.util.stream.Collectors;

import br.com.matrix.publi.conta.Follow;
import br.com.matrix.publi.conta.User;

public class FollowDto {
	private Long id;
	private User user_seguido;
	private User user_seguindo;
	
	public FollowDto(Follow follow) {
		this.user_seguido = follow.getUser_seguido();
		this.user_seguindo = follow.getUser_seguindo();
	}
	
	public Long getId() {
		return id;
	}
	public User getUser_seguido() {
		return user_seguido;
	}
	public User getUser_seguindo() {
		return user_seguindo;
	}
	
	public static List<FollowDto> converter(List<Follow> follow) {
		return follow.stream().map(FollowDto::new).collect(Collectors.toList());
	}

}
