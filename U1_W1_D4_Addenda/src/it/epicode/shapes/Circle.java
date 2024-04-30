package it.epicode.shapes;

/**
 * Un cerchio.
 * 
 * @author Nello Rizzo
 *
 */
public class Circle extends Ellipse {
/**
 * 
 * @param cx ascissa del centro.
 * @param cy ordinata del centro.
 * @param radius raggio.
 */
	public Circle(float cx, float cy, float radius) {
		super(cx, cy, radius, radius);
	}

}
