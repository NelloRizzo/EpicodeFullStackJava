package it.epicode.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class PersonKey implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private String surname;
	private Date birthday;

	public PersonKey(String name, String surname, Date birthday) {
		this.name = name;
		this.surname = surname;
		this.birthday = birthday;
	}

	public PersonKey() {
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

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return String.format("PersonKey[name=%s, surname=%s, birthday=%s]", name, surname, birthday);
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof PersonKey && obj.hashCode() == hashCode();
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, surname, birthday);
	}
}
