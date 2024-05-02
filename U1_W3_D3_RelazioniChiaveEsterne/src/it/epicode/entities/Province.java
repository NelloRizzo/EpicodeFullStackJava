package it.epicode.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Province extends BaseEntity {
	@Column(length = 80, nullable = false)
	private String name;
	@Column(length = 2, nullable = false)
	private String acronym;

	public Province(String name, String acronym) {
		this.name = name;
		this.acronym = acronym;
	}

	public String getName() {
		return name;
	}

	public String getAcronym() {
		return acronym;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}

	@Override
	public String toString() {
		return String.format("Province[id=%d, name=%s, acronym=%s]", getId(), name, acronym);
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Province && obj.hashCode() == hashCode();
	}

	@Override
	public int hashCode() {
		return Objects.hash(acronym);
	}
}
