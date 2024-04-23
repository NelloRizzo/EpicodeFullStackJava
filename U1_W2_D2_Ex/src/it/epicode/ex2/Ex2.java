package it.epicode.ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import it.epicode.Executable;

public class Ex2 implements Executable {

	private final Random rnd = new Random(1234);

	public List<Integer> randomList(int n) {
		// costruisce la lista
		var result = new ArrayList<Integer>();
		// aggiunge n numeri casual
		for (var i = 0; i < n; ++i) {
			result.add(rnd.nextInt(100));
		}
		// restituisce la lista per un utilizzo
		return result;
	}

	public List<Integer> zigzag(List<Integer> origin) {
		var result = new ArrayList<Integer>();
		for (var i : origin) {
			// aggiunge in posizione 0
			result.add(0, i);
			// aggiunge in coda
			result.add(i);
		}
		return result;
	}

	public void print(List<Integer> items) {
		print(items, true, true);
	}

	public void print(List<Integer> items, boolean odds, boolean even) {
		System.out.print("Lista di elementi");
		if (even)
			System.out.print(" pari");
		if (odds && even)
			System.out.print(" e");
		if (odds)
			System.out.print(" dispari");
		System.out.println(":");
		int count = 0;
		for (var i : items) {
			// se la posizione è pari count % 2 == 0
			// ed abbiamo chiesto di stampare i pari even == true
			if (count % 2 == 0 && even)
				// stampo il numero in posizione pari
				System.out.format("%d. %d%n", count++, i);
			else
			// stessa cosa per i dispari
			if (count % 2 != 0 && odds)
				System.out.format("%d. %d%n", count++, i);
		}
	}

	@Override
	public void execute() {
		System.out.println("Prima parte:");
		var l = randomList(10);
		print(l);
		System.out.println("Seconda parte:");
		l = zigzag(l);
		print(l);
		System.out.println("Terza parte:");
		print(l, true, false);
	}
}
