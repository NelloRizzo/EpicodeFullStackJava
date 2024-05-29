package it.epicode;

public class SubOperator extends Operator {
	@Override
	public double execute(double first, double second, char op) {
		if (op == '-')
			return first - second;

		if (getNext() != null)
			return getNext().execute(first, second, op);

		return 0;
	}
}
