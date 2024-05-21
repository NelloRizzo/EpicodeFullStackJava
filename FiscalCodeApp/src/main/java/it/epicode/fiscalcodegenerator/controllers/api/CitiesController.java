package it.epicode.fiscalcodegenerator.controllers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.fiscalcodegenerator.services.CityService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CitiesController {

	@Autowired
	CityService service;

	@GetMapping("/api/cities/{acronym}")
	public ResponseEntity<?> getCitiesByProvince(@PathVariable String acronym) {
		try {
			return ResponseEntity.ok(service.getCitiesByAcronym(acronym));
		} catch (Exception ex) {
			log.info(String.format("Exception retrieving cities by acronym = %s", acronym), ex);
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping("/api/provinces")
	public ResponseEntity<?> getProvinces() {
		try {
			return ResponseEntity.ok(service.getProvinces());
		} catch (Exception ex) {
			log.info("Exception retrieving provinces", ex);
			return ResponseEntity.badRequest().build();
		}
	}
}
