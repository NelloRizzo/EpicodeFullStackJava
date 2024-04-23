package it.epicode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Program {

	private static <E> void print(Collection<E> c, String message) {
		System.out.println(message);
		// enhanced for
		for (E name : c) {
			System.out.println(name);
		}
	}

	public static class My {
		int value;
		String s;

		public My(int value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "" + value + " " + s;
		}
	}

	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		names.add("Paperino");
		names.add("Paperone");
		names.add(1, "Topolino");
		names.add("Paperino");
		print(names, "ArrayList:");

		Deque<String> q = new LinkedList<>();
		q.offer("Paperino");
		q.offer("Paperone");
		q.offer("Topolino");
		q.offer("Paperino");
		System.out.println("Modifica del contenuto?");
		for (String name : q) {
			name += "10";
			System.out.println(name);
		}
		print(q, "Coda:");

		ArrayList<My> mines = new ArrayList<>();
		mines.add(new My(10));
		mines.add(new My(20));
		for (My m : mines) {
			m.value += 100;
			m.s = "Ciao";
		}
		print(mines, "Array di mines:");

		// Mappa con chiave Integer e dato di tipo String
		Map<Integer, String> mis = new HashMap<>();
		// associa alla chiave 5 il valore "Uno"
		mis.put(5, "Uno");
		// associa alla chiave 2 il valore "Due"
		mis.put(2, "Due");
		// attraversa la collection delle chiavi lette da keySet()
		for (Integer i : mis.keySet()) {
			// il metodo get recupera il valore associato alla chiave i
			System.out.println(mis.get(i));
		}
		// modifica un dato della mappa
		mis.put(2, "DUE");
		// recupera tutti i valori nella mappa
		for(String i: mis.values()) {
			System.out.println(i);
		}
		
		Map<String, Integer> msi = new HashMap<>();
		msi.put("Uno", 1);
		msi.put("Due", 2);
		System.out.println(msi.get("Uno"));
	}

}
