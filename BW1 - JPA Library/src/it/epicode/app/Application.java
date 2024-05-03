package it.epicode.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.epicode.library.services.IsbnValidator;

public class Application {
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void run(IsbnValidator isbnValidator) {
		var valid13 = "978-88-430-2534-3";
		log.debug("{} -> {}", valid13, isbnValidator.isValidIsbn(valid13));
		var invalid13 = "978-88-430-2534-2";
		log.debug("{} -> {}", invalid13, isbnValidator.isValidIsbn(invalid13));
		var valid10 = "88-515-2159-X";
		log.debug("{} -> {}", valid10, isbnValidator.isValidIsbn(valid10));
		var invalid10 = "88-515-2159-7";
		log.debug("{} -> {}", invalid10, isbnValidator.isValidIsbn(invalid10));
	}
}
