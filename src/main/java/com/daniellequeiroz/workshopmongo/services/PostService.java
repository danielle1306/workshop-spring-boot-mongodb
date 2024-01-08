package com.daniellequeiroz.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daniellequeiroz.workshopmongo.domain.Post;
import com.daniellequeiroz.workshopmongo.repository.PostRepository;
import com.daniellequeiroz.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	PostRepository postRepository;
	
	public Post findById(String id) {
		Optional<Post> obj = postRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	/*
	 * public List<Post> findByTitle(String text) { return
	 * return postRepository.findByTitleContainingIgnoreCase(text); }
	 */
	//trocando para uma query criada por mim
	public List<Post> findByTitle(String text) {
		return postRepository.searchByTitle(text);
	}
	
	//query com operadores lógicos e acrescentando 1 dia à data para contar o dia final
	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return postRepository.fullSearch(text, minDate, maxDate);
	}
	

}
