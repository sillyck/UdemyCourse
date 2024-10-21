package com.jordiribellas.udemy.demo.holamon;

import org.springframework.web.bind.annotation.RestController;

// REST API
@RestController
public class HolaMon {
	
	// /hola-mon
	
	public String holaMon() {
		return "Hola mon";
	}
	
}
