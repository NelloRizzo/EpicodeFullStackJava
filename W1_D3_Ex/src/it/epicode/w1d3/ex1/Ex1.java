package it.epicode.w1d3.ex1;

public class Ex1 {

	public static void printRectangle(Rectangle rect) {
		System.out.println("Il rettangolo " + rect + " ha un'area di " + rect.getArea() + " e un perimetro di "
				+ rect.getPerimeter());
	}

	public static void printRectangle2(Rectangle rect1, Rectangle rect2) {
		printRectangle(rect1);
		printRectangle(rect2);
		double a1 = rect1.getArea();
		double a2 = rect2.getArea();
		double p1 = rect1.getPerimeter();
		double p2 = rect2.getPerimeter();
		System.out.println("La somma delle aree è: " + (a1 + a2));
		System.out.println("La somma dei perimetri è: " + (p1 + p2));
	}

	public static void execute() {
		printRectangle(new Rectangle(10, 20));
		printRectangle2(new Rectangle(16, 31), new Rectangle(13, 26));
	}
}
