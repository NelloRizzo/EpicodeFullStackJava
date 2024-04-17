package it.epicode.oop;

/**
 * Abbiamo la necessità di gestire 5 diverse [persone] che possano 
 * <presentare se stesse> al mondo comunicando [il proprio nome] e [il 
 * proprio cognome].
 * 
 * Concetti da modellare:
 * Persona
 * 1 |
 *   +----- 1 Nome -> sequenza di caratteri alfabetici
 *   |
 *   +----- 1 Cognome -> sequenza di caratteri alfabetici
 * 
 * Azioni da implementare:
 * presentaTeStesso - di competenza di Persona
 * 
 */
public class Program {

	public static void main(String[] args) {
		Persona paperone = new Persona();
		Persona archimede = new Persona("Archimede", "Pitagorico");
//		paperone.nome = "Paperon";
//		paperone.cognome = "De' Paperoni";
//		archimede.nome ="Archimede";
//		archimede.cognome = "Pitagorico";
		paperone.presentaTeStesso();
		archimede.presentaTeStesso();
		
		Persona nonna = new Persona("Nonna", "Papera", Gender.Female);
//		nonna.gender = Gender.Female;
		nonna.presentaTeStesso();
		//nonna.numeroFigli = -4;
		nonna.setNumeroFigli(-4);
		System.out.println(nonna.getNumeroFigli());
	}
}
