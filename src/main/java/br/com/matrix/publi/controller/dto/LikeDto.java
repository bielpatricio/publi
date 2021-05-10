package br.com.matrix.publi.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.matrix.publi.conta.Like;
import br.com.matrix.publi.conta.Post;
import br.com.matrix.publi.conta.User;

public class LikeDto {

	private Long id;
	private User user;
	private Post post;
	
	public LikeDto(Like like) {
		
	}
	public Long getId() {
		return id;
	}
	public User getUser() {
		return user;
	}
	public Post getPost() {
		return post;
	}
	
	public static List<LikeDto> converter(List<Like> like) {
		return like.stream().map(LikeDto::new).collect(Collectors.toList());
	}
}
