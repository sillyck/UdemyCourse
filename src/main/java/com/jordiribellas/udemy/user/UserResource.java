package com.jordiribellas.udemy.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	public User getUsersById(@PathVariable int id) {
	    User user = service.getUsersById(id);
	    
	    if (user == null) {
	        throw new UserNotFoundException("id: " + id);
	    }
	    
	    return user;
	}

	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		User saved = service.saveUser(user);
		
		//users/3 => /users/{id}
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(saved.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
}
