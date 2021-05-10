package br.com.matrix.publi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.matrix.publi.conta.Follow;
import br.com.matrix.publi.controller.dto.FollowDto;
import br.com.matrix.publi.repository.FollowRepository;

@RestController
@RequestMapping("/follow")
public class FollowController {
	
	@Autowired
	private FollowRepository followRepository;
	
	@GetMapping
	public List<FollowDto> lista() {
		List<Follow> follow = followRepository.findAll();
		return FollowDto.converter(follow);
	}

}
