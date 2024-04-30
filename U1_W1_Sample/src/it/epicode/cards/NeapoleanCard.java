package it.epicode.cards;

import it.epicode.cards.exceptions.CardSeedException;
import it.epicode.cards.exceptions.CardValueException;

public class NeapoleanCard extends Card {

	public NeapoleanCard(int seed, int value) {
		super(seed, value);
		
		if (seed < 0 || seed > 3)
			throw new CardSeedException();
		if (value < 1 || value > 10)
			throw new CardValueException();
	}
}
