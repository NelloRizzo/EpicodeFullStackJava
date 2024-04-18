package it.epicode.canvas;

/**
 * Un "canovaccio" grafico in grado di gestire una griglia rettangolare di punti
 * che possano essere "accesi" e "spenti".
 * 
 * @author Nello Rizzo
 *
 */
public interface Canvas {
	/**
	 * 
	 * @return la larghezza della griglia.
	 */
	float getWidth();

	/**
	 * 
	 * @return l'altezza della griglia.
	 */
	float getHeight();

	/**
	 * Accende un punto.
	 * 
	 * @param x ascissa del punto.
	 * @param y ordinata del punto.
	 */
	void setPoint(float x, float y);

	/**
	 * Spegne un punto.
	 * 
	 * @param x ascissa del punto.
	 * @param y ordinata del punto.
	 */
	void resetPoint(float x, float y);

	/**
	 * Controlla lo stato di un punto della griglia.
	 * 
	 * @param x ascissa del punto.
	 * @param y ordinata del punto.
	 * @return un valore booleano che indica se il punto è acceso ({@code true}) o
	 *         spento ({@code false}).
	 */
	boolean isOn(float x, float y);

	/**
	 * Spegne tutti i punti della griglia.
	 */
	void clear();

	/**
	 * Traccia una linea nella griglia.
	 * 
	 * @param x0 ascissa del punto di partenza.
	 * @param y0 ordinata del punto di partenza.
	 * @param x1 ascissa del punto di arrivo.
	 * @param y1 ordinata del punto di arrivo.
	 */
	void line(float x0, float y0, float x1, float y1);
}
