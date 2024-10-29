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

	@GetMapping(path = "/person", params = "version=1", produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonV1 getFirstVersionOfPersonRequestPrameter() {
		return new PersonV1("Javier Ibarra");
	}
	
	@GetMapping(path = "/person", params = "version=2", produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonV2 getSecondVersionOfPersonRequestPrameter() {
		return new PersonV2(new Name("Javier", "Ibarra"));
	}
	
	@GetMapping(path = "/person/header", headers = "X-API-VERSION=1", produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonV1 getFirstVersionOfPersonRequestHeader() {
		return new PersonV1("Javier Ibarra");
	}
	
	@GetMapping(path = "/person/header", headers = "X-API-VERSION=2", produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonV2 getSecondVersionOfPersonRequestHeader() {
		return new PersonV2(new Name("Javier", "Ibarra"));
	}

	@GetMapping(path = "/person/accept", produces = { "application/vnd.company.app-v1+json", MediaType.APPLICATION_JSON_VALUE})
	public PersonV1 getFirstVersionOfPersonAcceptHeader() {
		return new PersonV1("Javier Ibarra");
	}
	
	@GetMapping(path = "/person/accept", produces = { "application/vnd.company.app-v2+json", MediaType.APPLICATION_JSON_VALUE})
	public PersonV2 getSecondVersionOfPersonAcceptHeader() {
		return new PersonV2(new Name("Javier", "Ibarra"));
	}
	
}
