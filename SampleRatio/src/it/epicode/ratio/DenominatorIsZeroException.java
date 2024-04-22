package it.epicode.ratio;

public class DenominatorIsZeroException extends RuntimeException {

	public DenominatorIsZeroException() {
		super();
	}

	public DenominatorIsZeroException(String message) {
		super(message);
	}
}
