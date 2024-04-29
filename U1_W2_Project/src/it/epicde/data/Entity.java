package it.epicde.data;

import java.util.Date;

import it.epicde.exceptions.DataMismatchLibraryException;
import it.epicde.exceptions.InvalidFieldsCountLibraryException;
import it.epicde.exceptions.LibraryException;

public class Entity {
	private Long id;
	private Date createdAt;

	public Entity() {
	}

	public Entity(Long id, Date createdAt) {
		this.id = id;
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return String.format("Entity(id=%s, createdAt=%s)", id, createdAt);
	}

	public String toCsv() {
		return String.format("%s;%d;%d", getClass().getCanonicalName(), id, createdAt.getTime());
	}

	public int fromCsv(String csv) {
		var parts = csv.split(";");
		// controlla che sta leggendo un dato della giusta classe!
		if (!getClass().getCanonicalName().equals(parts[0]))
			throw new DataMismatchLibraryException(getClass().getCanonicalName(), parts[0]);
		if (parts.length < 3)
			throw new InvalidFieldsCountLibraryException(3, parts.length);
		try {
			id = Long.parseLong(parts[1]);
			createdAt = new Date(Long.parseLong(parts[2]));
		} catch (NumberFormatException e) {
			throw new LibraryException(e);
		}
		return 3;
	};

}
