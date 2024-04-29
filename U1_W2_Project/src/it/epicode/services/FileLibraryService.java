package it.epicode.services;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.epicde.data.Book;
import it.epicde.data.Item;
import it.epicde.exceptions.ItemNotFoundException;

public class FileLibraryService implements LibraryService, AutoCloseable {
	private static final Logger logger = LoggerFactory.getLogger(LibraryService.class);
	private static final String FILE_NAME = "./library.csv";
	private static long counter = 0;

	private final List<Item> items = new ArrayList<>();

	public FileLibraryService() {
		load();
	}

	private void persist() {
		try {
			logger.debug("Writing {} items in {}", items.size(), FILE_NAME);
			FileUtils.writeLines(new File(FILE_NAME), StandardCharsets.ISO_8859_1.name(), //
					items.stream().map(i -> i.toCsv()).toList());
		} catch (IOException e) {
			logger.error("Write exception in persist()", e);
		}
	}

	private void load() {
		if (!Files.exists(Path.of(FILE_NAME)))
			return;

		try {
			items.clear();
			var lines = FileUtils.readLines(new File(FILE_NAME), StandardCharsets.ISO_8859_1);
			logger.debug("Read {} lines from {}", lines.size(), FILE_NAME);
			lines.forEach(l -> {
				var parts = l.split(";");
				try {
					Item item = (Item) Class.forName(parts[0]).getDeclaredConstructor().newInstance();
					item.fromCsv(l);
					items.add(item);
				} catch (Exception e) {
					logger.error(String.format("Exception reading line: %s", l), e);
				}
			});
			counter = items.stream().map(i -> i.getId()).max(Long::compareTo).orElse(0L);
			logger.debug("Counter is {}", counter);
		} catch (IOException e) {
			logger.error("Exception in load()", e);
		}
	}

	@Override
	public void add(Item item) {
		item.setId(++counter);
		items.add(item);
	}

	@Override
	public void remove(String isbn) {
		logger.debug(isbn);
		Item item = getByIsbn(isbn) // il primo che trovi per ISBN
				.orElseThrow(() -> new ItemNotFoundException(isbn)); // se non c'è scateni un'eccezione
		items.remove(item); // se c'è lo cancelli
	}

	@Override
	public Optional<Item> getByIsbn(String isbn) {
		return items.stream() //
				.filter(i -> i.getIsbn().equals(isbn)) // cerca per codice ISBN
				.findAny(); // il primo che trovi
	}

	@Override
	public List<Item> getByYear(int fromYear, int toYear) {
		return items.stream().filter(i -> i.getPubYear() >= fromYear && i.getPubYear() < toYear).toList();
	}

	@Override
	public List<Book> getByAuthor(String author) {
		return items.stream() //
				.filter(i -> i instanceof Book) // recupera solo libri
				.map(i -> (Book) i) // converte da Item a Book
				.filter(i -> i.getAuthor().contains(author)) // cerca per Autore
				.toList();
	}

	@Override
	public void close() throws Exception {
		persist();
	}

	@Override
	public List<Item> getAll() {
		return items.stream().toList();
	}

}
