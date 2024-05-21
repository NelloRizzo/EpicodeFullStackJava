package it.epicode.web.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.web.data.Person;

@RestController
public class PeopleController {

	@GetMapping(value = "api/people")
	public ResponseEntity<?> getPerson() {
		return ResponseEntity.ok(Person.builder().withFirstName("Nello").withLastName("Rizzo").build());
	}
}
