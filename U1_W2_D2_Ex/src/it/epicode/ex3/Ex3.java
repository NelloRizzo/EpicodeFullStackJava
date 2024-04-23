package it.epicode.ex3;

import java.util.HashMap;
import java.util.Map;

import it.epicode.Executable;

public class Ex3 implements Executable {

	private Map<String, String> catalog = new HashMap<>();

	public void insert(String name, String phone) {
		catalog.put(name, phone);
	}

	public void delete(String name) {
		catalog.remove(name);
	}

	// non conoscendo la chiave dell'elemento a cui corrisponde il telefono
	// devo ciclare su tutti gli elementi
	public boolean deleteByPhone(String phone) {
		boolean found = false;
		String key = null;
		// attraverso le chiavi
		for (var k : catalog.keySet()) {
			// controllo che ci sia un elemento collegato alla chiave
			// e controllo se il numero di telefono collegato alla chiave
			// è uguale al numero di telefono che sto cercando
			if (catalog.get(k) != null && catalog.get(k).equals(phone)) {
				key = k;
				found = true;
			}
		}
		if (found)
			catalog.remove(key);
		return found;
	}

	public void print() {
		System.out.println("Rubrica: ");
		for (var i : catalog.keySet()) {
			System.out.format("%-10s\t%s%n", i, catalog.get(i));
		}
	}

	@Override
	public void execute() {
		System.out.println("Inserimento di elementi in rubrica...");
		catalog.put("paperino", "1313131313");
		catalog.put("paperone", "4444444444");
		catalog.put("archimede", "31415926");
		catalog.put("pico", "0000000");
		print();
		System.out.println("Eliminazione per nome = 'paperino'");
		// cerco l'elemento con chiave paperino
		var i = catalog.get("paperino");
		// se non esiste
		if (i == null)
			// errore
			System.out.println("Elemento non trovato");
		else
			// se esiste lo rimuovo
			catalog.remove("paperino");
		print();

		System.out.println("Eliminazione per numero di telefono = '0000000'");
		if (!deleteByPhone("0000000"))
			System.out.println("Elemento non trovato");
		print();
	}

}
