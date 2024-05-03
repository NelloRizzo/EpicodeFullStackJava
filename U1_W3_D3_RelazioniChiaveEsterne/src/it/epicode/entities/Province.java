package it.epicode.entities;

import java.util.Objects;

import it.epicode.entities.constants.Queries;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQuery(name = Queries.Provinces.ALL, query = "SELECT p FROM Province p ORDER BY p.name")
@NamedQuery(name = Queries.Provinces.BY_ACRONYM, query = "SELECT p FROM Province p WHERE p.acronym = :acronym")
@NamedQuery(name = Queries.Provinces.COUNT, query = "SELECT COUNT(id) FROM Province p")
@NamedQuery(name = Queries.Provinces.BY_SAMPLE, //
		query = "SELECT p FROM Province p WHERE p.name LIKE :sample ORDER BY p.name")
public class Province extends BaseEntity {
	@Column(length = 80, nullable = false)
	private String name;
	@Column(length = 2, nullable = false)
	private String acronym;

	public Province() {
	}

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
