package it.epicode.bw1.transportcompany.entities.users;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Card {
	@Column(nullable = false)
	private String number;
	@Column(nullable = false)
	private LocalDateTime issuedAt;

	public Card() {
	}

	public Card(String number, LocalDateTime issuedAt) {
		this.number = number;
		this.issuedAt = issuedAt;
	}

	public String getNumber() {
		return number;
	}

	public LocalDateTime getIssuedAt() {
		return issuedAt;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setIssuedAt(LocalDateTime issuedAt) {
		this.issuedAt = issuedAt;
	}

	public LocalDateTime getExpiration() {
		return issuedAt.plusYears(1);
	}

	public boolean isExpired() {
		return LocalDateTime.now().isBefore(getExpiration());
	}

	@Override
	public String toString() {
		return String.format("Card(name=%s, issuedAt=%s, expiration=%s, isExpired=%s)", number, issuedAt,
				getExpiration(), isExpired());
	}
}
