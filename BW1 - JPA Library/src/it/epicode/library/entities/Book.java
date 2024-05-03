package it.epicode.library.entities;

import it.epicode.library.entities.constants.Tables;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = Tables.Names.BOOKS)
@DiscriminatorValue(Tables.Discriminators.BOOKS)
public class Book extends LibraryItem {
	@Column(length = 80, nullable = false)
	private String author;
	@Column(length = 20, nullable = false)
	private String kind;
}
