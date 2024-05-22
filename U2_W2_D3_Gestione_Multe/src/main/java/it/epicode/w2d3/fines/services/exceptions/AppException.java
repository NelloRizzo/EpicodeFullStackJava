package it.epicode.w2d3.fines.services.exceptions;

public class AppException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public AppException(String message) {
		super(message);
	}

	public AppException() {
		this("Errore imprevisto");
	}
}
