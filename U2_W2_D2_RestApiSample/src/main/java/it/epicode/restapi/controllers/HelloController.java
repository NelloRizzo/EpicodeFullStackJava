package it.epicode.restapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

//@Controller // crea un bean attivabile dalla Dispatcher Servlet
@RestController // come controller ma evita l'uso di @ResponseBody nei metodi
@RequestMapping("/api") // aggiunge un prefisso a tutte le URI
public class HelloController {

	// mappa una richiesta GET /hello in maniera che la Dispatcher Servlet,
	// una volta attivato l'istanza del controller, esegua su di essa il
	// metodo helloWorld()
	@GetMapping("/hello")
	// @ResponseBody indica al server che non è necessaria altra operazione
	// effettuata sul risultato, che deve essere immediatamente inviato al
	// client esterno
	public @ResponseBody String helloWorld() {
		return "Hello, World!";
	}

	@GetMapping("/greetings")
	public String hello( //
			@RequestParam(name = "chi", required = false, defaultValue = "WORLD") String name, //
			@RequestParam(name = "lang", required = false, defaultValue = "it") String language) {
		if (name == null)
			return helloWorld();
		if (language.equals("en"))
			return String.format("Hello, %s!", name);
		return String.format("Ciao, %s!", name);
	}

	@GetMapping("/greet/{name}")
	public String hello2( //
			@PathVariable String name, //
			@RequestParam(name = "lang", required = false, defaultValue = "it") String language) {
		if (language.equals("en"))
			return String.format("Hello, %s!", name);
		return String.format("Ciao, %s!", name);
	}

	@GetMapping("/user/{chi}/greet")
	public String hello3( //
			@RequestParam(required = false, defaultValue = "it") String lang, //
			@PathVariable(name = "chi", required = false) String name) //
	{
		if (lang.equals("en")) {
			return String.format("Hello, %s!", name == null ? "World" : name);
		}
		return String.format("Ciao, %s!", name == null ? "Mondo" : name);
	}

	@GetMapping("/ciao")
	public String helloWorld2() {
		return "Ciao, Mondo!";
	}

	@PostMapping
	public String postHello() {
		return "Hello, World, from POST request!";
	}

	@PostMapping("/params")
	@ResponseStatus(HttpStatus.CREATED)
	public String postWithParams(@RequestBody String name) {
		return String.format("Hello, %s!", name);
	}

}
