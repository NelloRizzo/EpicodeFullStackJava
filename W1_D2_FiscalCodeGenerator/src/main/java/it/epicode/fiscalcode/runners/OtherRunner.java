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
public class OtherRunner implements CommandLineRunner {
	@Autowired
	FiscalCodeService service;

	@Override
	public void run(String... args) throws Exception {
		var schlein = PersonalData.builder() //
				.withBirthCity("Lugano") //
				.withBirthday(LocalDate.of(1985, 5, 4)) //
				.withBirthProvince("EE") //
				.withFirstName("Elena Ethel") //
				.withGender(Gender.FEMALE) //
				.withLastName("Schlein").build();
		log.info("{}", schlein);
		var fc = service.generateFiscalCode(schlein);
		log.info("Codice Fiscale: {}", fc);	}

}
