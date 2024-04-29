package it.epicde.data;

import java.util.Date;

import it.epicde.exceptions.InvalidFieldsCountLibraryException;

public class Book extends Item {
	private String author;
	private String category;

	public Book() {
	}

	public Book(Long id, Date createdAt, String isbn, String title, int pubYear, int pages, String author,
			String genre) {
		super(id, createdAt, isbn, title, pubYear, pages);
		this.author = author;
		this.category = genre;
	}

	public String getAuthor() {
		return author;
	}

	public String getCategory() {
		return category;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return String.format("Book(%s, author=%s, category=%s)", super.toString(), author, category);
	}

	@Override
	public String toCsv() {
		return String.format("%s;%s;%s", super.toCsv(), author, category);
	}

	@Override
	public int fromCsv(String csv) {
		int i = super.fromCsv(csv);
		var parts = csv.split(";");
		if (parts.length < (2 + i))
			throw new InvalidFieldsCountLibraryException(2 + i, parts.length);
		author = parts[i];
		category = parts[i + 1];
		return i + 2;
	}
}
