package it.epicode.w1d3.ex1;

public class Rectangle {
	// Variabili di istanza
	private double width;
	private double height;

	// Getters e Setters
	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		if (width < 0) return; // comunica un errore all'utente e non fa nulla!
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	// Costruttore
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

	// Metodi pubblici (in realtà sono due GETTERS che non prevedono variabili come
	// controparte ma restituiscono un'informazione sulla base del valore di più
	// variabili di stato.
	// Da un punto di vista logico sono identici ai getters di sopra.
	public double getArea() {
		return width * height;
	}

	public double getPerimeter() {
		return 2 * (width + height);
	}

	// Metodo di comodo per la rappresentazione del rettangolo come stringa
	public String toString() {
		return String.format("Rectangle[width=%f, height=%f]", width, height);
	}

}
