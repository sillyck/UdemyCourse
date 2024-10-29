package com.jordiribellas.udemy.versioning;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
	
	@GetMapping(value = "/v1/person", produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonV1 getFirstVersionOfPerson() {
		return new PersonV1("Javier Ibarra");
	}
	
	@GetMapping(value = "/v2/person", produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonV2 getSecondVersionOfPerson() {
		return new PersonV2(new Name("Javier", "Ibarra"));
	}


}
