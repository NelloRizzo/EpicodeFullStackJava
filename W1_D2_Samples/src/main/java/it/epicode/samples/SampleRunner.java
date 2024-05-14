package it.epicode.samples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SampleRunner implements CommandLineRunner {

	@Autowired
	Parameters p;

	@Autowired
	ConstructorAutowired ca;

	@Autowired
	SetterAutowired sa;

	@Autowired
	@Qualifier("second-service")
	MyService service;

	@Override
	public void run(String... args) throws Exception {
		log.info("L'applicazione si chiama {}", p.getName());
		log.info("io mi chiamo {}", p.getMyName());
		log.info("Il numero vale {}", p.getNumber());
		log.info("Il numero vale {}", ca.getParameters().getNumber());
		log.info("Il numero vale {}", sa.getParameters().getNumber());

		sa.setParameters(new Parameters());
		log.info("Il numero vale {}", sa.getParameters().getNumber());

		service.printLog();
	}

}
