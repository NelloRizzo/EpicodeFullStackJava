package it.epicode;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("E")
public class Email extends Recapito {
	@Column(length = 125, nullable = true)
	private String email;

	public Email() {
	}

	public Email(String email, boolean lavoro) {
		super(lavoro);
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return String.format("Email[id=%s, email=%s, lavoro=%s]", getId(), email, isLavoro());
	}

}
