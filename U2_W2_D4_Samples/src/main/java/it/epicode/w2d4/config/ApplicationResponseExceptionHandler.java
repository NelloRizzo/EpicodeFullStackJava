package it.epicode.w2d4.config;

import java.util.List;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import it.epicode.w2d4.controllers.exceptions.ApiValidationException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ApplicationResponseExceptionHandler extends ResponseEntityExceptionHandler {

	public record ValidationError(String field, String message) {
	}

	@ExceptionHandler(ApiValidationException.class)
	protected ResponseEntity<?> handleApiValidationException(ApiValidationException e) {
		var body = e.errors.stream() //
				.filter(error -> error instanceof FieldError)//
				.map(error -> (FieldError) error) //
				.map(error -> new ValidationError(error.getField(), error.getDefaultMessage())//
				).toList();
		return new ResponseEntity<List<ValidationError>>(body, e.status);
	}
}
