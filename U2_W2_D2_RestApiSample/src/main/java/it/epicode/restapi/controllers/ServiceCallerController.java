package it.epicode.restapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.restapi.data.Salutation;
import it.epicode.restapi.services.AppService;

// Controller gestisce la richiesta proveniente dal client
@RestController
@RequestMapping("/api")
public class ServiceCallerController {

	// Gestisce la logica applicativa (modifica o recupera i dati
	// richiamando a sua volta il Repository delle diverse entità
	@Autowired
	AppService service;

	// fornisce una risposta al client
	@GetMapping("/call/{name}")
	public ResponseEntity<List<Salutation>> getSalutations(@PathVariable String name) {
		var body = service.getSalutationForUsername(name);
		return new ResponseEntity<List<Salutation>>(body, null, HttpStatus.OK);
	}
}
