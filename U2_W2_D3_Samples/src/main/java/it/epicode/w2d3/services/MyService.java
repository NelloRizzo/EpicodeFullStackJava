package it.epicode.w2d3.services;

import org.springframework.stereotype.Service;

import it.epicode.w2d3.services.exceptions.MyProjectException;

@Service
public class MyService implements ExceptionHandlingSampleService {

	@Override
	public void testExceptionHandling(boolean activate) {
		if (activate)
			throw new MyProjectException("Ops... si è verificato un problema");
	}

}
