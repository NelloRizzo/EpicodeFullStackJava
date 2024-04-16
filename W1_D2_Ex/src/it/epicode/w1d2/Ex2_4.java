package it.epicode.w1d2;

import java.util.Scanner;

public class Ex2_4 {

	/**
	 * Esercizio #2.
	 * 
	 * @param n il numero da testare.
	 */
	public static void _switch(int n) {
		switch (n) {
		case 0:
			System.out.println("zero");
			break;
		case 1: {
			System.out.println("uno");
			break;
		}
		case 2:
			System.out.println("due");
			break;
		case 3:
			System.out.println("tre");
			break;
		case 4: // fallthrough
			System.out.println("quattro");
		case 5:
			System.out.println("quattro o cinque");
			break;
		case 6:
		case 7:
		case 8:
			System.out.println("sei sette o otto");
			break;
		default:
			System.out.println("fuori dai limiti");
		}
	}

	/**
	 * Stampa i caratteri di una stringa separandoli con una virgola.
	 * 
	 * @param s la stringa gestita.
	 */
	public static void printChars(String s) {
		int len = s.length();
		System.out.print("[");
		for (int i = 0; i < len; i++) {
			System.out.print(s.charAt(i));
			if (i != len - 1)
				System.out.print(", ");
		}
		System.out.println("]");
	}

	/**
	 * Esercizio #3.
	 */
	public static void separateStrings() {
		final String end = ":q";
		String s;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.print("Inserisci una stringa: ");
			s = scanner.nextLine();
			if (!s.equals(end)) // (s == end)
				printChars(s);
		} while (!s.equals(end));
	}

	/**
	 * Esercizio # 4.
	 * 
	 * @param from il numero da cui parte il conteggio.
	 */
	public static void countdown(int from) {
		System.out.println("Start countdown");
		for (int i = from; i > -1; --i) {
			System.out.println(i);
		}
		System.out.println("Stop!");
	}

	public static void main(String[] args) {
		String s1 = "Ciao";
		String s2 = String.join("", "C", "ia", "o");
		System.out.println("s1 = " + s1);
		System.out.println("s2 = " + s2);
		if (s1.equals(s2)) // (s1 == s2) => FALLISCE!!!
			System.out.println("Uguali");
		else
			System.out.println("Diverse");
		for (int i = 0; i < 9; ++i)
			_switch(i);
		separateStrings();
		countdown(10);
	}

}
