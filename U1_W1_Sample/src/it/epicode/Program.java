package it.epicode;

import it.epicode.cards.Card;
import it.epicode.cards.NeapoleanCard;
import it.epicode.cards.exceptions.CardException;
import it.epicode.cards.exceptions.CardSeedException;
import it.epicode.cards.exceptions.CardValueException;

public class Program {

	public static void main(String[] args) {
		Card c = new NeapoleanCard(0, 6);
		System.out.println(c);

		try {
			c = new NeapoleanCard(1, -6);
			System.out.println(c);
		} 
		catch (CardSeedException e) {
			System.out.println("Seme sbagliato");
		}
		catch (CardValueException e) {
			System.out.println("Valore sbagliato");
		} 
		catch (CardException e) {
			System.out.println("Problema di gestione della carta da gioco");
		}

	}

}
