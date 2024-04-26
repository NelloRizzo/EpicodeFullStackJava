package it.epicode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.epicode.services.CityService;
import it.epicode.services.FileCityService;

public class Program {

	static final Logger logger = LoggerFactory.getLogger(Program.class);

	static final String FILE_NAME = "E:\\Codice\\EpicodeFS0124\\Workspace\\U1_W2_D4_Servizi\\target\\comuni.csv";

	public static void main(String[] args) {
		CityService service = new FileCityService(FILE_NAME);

		service.getCities().stream() //
				.filter(c -> c.getAcronym().equals("RM")).forEach(c -> logger.debug("{}", c));

	}

}
