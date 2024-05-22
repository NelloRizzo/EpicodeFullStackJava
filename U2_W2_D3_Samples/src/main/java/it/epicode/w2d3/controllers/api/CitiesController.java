package it.epicode.w2d3.controllers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.w2d3.entities.CityEntity;
import it.epicode.w2d3.repositories.CitiesRepository;
import it.epicode.w2d3.services.ExceptionHandlingSampleService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/cities")
@Slf4j
public class CitiesController {

	@Autowired
	CitiesRepository cities;

	@Autowired
	ExceptionHandlingSampleService service;

	@GetMapping
	public ResponseEntity<Page<CityEntity>> getAllCities(Pageable p) {
		log.info("{}", p);
		var c = cities.findAll(p);
		return new ResponseEntity<Page<CityEntity>>(c, HttpStatus.OK);
	}

	@GetMapping("exception")
	public ResponseEntity<?> throwException(@RequestParam(defaultValue = "false") boolean activate) {
		service.testExceptionHandling(activate);
		return ResponseEntity.ok().build();
	}
}
