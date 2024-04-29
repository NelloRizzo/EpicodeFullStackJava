package it.epicode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.epicode.services.CityService;
import it.epicode.services.FileCityService;

public class Program {

	static final Logger logger = LoggerFactory.getLogger(Program.class);

	static final String FILE_NAME = "E:\\Codice\\EpicodeFS0124\\Workspace\\U1_W2_D4_Servizi\\target\\comuni.csv";

	public static void main(String[] args) {
		// FileCityService service = new FileCityService(FILE_NAME); // legge i dati da un csv
		CityService service = new FileCityService(); // legge i dati da uno storage interno

		service.getCities().stream() //
				.filter(c -> c.getAcronym().equals("RM")).forEach(c -> logger.debug("{}", c));

		// service.save();

		var aglie = service.getCities().stream() //
				.filter(c -> c.getId() == 1001).findFirst().orElseThrow();
		service.deleteCity(aglie);
	}

}
