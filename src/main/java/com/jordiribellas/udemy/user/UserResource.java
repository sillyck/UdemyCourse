package com.jordiribellas.udemy.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

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
	public EntityModel<User> getUsersById(@PathVariable int id) {
	    User user = service.getUsersById(id);
	    
	    if (user == null) {
	        throw new UserNotFoundException("id: " + id);
	    }
	    
	    EntityModel<User> entityModel = EntityModel.of(user);
	    
	    WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUsers());
	    entityModel.add(link.withRel("all-users"));
	    
	    return entityModel;
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		service.deleteUserById(id);
	}

	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User saved = service.saveUser(user);
		
		//users/3 => /users/{id}
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(saved.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
}
