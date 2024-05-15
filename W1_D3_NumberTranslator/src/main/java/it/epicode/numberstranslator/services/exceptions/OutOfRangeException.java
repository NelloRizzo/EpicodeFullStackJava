package it.epicode.numberstranslator.services.exceptions;

/**
 * Comunica che si è tentato di tradurre un numero che va oltre il limite fisico
 * previsto dal servizio.
 *
 */
public class OutOfRangeException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public final int number;
	
	public OutOfRangeException(int number) {
		super(String.format("Value %s is out of range", number));
		this.number = number;
	}
}
