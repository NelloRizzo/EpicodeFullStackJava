package it.epicode.library.entities;

import it.epicode.library.entities.constants.Tables;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

/**
 * Un elemento che può essere gestito in libreria.
 */
@Entity // questa è una classe reale usata come base per l'ereditarietà
@Table(name = Tables.Names.LIBRARY_BASE)
@Inheritance(strategy = InheritanceType.JOINED) // ho scelto questa strategia...

//qui vado a definire il nome della colonna discriminante
@DiscriminatorColumn(name = Tables.Columns.DISCRIMINATOR, discriminatorType = DiscriminatorType.INTEGER)
public abstract class LibraryItem //
		// estendendo BaseEntity ottengo già la gestione di Id e InsertedAt
		extends BaseEntity {
	@Column(length = 13, nullable = false)
	private String isbn;
	@Column(length = 125, nullable = false)
	private String title;
	private int publicationYear;
	private int pages;

	public LibraryItem(String isbn, String title, int publicationYear, int pages) {
		this.isbn = isbn;
		this.title = title;
		this.publicationYear = publicationYear;
		this.pages = pages;
	}

	public LibraryItem() {
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	public int getPublicationYear() {
		return publicationYear;
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

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	@Override
	public String toString() {
		return String.format("LibraryItem [isbn=%s, title=%s, publicationYear=%s, pages=%s, insertedAt=%s, id=%s]",
				isbn, title, publicationYear, pages, getInsertedAt(), getId());
	}

}
