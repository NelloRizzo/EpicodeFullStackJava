package it.epicode.restapi.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.restapi.data.Salutation;

@RestController
@RequestMapping("/api/complex")
public class ComplexController {

	@GetMapping("saluta/{name}")
	public ResponseEntity<String> testResponseEntity(@PathVariable String name) {
		String message = String.format("Ciao, %s!", name);
		var headers = new HttpHeaders();
		headers.add("Esempio", "Valore associato");
		return new ResponseEntity<String>(message, headers, HttpStatus.OK);
	}

	@GetMapping(value = "saluta2/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Salutation> greet(@PathVariable String name, //
			@RequestParam(required = false, defaultValue = "it") String lang) {
		String message = //
				lang.equals("it") ? String.format("Ciao, %s!", name) : String.format("Hello, %s!", name);
		var headers = new HttpHeaders();
		headers.add("Lingua-Richiesta", lang);
		var sal = Salutation.builder().withGreetings(message).withName(name).build();
		return new ResponseEntity<Salutation>(sal, headers, HttpStatus.OK);
	}

}
