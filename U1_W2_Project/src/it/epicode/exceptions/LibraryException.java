package it.epicode.exceptions;

public class LibraryException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public LibraryException() {
	}

	public LibraryException(String message) {
		super(message);
	}

	public LibraryException(Throwable cause) {
		super(cause);
	}

	public LibraryException(String message, Throwable cause) {
		super(message, cause);
	}
}
