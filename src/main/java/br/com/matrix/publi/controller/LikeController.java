package br.com.matrix.publi.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.matrix.publi.conta.Like;
import br.com.matrix.publi.controller.dto.LikeDto;
import br.com.matrix.publi.repository.LikeRepository;

@RestController
@RequestMapping("/likes")
public class LikeController {
	@Autowired
	private LikeRepository likeRepository;
	
	@GetMapping
	public List<LikeDto> lista() {
		List<Like> like = likeRepository.findAll();
		return LikeDto.converter(like);
	}

	
}
