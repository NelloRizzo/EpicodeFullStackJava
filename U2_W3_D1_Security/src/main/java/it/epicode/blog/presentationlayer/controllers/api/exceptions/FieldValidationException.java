package it.epicode.blog.presentationlayer.controllers.api.exceptions;

import java.util.List;

import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

public class FieldValidationException extends ValidationException {
	private static final long serialVersionUID = 1L;

	public final List<FieldError> errors;
	public final List<ObjectError> otherErrors;

	public FieldValidationException(List<ObjectError> errors) {
		this.errors = errors.stream().filter(a -> a instanceof FieldError).map(a -> (FieldError) a).toList();
		this.otherErrors = errors.stream().filter(a -> !(a instanceof FieldError)).toList();
	}
}
