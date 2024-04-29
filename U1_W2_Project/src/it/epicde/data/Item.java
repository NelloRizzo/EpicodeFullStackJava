package it.epicde.data;

import java.util.Date;

import it.epicde.exceptions.InvalidFieldsCountLibraryException;
import it.epicde.exceptions.LibraryException;

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

	public String getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	public int getPubYear() {
		return pubYear;
	}

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
		return i + 4;
	}
}
