package com.jordiribellas.udemy.demo.holamon;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// REST API
@RestController
public class HolaMonController {
	
	private MessageSource messageSource;
	
	public HolaMonController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
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
	
	@GetMapping("/hola-mon-wolrdwide")
	public String holaMonWolrdWide() {
		Locale locale = LocaleContextHolder.getLocale();
		
		return messageSource.getMessage("bon.dia.message", null, "Default Message", locale );
	}
	
}
