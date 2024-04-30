package it.epicode;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.LongStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import it.epicode.dao.JpaEventDao;
import it.epicode.entities.Event;
import it.epicode.entities.EventType;

public class Program {
	private static final Logger log = LoggerFactory.getLogger(Program.class);
	private static final Random rnd = new Random(1234);
	private static final LocalDateTime now = LocalDateTime.now();
	private static final String lipsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris vel eros sodales, maximus lorem sed, pulvinar est. Etiam elementum sed nisl a fringilla. Praesent consequat suscipit odio, eu volutpat augue tempor rutrum. Donec sed tellus eu diam porttitor.";

	// crea eventi a caso...
	private static List<Event> randomEvents(int count) {
		return LongStream.range(1, count + 1) //
				.mapToObj(n -> new Event( //
						String.format("Event %d", n), //
						// da ora a 60 gg
						Date.from(now.plusDays(rnd.nextLong(0, 60)).toInstant(ZoneOffset.UTC)), //
						lipsum.substring(0, rnd.nextInt(10, 255)), // da 10 fino al più 255 caratteri a caso...
						EventType.values()[rnd.nextInt(2)], // un tipo di evento a caso
						rnd.nextInt(1, 100))) // un numero massimo di partecipanti a caso fino a 100
				.toList();
	}

	public static void main(String[] args) {
		int total = 50;
<<<<<<< HEAD
		// try-with-resource
=======
>>>>>>> ca11cbd80e905530216a38b150637f9c5604dbe4
		try (var dao = new JpaEventDao()) {
			log.debug("Creo {} eventi a caso...", total);
			// creo gli eventi e li salvo
			randomEvents(total).forEach(dao::save);
			// recupero quello con id = 10
			dao.getById(10).ifPresentOrElse( // (1) if present esegui la prima lambda...
					// se l'elemento è stato trovato, è passato come parametro alla lambda
					item -> { // se c'è...
						log.debug("Ho recuperato l'elemento con id=10: {}", item);

						log.debug("Elimino l'elemento appena trovato");
						dao.delete(item);
						log.debug("Tento di recuperarlo nuovamente");
						dao.getById(10).ifPresentOrElse(
								// dopo aver cancellato l'evento qui non ci dovrei arrivare
								i -> log.debug("Ops... l'elemento dovrebbe essere stato eliminato"),
								// ma dovrei arrivare qui
								() -> log.debug("Benissimo, l'elemento non esiste nel db"));
					}, //
						// (1) altrimenti esegui la seconda lambda
					() -> log.debug("Ops... non ho trovato l'elemento"));
			;

		} catch (Exception e) {
			log.error("Exception in main()", e);
		}
	}

}
