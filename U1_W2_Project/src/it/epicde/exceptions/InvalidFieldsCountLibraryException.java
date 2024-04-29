package it.epicde.exceptions;

public class InvalidFieldsCountLibraryException extends LibraryException {

	private static final long serialVersionUID = 1L;

	private final int expected;
	private final int found;

	public InvalidFieldsCountLibraryException(int expected, int found) {
		this.expected = expected;
		this.found = found;
	}

	public int getExpected() {
		return expected;
	}

	public int getFound() {
		return found;
	}
	
	
}
