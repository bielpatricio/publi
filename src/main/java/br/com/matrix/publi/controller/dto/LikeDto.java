package br.com.matrix.publi.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.matrix.publi.conta.Like;

public class LikeDto {

	private Long id;
	private UserDto user;

	public LikeDto(Like like) {
		this.id = like.getId();
		this.user = new UserDto(like.getUser());
	}

	public Long getId() {
		return id;
	}

	public UserDto getUser() {
		return user;
	}

	public static List<LikeDto> converter(List<Like> like) {
		return like.stream().map(LikeDto::new).collect(Collectors.toList());
	}
}
