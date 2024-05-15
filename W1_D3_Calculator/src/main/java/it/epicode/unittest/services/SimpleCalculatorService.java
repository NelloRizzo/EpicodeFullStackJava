package it.epicode.unittest.services;

import org.springframework.stereotype.Component;

@Component
public class SimpleCalculatorService implements CalculatorService {

	private double accumulator = 0;

	@Override
	public double getAccumulator() {
		return accumulator;
	}

	@Override
	public void add(double value) {
		accumulator += value;
	}

	@Override
	public void sub(double value) {
		accumulator -= value;
	}

	@Override
	public void mul(double value) {
		accumulator *= value;
	}

	@Override
	public void div(double value) {
		if (value == 0)
			throw new RuntimeException("Divisore non può essere 0");
		accumulator /= value;
	}

}
