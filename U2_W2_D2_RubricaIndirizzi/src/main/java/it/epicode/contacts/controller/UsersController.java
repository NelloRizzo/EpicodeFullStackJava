package it.epicode.contacts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import it.epicode.contacts.entities.Address;
import it.epicode.contacts.entities.EmailAddress;
import it.epicode.contacts.entities.PhoneAddress;
import it.epicode.contacts.entities.User;
import it.epicode.contacts.services.ApplicationService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/users")
@Slf4j
public class UsersController {

	@Autowired
	ApplicationService service;

	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		var u = service.save(user);
		if (u.isEmpty())
			throw new RuntimeException("Impossibile salvare l'utente");
		var headers = new HttpHeaders();
		var uri = UriComponentsBuilder //
				.fromPath("/api/users/{id}").buildAndExpand(u.get().getId()).toString();
		headers.add("Location", uri);
		return new ResponseEntity<User>(u.get(), headers, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<User>> getUsers() {
		var users = service.getAll();
		return new ResponseEntity<List<User>>(users, null, HttpStatus.OK);
	}

	@PostMapping("{userId}/email")
	public ResponseEntity<Address> addEmail(@PathVariable Long userId, @RequestBody String email) {
		try {
			var address = service.addAddress(userId, EmailAddress.builder().withEmail(email).build()).orElseThrow();
			return new ResponseEntity<Address>(address, null, HttpStatus.CREATED);
		} catch (Exception e) {
			log.error("Exception adding email");
			return ResponseEntity.badRequest().build();
		}
	}

	@PostMapping("{userId}/phone")
	public ResponseEntity<Address> addPhone(@PathVariable Long userId, @RequestBody String phone) {
		try {
			var address = service.addAddress(userId, PhoneAddress.builder().withPhoneNumber(phone).build())
					.orElseThrow();
			return new ResponseEntity<Address>(address, null, HttpStatus.CREATED);
		} catch (Exception e) {
			log.error("Exception adding email");
			return ResponseEntity.badRequest().build();
		}
	}
}
