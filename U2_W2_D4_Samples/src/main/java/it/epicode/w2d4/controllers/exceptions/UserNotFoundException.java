package it.epicode.w2d4.controllers.exceptions;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;

public class UserNotFoundException extends ApiValidationException {
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(List<ObjectError> errors) {
		super(errors, HttpStatus.NOT_FOUND, "Utente non trovato");
	}

}
