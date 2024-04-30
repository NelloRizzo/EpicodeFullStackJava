package it.epicode;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.epicode.data.Book;
import it.epicode.data.Frequency;
import it.epicode.data.Magazine;
import it.epicode.exceptions.ItemNotFoundException;
import it.epicode.services.FileLibraryService;
import it.epicode.services.LibraryService;

public class Program {
	// il gestore dei log
	private static final Logger logger = LoggerFactory.getLogger(Program.class);
	// il generatore di numeri casuali
	private static final Random rnd = new Random();

	// una lista di autori random
	private static final List<String> authors = IntStream.range(1, 11) // [1..10]
			// per ogni numero crea un autore che si chiama Author N
			.mapToObj(n -> String.format("Author %d", n)) //
			// converte in lista
			.toList();

	// una lista di categorie random
	private static final List<String> categories = IntStream.range(1, 11) // [1..10]
			// n categorie di nome Category N
			.mapToObj(n -> String.format("Category %d", n)) //
			// converte in lista
			.toList();

	// un codice ISBN a caso
	private static String randomISBN() {
		return "00000000".chars() // prende una stringa e apre uno stream sui suoi caratteri
				.map(n -> n + rnd.nextInt(10)) // x ogni codice di carattere aggiunge un valore a caso tra o e 9
				.mapToObj(c -> "" + (char) c) // trasforma il numero ottenuto in char
				.collect(Collectors.joining("")); // ricostruisce la stringa con tutti i caratteri ottenuti
	}

	// una lista di libri casuali
	private static List<Book> randomBooks(int count) {
		return LongStream.range(1, count + 1) // [1..count]
				.mapToObj(n -> new Book(n, // id
						new Date(), // data di creazione
						randomISBN(), // isbn
						String.format("Book %d", n), // titolo
						rnd.nextInt(1800, 2024), // anno di pubblicazione
						rnd.nextInt(50, 4000), // pagine
						authors.get(rnd.nextInt(authors.size())), // autore a caso
						categories.get(rnd.nextInt(categories.size())) // categoria a caso
				)).toList();
	}

	private static List<Magazine> randomMagazine(int count) {
		return LongStream.range(1, count + 1) //
				.mapToObj(n -> new Magazine(n, // id
						new Date(), // data di creazione
						randomISBN(), // isbn
						String.format("Magazine %d", n), // titolo
						rnd.nextInt(1800, 2024), // anno di pubblicazione
						rnd.nextInt(50, 4000), // pagine
						// la enum ha una proprietà values() che restituisce tutti i possibili valori
						// la istruzione seguente ne prende uno a caso
						Frequency.values()[rnd.nextInt(0, Frequency.values().length)]))
				.toList();
	}

	// controlla se sul database ci sono dati
	static void ensureData(LibraryService service) {
		if (!Files.exists(Path.of("./library.csv"))) {
			// se il file non esiste aggiunge 10 libri e 10 riviste
			randomBooks(10).forEach(b -> service.add(b));
			randomMagazine(10).forEach(m -> service.add(m));
		}
	}

	public static void main(String[] args) {
		// l'istruzione seguente si chiama try-with-resource
		// viene usata con le classi che implementano l'interfaccia Autocloseable
		// oltre ad intercettare gli errori, alla fine del try viene
		// automaticamente richiamato il metodo close() 
		try (LibraryService service = new FileLibraryService()) {
			ensureData(service);
			// tutti i dati
			service.getAll().forEach(i -> logger.debug("{}", i));

			logger.debug("Tentativo di cancellare un elemento che non esiste");
			service.remove("nonesiste");
		} catch (ItemNotFoundException e) {
			logger.error("Item not found for key <{}>", e.getIsbn());
		} catch (Exception e) {
			logger.error("Exception in main", e);
		}
	}
}
