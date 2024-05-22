package it.epicode.w2d3.config;

import java.time.LocalDateTime;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import it.epicode.w2d3.services.exceptions.MyProjectException;
import lombok.AllArgsConstructor;
import lombok.Data;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

	@Data
	@AllArgsConstructor
	public static class MyExceptionInfoModel {
		private String message;
		private LocalDateTime occurredAt;
		private HttpStatus status;
	}

	@ExceptionHandler(MyProjectException.class)
	protected ResponseEntity<?> handleMyProjectException(MyProjectException e) {
		var info = new MyExceptionInfoModel(e.getMessage(), e.occurredAt, HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(info, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
