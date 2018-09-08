package com.carolinachang.blogmongodb.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.carolinachang.blogmongodb.domain.Post;
import com.carolinachang.blogmongodb.domain.User;
import com.carolinachang.blogmongodb.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService userService;

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>>  findAll(){
		List<User> list = userService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/{id}" ,method=RequestMethod.GET)
	public ResponseEntity<User>  findById(@PathVariable String id){
		User user = userService.findById(id);
		return ResponseEntity.ok().body(user);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void>  insert(@RequestBody User user){
		User newuser = userService.insert(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newuser.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}/posts" ,method=RequestMethod.GET)
	public ResponseEntity<List<Post>>  findPosts(@PathVariable String id){
		User user = userService.findById(id);
		return ResponseEntity.ok().body(user.getPosts());
	}
}
