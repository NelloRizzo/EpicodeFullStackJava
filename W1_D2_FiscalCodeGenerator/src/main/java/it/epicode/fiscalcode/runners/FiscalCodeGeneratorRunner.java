package it.epicode.fiscalcode.runners;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import it.epicode.fiscalcode.entities.Gender;
import it.epicode.fiscalcode.entities.PersonalData;
import it.epicode.fiscalcode.services.FiscalCodeService;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class FiscalCodeGeneratorRunner implements CommandLineRunner {

	@Autowired
	FiscalCodeService service;

	@Override
	public void run(String... args) throws Exception {
		var meloni = new PersonalData("Giorgia", "Meloni", //
				LocalDate.of(1977, 1, 15), Gender.FEMALE, "H501");
		log.info("{}", meloni);
		var fc = service.generateFiscalCode(meloni);
		log.info("Codice Fiscale: {}", fc);
	}

}
