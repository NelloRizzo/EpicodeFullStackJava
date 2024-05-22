package it.epicode.w2d3.fines.services.exceptions;

public class DuplicateKeyAppException extends AppException {
	private static final long serialVersionUID = 1L;

	public final String duplicateKey;

	public DuplicateKeyAppException(String key, String message) {
		super(message);
		this.duplicateKey = key;
	}

	public DuplicateKeyAppException(String key) {
		this(key, "Chiave duplicata");
	}
}
