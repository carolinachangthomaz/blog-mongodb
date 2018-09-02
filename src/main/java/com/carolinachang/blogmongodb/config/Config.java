package com.carolinachang.blogmongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.carolinachang.blogmongodb.domain.User;
import com.carolinachang.blogmongodb.repository.UserRepository;

@Configuration
public class Config implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Silva", "maria@gmail.com");
	    User xis = new User(null, "Xis Cardoso", "xis@gmail.com");
		
	    userRepository.saveAll(Arrays.asList(maria,xis));
	}

}
