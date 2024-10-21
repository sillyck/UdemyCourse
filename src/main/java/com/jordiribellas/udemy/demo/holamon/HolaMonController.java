package com.jordiribellas.udemy.demo.holamon;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// REST API
@RestController
public class HolaMonController {
	
	@GetMapping("/hola-mon")
	public String holaMon() {
		return "Hola mon";
	}
	
	@GetMapping("/hola-mon-bean")
	public holaMonBean holaMonBean() {
		return new holaMonBean("Hola mon bean");
	}
	
	//Path Parameters
	// /users/{id}/to-do/{id} => /users/1/todo/100
	// /hola-mon/path-variable/{name}
	// /hola-mon/path-variable/Jordi
	
	@GetMapping("/hola-mon/path-variable/{name}")
	public holaMonBean holaMonPathVariable(@PathVariable String name) {
		return new holaMonBean(String.format("Hola mon, %s", name));
	}
	
	
}
