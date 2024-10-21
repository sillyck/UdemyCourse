package com.jordiribellas.udemy.demo.holamon;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// REST API
@RestController
public class HolaMon {
	
	@GetMapping("/hola-mon")
	public String holaMon() {
		return "Hola mon";
	}
	
	@GetMapping("/hola-mon-bean")
	public holaMonBean holaMonBean() {
		return new holaMonBean("Hola mon bean");
	}
	
}
