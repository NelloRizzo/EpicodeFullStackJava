package it.epicode.services;

public class AreaCalculatorImpl implements AreaCalculator{

	@Override
	public double getArea(Figure fig) {
		return fig.getWidthInMeters() * fig.getHeightInMeters();
	}

}
