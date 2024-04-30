package it.epicode.shapes;

import it.epicode.canvas.Canvas;

/**
 * Definizione di entità che sono disegnabili su un canovaccio.
 * 
 * @author Nello Rizzo
 *
 */
public interface Drawable {
	/**
	 * Disegna l'entità sul canovaccio.
	 * 
	 * @param c il canovaccio su cui disegnare.
	 */
	void draw(Canvas c);
}
