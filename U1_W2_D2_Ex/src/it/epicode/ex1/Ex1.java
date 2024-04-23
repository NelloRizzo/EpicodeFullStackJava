package it.epicode.ex1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import it.epicode.Executable;

public class Ex1 implements Executable {

	// Stringhe univoche gestite
	private Set<String> words;
	// duplicati: per ogni duplicato, la stringa è la chiave e il valore indicizzato
	// è il numero di occorrenze duplicate
	private Map<String, Integer> duplicates;

	public Ex1(int wordsCount) {
		// costruisce un set predisponendo un numero INIZIALE di elementi prefissato
		words = new HashSet<>(wordsCount);
		duplicates = new HashMap<>(wordsCount);
	}

	public final Iterable<String> getWords() {
		return words;
	}

	public Map<String, Integer> getDuplicates() {
		return duplicates;
	}

	public void add(String word) {
		// richiama il metodo add del set:
		// se add restituisce false, significa che l'elemento è già presente nel set
		if (!words.add(word)) {
			// recupero il conteggio dei duplicati dalla mappa
			var w = duplicates.get(word);
			// se non ci sono duplicati, la mappa restituisce null
			if (w == null) // non si sono duplicati per questa parola
				w = 0; // inizializzo il contatore dei duplicati a 0
			duplicates.put(word, w + 1);
		}
	}

	@Override
	public void execute() {
		var ex1 = new Ex1(5);
		ex1.add("Uno");
		ex1.add("Due");
		ex1.add("Tre");
		ex1.add("Due");
		ex1.add("Due");
		ex1.add("Tre");

		System.out.println("Duplicati:");
		var dup = ex1.getDuplicates();
		for (var key : dup.keySet()) {
			System.out.format("%s (%d occorrenze)%n", key, dup.get(key));
		}
		System.out.println("Elementi distinti:");
		for (var e : ex1.getWords()) {
			System.out.println(e);
		}
	}
}
