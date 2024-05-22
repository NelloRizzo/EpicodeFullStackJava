package it.epicode.w2d3.fines.controllers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.w2d3.fines.entities.Vehicle;
import it.epicode.w2d3.fines.services.FineService;

@RestController
@RequestMapping("/api/vehicles")
public class VehiclesController {

	@Autowired
	FineService service;

	@PostMapping
	public ResponseEntity<Vehicle> register(@RequestBody Vehicle v) {
		var vehicle = service.register(v);
		return new ResponseEntity<>(vehicle, null, HttpStatus.CREATED);
	}
}
