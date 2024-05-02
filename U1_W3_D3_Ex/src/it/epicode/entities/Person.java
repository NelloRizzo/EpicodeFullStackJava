package it.epicode.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Person {
	@Id
	@GeneratedValue
	private long id;
	@Column(length = 25, nullable = false)
	private String firstName;
	@Column(length = 25, nullable = false)
	private String lastName;
	@Column(length = 125, nullable = false)
	private String email;
	@Column(nullable = false)
	private Date birthday;
	@Enumerated(EnumType.ORDINAL)
	private Gender gender;
	@OneToMany(mappedBy = "person")
	private final List<Attendance> attendances = new ArrayList<>();

	public Person(String firstName, String lastName, String email, Date birthday, Gender gender) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.birthday = birthday;
		this.gender = gender;
	}

	public Person() {
	}

	public long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public Gender getGender() {
		return gender;
	}

	public List<Attendance> getAttendances() {
		return attendances;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return String.format(
				"Person[id=%s, firstName=%s, lastName=%s, email=%s, birthday=%s, gender=%s, attendances=%s]", id,
				firstName, lastName, email, birthday, gender, attendances);
	}

}
