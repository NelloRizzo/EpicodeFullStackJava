package it.epicde.exceptions;

/**
 * 
 * Segnala un numero di campi incongruente nel file.
 *
 */
public class InvalidFieldsCountLibraryException extends LibraryException {

	private static final long serialVersionUID = 1L;

	private final int expected;
	private final int found;

	public InvalidFieldsCountLibraryException(int expected, int found) {
		this.expected = expected;
		this.found = found;
	}

	/**
	 * 
	 * @return il numero di campi atteso.
	 */
	public int getExpected() {
		return expected;
	}

	/**
	 * 
	 * @return il numero di campi trovato.
	 */
	public int getFound() {
		return found;
	}

}
