package it.epicode;

import it.epicode.canvas.BWCanvas;
import it.epicode.canvas.Canvas;
import it.epicode.shapes.Circle;
import it.epicode.shapes.Ellipse;
import it.epicode.shapes.Rectangle;
import it.epicode.shapes.Square;

public class Program {

	public static void printCanvas(Canvas canvas) {
		for (int y = 0; y < canvas.getHeight(); ++y) {
			for (int x = 0; x < canvas.getWidth(); ++x) {
				System.out.print(canvas.isOn(x, y) ? '.' : ' ');
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		BWCanvas c = new BWCanvas(80, 25);
		c.line(0, 0, 5, 5);
		new Rectangle(10, 10, 50, 20).draw(c);
		new Square(11, 11, 8).draw(c);
		new Ellipse(40, 12, 30, 8).draw(c);
		new Circle(40, 12, 8).draw(c);
		printCanvas(c);
	}

}
