package it.epicode.w2d4.services;

public interface MailService {

	public record ServiceResponse(String message, int statusCode) {
	}

	ServiceResponse sendMail(String from, String to, String subject, String body);
}
