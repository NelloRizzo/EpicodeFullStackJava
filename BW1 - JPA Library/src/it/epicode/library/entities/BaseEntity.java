package it.epicode.library.entities;

import java.util.Date;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

/**
 * Caratteristiche comuni a tutte le entità.
 */
@MappedSuperclass // perché non rappresenta una gerarchia sui dati ma solo sulle classi
public class BaseEntity {
	@Id
	@GeneratedValue
	private long id;
	private Date insertedAt = new Date();

	public BaseEntity() {
	}

	public long getId() {
		return id;
	}

	public Date getInsertedAt() {
		return insertedAt;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setInsertedAt(Date insertedAt) {
		this.insertedAt = insertedAt;
	}

}
