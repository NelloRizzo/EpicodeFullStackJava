package it.epicode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.epicode.dao.CityDao;
import it.epicode.dao.JpaCityDao;

public class Program {

	private static final Logger log = LoggerFactory.getLogger(Program.class);

	public static void operate(CityDao dao) {
		log.debug("Sono presenti {} province", dao.getProvincesCount());

		log.debug("Tutte le province:");
		dao.getProvinces().forEach(p -> log.debug("{}", p));

		log.debug("Tutte le province il cui nome comincia per A:");
		dao.getProvinceBySample("A%").forEach(p -> log.debug("{}", p));

		var sample = "A_e%";
		log.debug("Ricerca avanzata (LIKE {}):", sample);
		dao.getProvinceBySample(sample).forEach(p -> log.debug("{}", p));

		dao.getCitiesCountByProvince().forEach((k, e) -> log.debug("{} -> {}", k, e));
	}

	public static void main(String[] args) {
		// legge da un file nella cartella META-INF
		var resourceStream = Program.class.getClassLoader().getResourceAsStream("META-INF/comuniitaliani.csv");
		// se non trova il file termina
		assert (resourceStream != null);

		try (var dao = new JpaCityDao()) {
			dao.populate(resourceStream);
			operate(dao);
		} catch (Exception e) {
			log.error("Exception", e);
		}
	}

}
