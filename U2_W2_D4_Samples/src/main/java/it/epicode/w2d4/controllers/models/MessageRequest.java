package it.epicode.w2d4.controllers.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record MessageRequest( //
		@NotNull(message = "Il destinatario non può essere omesso") //
		@Email(message = "L'indirizzo email del destinatario non è corretto") //
		String recipient, //
		@NotNull(message = "Il mittente non può essere omesso") //
		@Email(message = "L'indirizzo email del mittente non è corretto") //
		String sender, //
		@NotNull(message = "Il titolo del messaggio non può essere omesso") //
		@NotBlank(message = "Il titolo del messaggio non può essere vuoto o composto solo da spazi") //
		@Size(max = 80, message = "Il titolo del messaggio non può essere più lungo di 80 caratteri") //
		String title, //
		@NotNull(message="Il corpo del messaggio non può essere omesso") //
		@Size(max = 1024, message="La lunghezza del messaggio non può superare i 1024 caratteri") //
		String body) {
}
