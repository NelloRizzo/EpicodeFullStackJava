package it.epicode.media;

/**
 * Un elemento in grado di controllare un'intensità che varia in un range.
 * 
 * @author Nello Rizzo
 *
 */
public class Control {

	/**
	 * Simbolo usato per la rappresentazione come stringa dell'internsità.
	 */
	private final Character symbol;
	/**
	 * Valore minimo.
	 */
	private final int min;
	/**
	 * Valore massimo.
	 */
	private final int max;
	/**
	 * Valore corrente.
	 */
	private int value;

	/**
	 * Costruttore.
	 * 
	 * @param min     il valore minimo.
	 * @param max     il valore massimo.
	 * @param current il valore corrente.
	 * @param symbol  il simbolo usato per la rappresentazione come stringa.
	 */
	public Control(int min, int max, int current, char symbol) {
		this.min = min;
		this.max = max;
		this.value = current;
		this.symbol = symbol;
	}

	/**
	 * @return il valore corrente.
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @return il valore minimo.
	 */
	public int getMin() {
		return min;
	}

	/**
	 * 
	 * @return il valore massimo.
	 */
	public int getMax() {
		return max;
	}

	/**
	 * Aumenta l'intensità.
	 */
	public void up() {
		if (value < max)
			++value;
	}

	/**
	 * Diminuisce l'intensità.
	 */
	public void down() {
		if (value > min)
			--value;
	}

	@Override
	public String toString() {
		return symbol.toString().repeat(value);
	}
}
