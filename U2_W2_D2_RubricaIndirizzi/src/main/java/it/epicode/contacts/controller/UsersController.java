package it.epicode.contacts.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriBuilder;

import it.epicode.contacts.entities.User;
import it.epicode.contacts.services.ApplicationService;

@RestController
@RequestMapping("/api/users")
public class UsersController {

	@Autowired
	ApplicationService service;

	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		var u = service.save(user);
		if (u.isEmpty())
			throw new RuntimeException("Impossibile salvare l'utente");
		var headers = new HttpHeaders();
		headers.add("Location", URI.create("").toString());
		return new ResponseEntity<User>(u.get(), headers, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<User>> getUsers() {
		var users = service.getAll();
		return new ResponseEntity<List<User>>(users, null, HttpStatus.OK);
	}
}
