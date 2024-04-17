package it.epicode.w1d3.ex3;

import java.time.LocalDate;

public class Customer {
	private String code;
	private String name;
	private String email;
	private LocalDate registrationDate;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Customer(String code, String name, String email, LocalDate registrationDate) {
		super();
		this.code = code;
		this.name = name;
		this.email = email;
		this.registrationDate = registrationDate;
	}

	public String toString() {
		return String.format("Customer[code=%s, name=%s, email=%s, registrationDate=%s]", code, name, email,
				registrationDate);
	}
}
