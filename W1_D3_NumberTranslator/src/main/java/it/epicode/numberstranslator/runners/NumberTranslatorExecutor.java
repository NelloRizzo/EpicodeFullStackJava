package it.epicode.numberstranslator.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import it.epicode.numberstranslator.services.NumberTranslatorService;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class NumberTranslatorExecutor implements CommandLineRunner {

	@Autowired
	NumberTranslatorService service;

	@Override
	public void run(String... args) throws Exception {
		try {
			for (var number = 1;number < 100; number++) {
				var result = service.translate(number);
				log.info("{} -> {}", number, result);
			}
		} catch (Exception e) {
			log.info("Fine - {}", e.getLocalizedMessage());
		}
	}

}
