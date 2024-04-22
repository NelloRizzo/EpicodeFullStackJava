package it.epicode.oop;

/**
 * Abbiamo la necessità di gestire 5 diverse [persone] che possano <presentare
 * se stesse> al mondo comunicando [il proprio nome] e [il proprio cognome].
 * 
 * Concetti da modellare: Persona 1 | +----- 1 Nome -> sequenza di caratteri
 * alfabetici | +----- 1 Cognome -> sequenza di caratteri alfabetici
 * 
 * Azioni da implementare: presentaTeStesso - di competenza di Persona
 * 
 */
public class Program {

	public static void old_main(String[] args) {
		Persona paperone = new Persona("", "");
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
		// nonna.numeroFigli = -4;
		nonna.setNumeroFigli(-4);
		System.out.println(nonna.getNumeroFigli());
	}

	public static void main(String[] args) {

		Persona p = new Persona("Nonna", "Papera", Gender.Female);
		System.out.println(p);
		try {
			Persona p1 = new Persona("Paperon", "De' Paperoni");
			p1.setNumeroFigli(-10);
			System.out.println(p1);
		}
//		catch (NumeroFigliNegativoException e) {
//			System.out.println("Una persona non può avere un numero di figli negativo");
//		} 
//		catch (CognomeNulloException ex) {
//			System.out.println("Non può esistere una persona senza cognome");
//		} catch (NomeNulloException ex) {
//			System.out.println("Non può esistere una persona senza nome");
//		}
		catch (CognomeNulloException | NomeNulloException ex) {
			System.out.println("Devi specificare sia il nome che il cognome");
		} catch (Exception es) {
			System.out.println("Si è verificato un problema non previsto");
		}

		System.out.println("Fine normale dell'applicazione");
	}
}
