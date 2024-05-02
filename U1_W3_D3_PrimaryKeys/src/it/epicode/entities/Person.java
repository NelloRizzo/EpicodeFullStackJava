package it.epicode.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "people")
@IdClass(PersonKey.class)
public class Person {
	@Id
	@Column(length = 25, nullable = false)
	private String name;
	@Id
	@Column(length = 25, nullable = false)
	private String surname;
	@Id
	@Column(nullable = false)
	private Date birthday;
	
	@ManyToOne
	private City city;
	
	@Column(length = 50)
	private String occupation;

	@OneToOne
	@JoinColumn(name = "passport_fk")
	private Passport passport;

	public Person() {
	}

	public Person(String name, String surname, Date birthday, City city, String occupation, Passport passport) {
		this.name = name;
		this.surname = surname;
		this.birthday = birthday;
		this.city = city;
		this.occupation = occupation;
		this.passport = passport;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public Date getBirthday() {
		return birthday;
	}

	public City getCity() {
		return city;
	}

	public String getOccupation() {
		return occupation;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	@Override
	public String toString() {
		return String.format("Person[name=%s, surname=%s, birthday=%s, city=%s, occupation=%s, passport=%s]", name,
				surname, birthday, city, occupation, passport);
	}

}
