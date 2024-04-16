package it.epicode.guessthenumber;

import java.util.Random;
import java.util.Scanner;

public class Program {
	/*
	 * Indovina il numero.
	 * 
	 * Il computer pensa ad un numero compreso tra 1 e 1000, l'utente ha a
	 * disposizione 10 tentativi per indovinarlo sulla base di un feedback fornito
	 * ad ogni tentativo.
	 * 
	 * Esempio: Supponendo che il computer abbia "pensato" al numero 234
	 * 
	 * Tentativo n. 1: 500 Risposta: il numero è più piccolo Tentativo n. 2: 100
	 * Risposta: il numero è più grande Tentativo n. 3: 234 Risposta: BRAVO! Hai
	 * indovinato con 3 tentativi
	 * 
	 */
	public static void main(String[] args) {
		// 1. devo "pensare" ad un numero
		// 1.1. posso simulare con un numero casuale
		int target = new Random().nextInt(1, 1001);
		// 1.2. AI FINI DI TEST STAMPO IL NUMERO DA INDOVINARE
		System.out.println(target);
		// 2. imposto a 10 il numero massimo di tentativi
		int max_attempts = 10;
		// 3. inizio a contare i tentativi
		int attempts = 0;
		// 3.1. USO UNA "SPIA" per capire se l'utente ha indovinato
		boolean won = false;
		// 4. se i tentativi sono minori del numero massimo
		// quando i tentativi sono < maxtentativi E l'utente NON HA VINTO 
		while (attempts < max_attempts && !won) {
			// 4.0.1. incremento il numero totale di tentativi
			++attempts;
			// 4.1. chiedo di fare un tentativo
			System.out.print("Tentativo n. " + attempts + ": ");
			// 4.1.1. leggo ciò che l'utente scrive da tastiera:
			int answer = new Scanner(System.in).nextInt();
			// 4.2. il numero scritto è maggiore
			if (answer > target) {
				// 4.2.1. comunico il feedback
				System.out.println("Hai scritto un numero più grande");
			} else if (answer < target) {
				// 4.3. il numero scritto è minore
				// 4.3.1. comunico il feedback
				System.out.println("Hai scritto un numero più piccolo");
			} else {
				// 4.4. il numero scritto è uguale
				// 4.4.1. hai indovinato!
				System.out.println("Bravo! Hai indovinato in " + attempts + " tentativi");
				won = true; // metto a true la spia così il while fallisce
			}
		}
		// 5. mostro un riassunto del risultato del gioco
		if (!won) { // se l'utente NON HA VINTO {
			System.out.println("Hai perso! Il numero era " + target);
		}
		System.out.println("Il gioco è terminato");
	}

}
