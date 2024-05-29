package it.epicode;

public abstract class Operator {
	private Operator next = null;

	public Operator getNext() {
		return next;
	}

	public void next(Operator next) {
		this.next = next;
	}

	public abstract double execute(double first, double second, char op);
}
