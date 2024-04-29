package it.epicde;

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

import it.epicde.data.Book;
import it.epicde.data.Frequency;
import it.epicde.data.Magazine;
import it.epicde.exceptions.ItemNotFoundException;
import it.epicode.services.FileLibraryService;
import it.epicode.services.LibraryService;

public class Program {
	private static final Logger logger = LoggerFactory.getLogger(Program.class);
	private static final Random rnd = new Random();

	private static final List<String> authors = IntStream.range(1, 11) //
			.mapToObj(n -> String.format("Author %d", n)) //
			.toList();

	private static final List<String> categories = IntStream.range(1, 11) //
			.mapToObj(n -> String.format("Category %d", n)) //
			.toList();

	private static String randomISBN() {
		return "00000000".chars() //
				.map(n -> n + rnd.nextInt(10)) //
				.mapToObj(c -> "" + (char) c) //
				.collect(Collectors.joining(""));
	}

	private static List<Book> randomBooks(int count) {
		return LongStream.range(1, count + 1) //
				.mapToObj(n -> new Book(n, // id
						new Date(), // data di creazione
						randomISBN(), // isbn
						String.format("Book %d", n), // titolo
						rnd.nextInt(1800, 2024), // anno di pubblicazione
						rnd.nextInt(50, 4000), // pagine
						authors.get(rnd.nextInt(authors.size())), //
						categories.get(rnd.nextInt(categories.size()))))
				.toList();
	}

	private static List<Magazine> randomMagazine(int count) {
		return LongStream.range(1, count + 1) //
				.mapToObj(n -> new Magazine(n, // id
						new Date(), // data di creazione
						randomISBN(), // isbn
						String.format("Magazine %d", n), // titolo
						rnd.nextInt(1800, 2024), // anno di pubblicazione
						rnd.nextInt(50, 4000), // pagine
						Frequency.values()[rnd.nextInt(0, Frequency.values().length)]))
				.toList();
	}

	static void ensureData(LibraryService service) {
		if (!Files.exists(Path.of("./library.csv"))) {
			randomBooks(10).forEach(b -> service.add(b));
			randomMagazine(10).forEach(m -> service.add(m));
		}
	}

	public static void main(String[] args) {
		try (LibraryService service = new FileLibraryService()) {
			ensureData(service);
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
