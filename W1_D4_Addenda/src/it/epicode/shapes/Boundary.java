package it.epicode.shapes;

/**
 * Rappresenta il rettangolo che inscrive una figura geometrica.
 * 
 * @author Nello Rizzo
 *
 */
public class Boundary {
	/**
	 * L'ascissa del primo vertice.
	 */
	private float x0;
	/**
	 * L'ordinata del primo vertice.
	 */
	private float y0;
	/**
	 * L'ascissa del secondo vertice.
	 */
	private float x1;
	/**
	 * L'ordinata del secondo vertice.
	 */
	private float y1;

	/**
	 * Costruisce il rettangolo a partire da due vertici opposti.
	 * 
	 * @param x0 ascissa del primo vertice.
	 * @param y0 ordinata del primo vertice.
	 * @param x1 ascissa del secondo vertice.
	 * @param y1 ordinata del secondo vertice.
	 */
	public Boundary(float x0, float y0, float x1, float y1) {
		this.x0 = x0;
		this.y0 = y0;
		this.x1 = x1;
		this.y1 = y1;
	}

	/**
	 * @return l'ascissa del primo vertice.
	 */
	public float getX0() {
		return x0;
	}

	/**
	 * @return l'ordinata del primo vertice.
	 */
	public float getY0() {
		return y0;
	}

	/**
	 * @return l'ascissa del secondo vertice.
	 */
	public float getX1() {
		return x1;
	}

	/**
	 * @return l'ordinata del secondo vertice.
	 */
	public float getY1() {
		return y1;
	}

	/**
	 * @param x0 l'ascissa del primo vertice.
	 */
	public void setX0(float x0) {
		this.x0 = x0;
	}

	/**
	 * @param y0 l'ordinata del primo vertice.
	 */
	public void setY0(float y0) {
		this.y0 = y0;
	}

	/**
	 * @param x1 l'ascissa del secondo vertice.
	 */
	public void setX1(float x1) {
		this.x1 = x1;
	}

	/**
	 * @param y1 l'ordinata del secondo vertice.
	 */
	public void setY1(float y1) {
		this.y1 = y1;
	}

	/**
	 * 
	 * @return la larghezza del rettangolo.
	 */
	public float getWidth() {
		return Math.abs(x0 - x1);
	}

	/**
	 * 
	 * @return l'altezza del rettangolo.
	 */
	public float getHeight() {
		return Math.abs(y0 - y1);
	}

	/**
	 * 
	 * @return le coordinate del punto in alto a sinistra.
	 */
	public Point getTopLeft() {
		return new Point(Math.min(x1, x0), Math.min(y1, y0));
	}

	/**
	 * 
	 * @return le coordinate del punto in alto a destra.
	 */
	public Point getTopRight() {
		return new Point(Math.max(x1, x0), Math.min(y1, y0));
	}

	/**
	 * 
	 * @return le coordinate del punto in basso a sinistra.
	 */
	public Point getBottomLeft() {
		return new Point(Math.min(x1, x0), Math.max(y1, y0));
	}

	/**
	 * 
	 * @return le coordinate del punto in basso a destra.
	 */
	public Point getBottomRight() {
		return new Point(Math.max(x1, x0), Math.max(y1, y0));
	}
}
