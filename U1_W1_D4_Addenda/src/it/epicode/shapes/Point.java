package it.epicode.shapes;

public class Point {
	private float x;
	private float y;

	public Point() {
		this(0, 0);
	}

	public Point(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}

	public void moveTo(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public void moveBy(float dx, float dy) {
		this.x += dx;
		this.y += dy;
	}
}
