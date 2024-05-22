package it.epicode.w2d3.services.exceptions;

import java.time.LocalDateTime;

public class MyProjectException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public final LocalDateTime occurredAt;
	
	public MyProjectException(String message) {
		super(message);
		occurredAt = LocalDateTime.now();
	}
}
