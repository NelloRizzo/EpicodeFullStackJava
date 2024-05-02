package it.epicode;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.LongStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.epicode.dao.implementations.JpaAttendanceDao;
import it.epicode.dao.implementations.JpaEventDao;
import it.epicode.dao.implementations.JpaLocationDao;
import it.epicode.dao.implementations.JpaPersonDao;
import it.epicode.entities.Attendance;
import it.epicode.entities.Event;
import it.epicode.entities.EventType;
import it.epicode.entities.Gender;
import it.epicode.entities.Location;
import it.epicode.entities.Person;
import it.epicode.entities.Status;

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

	private static List<Person> randomPeople(int count) {
		return LongStream.range(1, count + 1) //
				.mapToObj(n -> new Person(String.format("First Name %d", n), String.format("Last Name %d", n), //
						String.format("email%d@domain.com", n), //
						Date.from(now.plusYears(-rnd.nextLong(15, 60)).plusDays(rnd.nextInt(-365, 365))
								.toInstant(ZoneOffset.UTC)), //
						Gender.values()[rnd.nextInt(2)]))
				.toList();
	}

	private static List<Location> randomLocation(int count) {
		return LongStream.range(1, count + 1) //
				.mapToObj(n -> new Location(String.format("Location %d", rnd.nextInt(1, 6)),
						String.format("City %d", rnd.nextInt(1, 6))))
				.toList();
	}

	public static void main(String[] args) {
		int total = 50;
		// try-with-resource
		try (var events = new JpaEventDao(); // dao per gli eventi
				var people = new JpaPersonDao(); // dao per le persone
				var locations = new JpaLocationDao();
				var attendances = new JpaAttendanceDao()) // dao per le locations
		{
			log.debug("Creo {} eventi a caso...", total);
			// creo gli eventi e li salvo
			randomEvents(total).forEach(events::save);
			// creo le persone e le salvo
			randomPeople(total).forEach(people::save);
			// creo le locations e le salvo
			randomLocation(total).forEach(locations::save);
			// recupero quello con id = 10
			events.getById(10).ifPresentOrElse( // (1) if present esegui la prima lambda...
					// se l'elemento è stato trovato, è passato come parametro alla lambda
					item -> { // se c'è...
						log.debug("Ho recuperato l'elemento con id=10: {}", item);

						log.debug("Elimino l'elemento appena trovato");
						events.delete(item);
						log.debug("Tento di recuperarlo nuovamente");
						events.getById(10).ifPresentOrElse(
								// dopo aver cancellato l'evento qui non ci dovrei arrivare
								i -> log.debug("Ops... l'elemento dovrebbe essere stato eliminato"),
								// ma dovrei arrivare qui
								() -> log.debug("Benissimo, l'elemento non esiste nel db"));
					}, //
						// (1) altrimenti esegui la seconda lambda
					() -> log.debug("Ops... non ho trovato l'elemento"));
			;
			people.getById(1).ifPresent(person -> {
				log.debug("{}", person);
				locations.getById(10).ifPresent(location -> {
					log.debug("{}", location);
					events.getById(1).ifPresent(e -> {
						log.debug("Evento senza location: {}", e);
						e.setLocation(location);
						events.save(e);
						log.debug("Evento con location: {}", e);

						var attendance = new Attendance(person, e, Status.CONFIRMED);
						attendances.save(attendance);
						person.getAttendances().add(attendance);
						people.save(person);
						log.debug("Presenze di {}", person);
						people.getById(person.getId())
								.ifPresent(p -> p.getAttendances().forEach(a -> log.debug("{}", a)));
					});
				});
			});
		} catch (Exception e) {
			log.error("Exception in main()", e);
		}
	}

}
