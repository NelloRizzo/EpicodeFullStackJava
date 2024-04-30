package it.epicode.employees;

import java.util.Objects;

public class Volunteer implements CheckableIn {
	private String name;
	private int age;
	private String cv;

	public Volunteer(String name, int age, String cv) {
		this.name = name;
		this.age = age;
		this.cv = cv;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getCv() {
		return cv;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, age);
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof Volunteer) && obj.hashCode() == this.hashCode();
	}

	@Override
	public String toString() {
		return String.format("Volunteer[name=%s, age=%s, cv=%s]", name, age, cv);
	}

	@Override
	public void checkIn() {
		System.out.println(this + " ha iniziato il suo servizio.");
	}


}
