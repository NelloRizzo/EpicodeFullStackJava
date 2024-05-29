package it.epicode;

public class Calculator {
	private Operator chain;
	private Operator last;

	public Calculator setNext(Operator op) {
		if (chain == null) {
			chain = op;
			last = chain;
		} else {
			last.next(op);
			last = op;
		}
		return this;
	}

	void executeOperation(double first, double second, char op) {
		if (chain == null)
			System.out.println("Nessun operatore in catena.");
		else {
			var result = chain.execute(first, second, op);
			System.out.format("Risultato: %s\n", result);
		}
	}
}
