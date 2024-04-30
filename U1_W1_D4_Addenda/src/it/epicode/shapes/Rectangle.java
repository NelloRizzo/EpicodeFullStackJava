package it.epicode.shapes;

import it.epicode.canvas.Canvas;

public class Rectangle extends Shape {

	public Rectangle(float x0, float y0, float x1, float y1) {
		super(new Boundary(x0, y0, x1, y1));
	}

	@Override
	public void draw(Canvas c) {
		Point tl = bounds.getTopLeft();
		Point tr = bounds.getTopRight();
		Point bl = bounds.getBottomLeft();
		Point br = bounds.getBottomRight();
		// alto sinistra - alto destra
		c.line(tl.getX(), tl.getY(), tr.getX(), tl.getY());
		// basso sinistra - basso destra
		c.line(bl.getX(), bl.getY(), br.getX(), bl.getY());
		// alto sinistra - basso sinistra
		c.line(tl.getX(), tl.getY(), bl.getX(), bl.getY());
		// alto destra - basso destra
		c.line(tr.getX(), tr.getY(), br.getX(), br.getY());
	}

}
