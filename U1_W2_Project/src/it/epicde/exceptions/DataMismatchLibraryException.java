package it.epicde.exceptions;

/**
 * 
 * Segnala un tipo errato di dato nel file.
 *
 */
public class DataMismatchLibraryException extends LibraryException {
	private static final long serialVersionUID = 1L;

	private final String expected;
	private final String found;

	public DataMismatchLibraryException(String expected, String found) {
		this.expected = expected;
		this.found = found;
	}

	public String getExpected() {
		return expected;
	}

	public String getFound() {
		return found;
	}
}
