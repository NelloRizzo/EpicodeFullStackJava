package it.epicode.app;

import it.epicode.library.services.IsbValidatorImpl;

public class Program {
	public static void main(String[] args) {
		Application.run(new IsbValidatorImpl());
	}
}
