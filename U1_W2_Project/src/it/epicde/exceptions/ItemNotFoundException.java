package it.epicde.exceptions;

public class ItemNotFoundException extends LibraryException {
	private static final long serialVersionUID = 1L;

	private final String isbn;

	public ItemNotFoundException(String isbn) {
		super("Item not found: " + isbn);
		this.isbn = isbn;
	}

	public String getIsbn() {
		return isbn;
	}

}
