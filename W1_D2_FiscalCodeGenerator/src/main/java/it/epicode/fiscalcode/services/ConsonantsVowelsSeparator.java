package it.epicode.fiscalcode.services;

import lombok.Getter;

/**
 * Separa le consonanti dalle vocali in un testo.
 */
public class ConsonantsVowelsSeparator {
	/**
	 * Le consonanti contenute nel testo.
	 */
	@Getter
	// private String consonants = "";
	private final StringBuilder consonants = new StringBuilder();
	/**
	 * Le vocali contenute nel testo.
	 */
	@Getter
	// private String vowels = "";
	private final StringBuilder vowels = new StringBuilder();

	/**
	 * 
	 * @param text il testo da gestire.
	 */
	public ConsonantsVowelsSeparator(String text) {
		text.chars() // apre uno stream sui caratteri contenuti nella stringa
				.filter(c -> Character.isAlphabetic(c)) // fa passare solo i caratteri alfabetici
				.mapToObj(c -> (char) Character.toUpperCase(c)) // li mette in maiuscolo
				.forEach(c -> {
					// controlla se si tratta di una vocale
					if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
						vowels.append(c);
					} else { // altrimenti si tratta di una consonante
						consonants.append(c);
					}
				});
	}
}
