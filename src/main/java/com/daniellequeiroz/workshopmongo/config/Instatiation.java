package com.daniellequeiroz.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.daniellequeiroz.workshopmongo.domain.Post;
import com.daniellequeiroz.workshopmongo.domain.User;
import com.daniellequeiroz.workshopmongo.dto.AuthorDTO;
import com.daniellequeiroz.workshopmongo.repository.PostRepository;
import com.daniellequeiroz.workshopmongo.repository.UserRepository;

@Configuration
public class Instatiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();//vai limpar a coleção que coloquei manualmente no banco.
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));//salva novamente esses novos users. E preciso salvar antes de chamar o authordto para que o id já seja carregado
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo", new AuthorDTO(maria));//preciso persistir o author
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia!", "Acordei feliz hoje", new AuthorDTO(maria));		
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		//agora vou salvar os posts, relacionando com o author
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);

	}

}
