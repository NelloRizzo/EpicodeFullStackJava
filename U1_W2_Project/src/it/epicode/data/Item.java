package it.epicode.data;

import java.util.Date;

import it.epicode.exceptions.InvalidFieldsCountLibraryException;
import it.epicode.exceptions.LibraryException;

/**
 * Un elemento mantenuto in libreria.
 *
 */
public class Item extends Entity {
	private String isbn;
	private String title;
	private int pubYear;
	private int pages;

	public Item() {
	}

	public Item(Long id, Date createdAt, String isbn, String title, int pubYear, int pages) {
		super(id, createdAt);
		this.isbn = isbn;
		this.title = title;
		this.pubYear = pubYear;
		this.pages = pages;
	}

	/**
	 * @return il codice ISBN.
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * 
	 * @return il titolo.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 
	 * @return l'anno di pubblicazione.
	 */
	public int getPubYear() {
		return pubYear;
	}

	/**
	 * 
	 * @return il numero di pagine.
	 */
	public int getPages() {
		return pages;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setPubYear(int pubYear) {
		this.pubYear = pubYear;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	@Override
	public String toString() {
		return String.format("Item(%s, isbn=%s, title=%s, pubYear=%d, pages=%d)", super.toString(), isbn, title,
				pubYear, pages);
	}

	@Override
	public String toCsv() {
		return String.format("%s;%s;%s;%d;%d", super.toCsv(), isbn, title, pubYear, pages);
	}

	public int fromCsv(String csv) {
		int i = super.fromCsv(csv);
		var parts = csv.split(";");
		if (parts.length < (4 + i))
			throw new InvalidFieldsCountLibraryException(4 + i, parts.length);
		isbn = parts[i];
		title = parts[i + 1];
		try {
			pubYear = Integer.parseInt(parts[i + 2]);
			pages = Integer.parseInt(parts[i + 3]);
		} catch (NumberFormatException e) {
			throw new LibraryException(e);
		}
		// questa classe gestisce 4 attributi più quelli della sua superclasse 
		return i + 4;
	}
}
