package br.com.matrix.publi.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.matrix.publi.conta.Like;
import br.com.matrix.publi.conta.Post;
import br.com.matrix.publi.conta.User;

public class LikeDto {

	private Long id;
	private UserDto user;
	private PostDto post;
	
	public LikeDto(Like like) {
		this.id = like.getId();
		this.user = new UserDto(like.getUser());
		this.post = new PostDto(like.getPost());
	}
	public Long getId() {
		return id;
	}
	public UserDto getUser() {
		return user;
	}
	public PostDto getPost() {
		return post;
	}
	
	public static List<LikeDto> converter(List<Like> like) {
		return like.stream().map(LikeDto::new).collect(Collectors.toList());
	}
}
