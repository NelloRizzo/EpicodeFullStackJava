package it.epicode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * Supponiamo di voler gestire un elenco telefonico in cui ogni [contatto]
 * possiede [un nome], [un cognome], [un nickname] e [un numero di telefono].
 * 
 * Le operazioni da effettuarsi sono:
 * aggiunta, eliminazione, recupero attraverso il nickname, oltre al recupero di tutta la lista.
 */
public class Program {

	public static void main(String[] args) {
		List<Contatto> rubrica = new ArrayList<>();
		// aggiunta di contatto
		rubrica.add(new Contatto("Paperon", "De' Paperoni", "paperone", "12345678"));
		rubrica.add(new Contatto("Archimede", "Pitagorico", "archi", "31415926"));
		rubrica.add(new Contatto("Pico", "De' Paperis", "pico", "65234626"));
		rubrica.add(new Contatto("Paperon", "De' Paperoni", "paperone", "46526525"));
		rubrica.remove(0);
		
		System.out.println("Lista:");
		// recupero dell'elenco
		for (Contatto c : rubrica) {
			System.out.println(c);
		}

		System.out.println("Set:");
		Set<Contatto> rubrica2 = new HashSet<>();
		// aggiunta di contatto
		rubrica2.add(new Contatto("Paperon", "De' Paperoni", "paperone", "12345678"));
		rubrica2.add(new Contatto("Archimede", "Pitagorico", "archi", "31415926"));
		rubrica2.add(new Contatto("Pico", "De' Paperis", "pico", "65234626"));
		rubrica2.add(new Contatto("Paperon", "De' Paperoni", "paperone", "46526525"));
		rubrica2.remove(new Contatto("", "", "pico", ""));
		// recupero dell'elenco
		for (var c : rubrica2) {
			System.out.println(c);
		}
		System.out.println("Mappa:");
		Map<String, Contatto> rubrica3 = new HashMap<>();
		rubrica3.put("paperone", new Contatto("Paperon", "De' Paperoni", "paperone", "12345678"));
		rubrica3.put("archimede", new Contatto("Archimede", "Pitagorico", "archi", "31415926"));
		rubrica3.put("pico", new Contatto("Pico", "De' Paperis", "pico", "65234626"));
		rubrica3.put("paperone", new Contatto("Paperon", "De' Paperoni", "paperone", "46526525"));
		rubrica3.remove("archimede");
		for (Contatto c : rubrica3.values()) {
			System.out.println(c);
		}
		// type inference -> il compilatore sceglie il tipo di dato associato alla variabile
		// leggendolo dal risultato dell'espressione a destra dell'operatore di assegnazione
		var rubrica4 = new HashMap<String, Contatto>();
		var i = 10+ 4;
		var f = 10f + 4;
		var d = 10.0 + 4;
	}

}
