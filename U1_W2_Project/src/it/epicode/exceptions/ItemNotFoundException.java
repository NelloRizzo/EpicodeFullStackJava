package it.epicode.exceptions;

/**
 * 
 * Segnala che l'elemento cercato non esiste.
 *
 */
public class ItemNotFoundException extends LibraryException {
	private static final long serialVersionUID = 1L;

	private final String isbn;

	public ItemNotFoundException(String isbn) {
		super("Item not found: " + isbn);
		this.isbn = isbn;
	}

	/**
	 * 
	 * @return il codice ISBN cercato.
	 */
	public String getIsbn() {
		return isbn;
	}

}
