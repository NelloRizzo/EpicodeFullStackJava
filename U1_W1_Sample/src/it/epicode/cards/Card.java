package it.epicode.cards;

/**
 * Una carta da gioco è rappresentata da un elemento che può avere un seme e un
 * valore.
 * 
 * @author Nello
 *
 */

// +------------------+
// | Carta da gioco   |
// +------------------+
// | seme           N |
// | valore         N |
// +------------------+
//
public abstract class Card {
	private int seed;
	private int value;

	public int getSeed() {
		return seed;
	}

	public int getValue() {
		return value;
	}

	public Card(int seed, int value) {
		this.seed = seed;
		this.value = value;
	}

	@Override
	public String toString() {
		return String.format("seme = %d - valore = %d", seed, value);
	}
}
