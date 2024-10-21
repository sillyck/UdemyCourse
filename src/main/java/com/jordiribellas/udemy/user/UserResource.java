package com.jordiribellas.udemy.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService service;
	
	public UserResource(UserDaoService service) {
		this.service = service;
	}
	
	//GET all users
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return service.findAll();
	}
	
	//GET one user
	@GetMapping("/users/{id}")
	public User getUsersById(@PathVariable int id){
		return service.getUsersById(id);
	}
	
	@PostMapping("/users")
	public void createUser(@RequestBody User user) {
		service.saveUser(user);
	}
}
