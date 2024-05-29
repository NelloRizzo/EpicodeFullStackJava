package it.epicode;

import java.util.Arrays;
import java.util.List;

import it.epicode.services.AreaCalculator;
import it.epicode.services.AreaCalculatorImpl;
import it.epicode.services.Figure;

public class Program {

	private static final AreaCalculator calculator = new AreaCalculatorImpl();

	public static void myWorld(Figure fig) {
		var r = calculator.getArea(fig);
		System.out.format("L'area di %s è %s\n", fig, r);
	}

	public static void main(String[] args) {
		var f1 = new Figure(10, 40);
		var f2 = new Figure(1.3, 6.7);
		myWorld(f1);
		myWorld(f2);

		var m1 = new MyFigure(10, 40);
		myWorld(new FigureAdapter(m1));

		String[] sample = { "Esempio", "di", "Adapter" };
		List<String> ls = Arrays.asList(sample);
		ls.forEach(System.out::println);
	}

}
