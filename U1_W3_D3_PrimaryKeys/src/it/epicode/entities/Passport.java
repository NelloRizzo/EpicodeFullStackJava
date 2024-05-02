package it.epicode.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

//@Embeddable
@Entity
@Table(name = "passports")
public class Passport {
	@Id
	@GeneratedValue
	private long id;
	@Column(length = 80, nullable = false)
	private String number;
	@OneToOne(mappedBy = "passport", fetch = FetchType.EAGER)
	private Person owner;

	public Passport(String number) {
		this.number = number;
	}

	public Passport() {
	}

	public long getId() {
		return id;
	}

	public String getNumber() {
		return number;
	}

	public Person getOwner() {
		return owner;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setOwner(Person p) {
		this.owner = p;
	}

	@Override
	public String toString() {
		return String.format("Passport[id=%s, number=%s]", id, number);
	}

}
