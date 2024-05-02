package it.epicode.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cities")
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(length = 80)
	private String name;

	@OneToMany(mappedBy = "city")
	private final List<Person> people = new ArrayList<>();

	public City(String name) {
		this.name = name;
	}

	public City() {
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Person> getPeople() {
		return people;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("City[id=%s, name=%s]", id, name);
	}

}
