package it.epicode;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.persistence.Persistence;

public class Program {

	static final Logger log = LoggerFactory.getLogger(Program.class);
	static final Path FILE = Path.of("E:\\Codice\\EpicodeFS0124\\Workspace\\U1_W3_D2_ItalianCitiesJPA\\src", //
			"comuni.csv");
	static final String PERSISTENCE_UNIT = "ItalianCities";

	public static void main(String[] args) {
		try {
			// carica le città dal file csv
			List<City> cities = Files.lines(FILE, StandardCharsets.ISO_8859_1) //
					.skip(3) // salto le prime tre righe
					.map(l -> l.split(";")) // entra la linea esce un array con i campi (separati con ;)
					// .map(a -> a[5] + " (" + a[14] + ")") // prendo solo il 6^ elemento e il 15^
					.map(a -> new City(a[5], a[14], a[11])) // creo una istanza di classe City
					.toList() // creo una lista di città!!!!!!
			;
			log.debug("Ho caricato dal file {} città", cities.size());

			// crea un factory per l'entity manager
			var emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
			// tramite il factory crea l'entity manager
			var em = emf.createEntityManager();
			// apre una transazione
			var trans = em.getTransaction();
			// e la avvia
			trans.begin();
			// attraversa la lista delle città
		/*	cities.forEach(c -> {
				em.persist(c); // e le salva una per una tramite l'entity manager
				log.debug("Salvataggio di {}", c);
			});*/
			// rende effettive le modifiche sul database
			trans.commit();
			
			// recupera la città con id = 23708
			var city = em.find(City.class, 23708);
			log.debug("Città con id=23708: {}", city);
			
			log.debug("Fine");
			em.close();
			emf.close();
		} catch (Exception e) {
			log.error("Eccezione durante l'esecuzione", e);
		}
	}

}
