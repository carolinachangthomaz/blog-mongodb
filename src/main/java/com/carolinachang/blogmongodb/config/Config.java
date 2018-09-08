package com.carolinachang.blogmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.carolinachang.blogmongodb.domain.Post;
import com.carolinachang.blogmongodb.domain.User;
import com.carolinachang.blogmongodb.repository.PostRepository;
import com.carolinachang.blogmongodb.repository.UserRepository;

@Configuration
public class Config implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Silva", "maria@gmail.com");
	    User xis = new User(null, "Xis Cardoso", "xis@gmail.com");
		
	    Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para SP", maria);
	    Post post2 = new Post(null, sdf.parse("26/03/2018"), "Partiu viagem", "Vou viajar para SP", xis);
	    
	    userRepository.saveAll(Arrays.asList(maria,xis));
	    postRepository.saveAll(Arrays.asList(post1,post2));
	    
	    maria.getPosts().addAll(Arrays.asList(post1));
	    xis.getPosts().addAll(Arrays.asList(post2));
	    
	    userRepository.saveAll(Arrays.asList(maria,xis));
	}

}
