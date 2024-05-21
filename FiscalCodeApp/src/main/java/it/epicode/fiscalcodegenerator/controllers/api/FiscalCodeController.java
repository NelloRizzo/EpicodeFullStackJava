package it.epicode.fiscalcodegenerator.controllers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.fiscalcodegenerator.dto.FiscalCodeServiceResult;
import it.epicode.fiscalcodegenerator.dto.PersonalData;
import it.epicode.fiscalcodegenerator.services.FiscalCodeService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class FiscalCodeController {

	@Autowired
	private FiscalCodeService service;

	@PostMapping("/api/fiscalcode")
	public ResponseEntity<?> calculateFiscalCode(@RequestBody(required = true) PersonalData data) {
		try {
			return ResponseEntity.ok(FiscalCodeServiceResult.builder().withData(data)
					.withFiscalCode(service.calculateFiscalCode(data)).build());
		} catch (Exception ex) {
			log.info(String.format("Exception calculating fiscal code of %s", data), ex);
			return ResponseEntity.badRequest().build();
		}
	}
}
