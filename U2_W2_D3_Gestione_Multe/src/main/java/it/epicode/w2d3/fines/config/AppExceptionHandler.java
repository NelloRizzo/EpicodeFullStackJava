package it.epicode.w2d3.fines.config;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import it.epicode.w2d3.fines.services.exceptions.DuplicateKeyAppException;
import lombok.AllArgsConstructor;
import lombok.Data;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

	@Data
	@AllArgsConstructor
	public static class ExceptionInfoModel {
		private String message;
		private String invalidPlate;
	}

	@ExceptionHandler(DuplicateKeyAppException.class)
	protected ResponseEntity<?> handleApplicationException(DuplicateKeyAppException e) {
		return new ResponseEntity<>(new ExceptionInfoModel(e.getMessage(), e.duplicateKey), //
				HttpStatus.BAD_REQUEST);
	}
}
