package com.daniellequeiroz.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.daniellequeiroz.workshopmongo.domain.User;
import com.daniellequeiroz.workshopmongo.repository.UserRepository;

@Configuration
public class Instatiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();//vai limpar a coleção que coloquei manualmente no banco.
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));//salva novamente esses novos users

	}

}
