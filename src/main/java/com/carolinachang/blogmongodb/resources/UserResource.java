package com.carolinachang.blogmongodb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
