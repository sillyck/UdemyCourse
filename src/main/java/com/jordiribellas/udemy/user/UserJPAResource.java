package com.jordiribellas.udemy.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import com.jordiribellas.udemy.jpa.PostRepository;
import com.jordiribellas.udemy.jpa.UserRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class UserJPAResource {

	private UserRepository repository;
	private PostRepository postRepository;
	
	
	//GET all users
	@GetMapping("/jpa/users")
	public List<User> getAllUsers(){
		return repository.findAll();
	}
	
	//GET one user
	@GetMapping("/jpa/users/{id}")
	public EntityModel<User> getUsersById(@PathVariable int id) {
	    Optional<User> user = repository.findById(id);
	    
	    if (user.isEmpty()) {
	        throw new UserNotFoundException("id: " + id);
	    }
	    
	    EntityModel<User> entityModel = EntityModel.of(user.get());
	    
	    WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUsers());
	    entityModel.add(link.withRel("all-users"));
	    
	    return entityModel;
	}
	
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
	    repository.deleteById(id);
	}
	
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> findPostsByUser(@PathVariable int id) {
		Optional<User> user = repository.findById(id);
	    
	    if (user.isEmpty()) {
	        throw new UserNotFoundException("id: " + id);
	    }
	    
	    return user.get().getPosts();
	}

	@PostMapping("/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User saved = repository.save(user);
		
		//users/3 => /users/{id}
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(saved.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPostsForUser(@PathVariable int id, @Valid @RequestBody Post post) {
		Optional<User> user = repository.findById(id);
	    
	    if (user.isEmpty()) {
	        throw new UserNotFoundException("id: " + id);
	    }
	    
	    post.setUser(user.get());
	    
	    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(postRepository.save(post).getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	
}
