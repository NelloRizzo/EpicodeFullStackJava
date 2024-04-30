package it.epicode.shapes;

import it.epicode.canvas.Canvas;

/**
 * Un'ellissi.
 * 
 * @author Nello Rizzo
 *
 *         L'ellissi è vista come un cerchio schiacciato, quindi con un centro e
 *         due raggi: uno rapprensenta in orizzontale la distanza del centro dal
 *         perimetro, l'altro la distanza in verticale.
 */
public class Ellipse extends Shape {

	private Point center;
	private float xRadius;
	private float yRadius;

	public Ellipse(float cx, float cy, float xr, float yr) {
		super(new Boundary(cx - xr, cy - yr, cx + yr, cy + yr));
		center = new Point(cx, cy);
		xRadius = xr;
		yRadius = yr;
	}

	@Override
	public void draw(Canvas c) {
		for (float a = 0; a < 6.3; a += .1f) {
			float x = (float) (center.getX() + xRadius * Math.cos(a));
			float y = (float) (center.getY() + yRadius * Math.sin(a));
			c.setPoint(x, y);
		}
	}
}
