package it.epicode.shapes;

public abstract class Shape implements Drawable {
	protected final Boundary bounds;

	public Shape(Boundary bounds) {
		this.bounds = bounds;
	}
}
