package it.epicode.w2d2;

public class Program {

	/**
	 * Stampa la tabellina di un numero.
	 * 
	 * @param n il numero per il quale stampare la tabellina.
	 */
	public static void tab(int n) {
		System.out.println("Tabellina del " + n);
		// dobbiamo contare da 1 a 10
		for (int counter = 1; counter <= 10; ++counter) {
			// per ogni valore contato dobbiamo moltiplicare per n
			int value = counter * n;
			// e stampare a video
			System.out.println("" + n + " x " + counter + " = " + value);
		}
	}

	public static void main(String[] args) {
		int a = 1;
		int b = ++a + 2; // notazione prefissa: prima viene incrementato a

		int c = 1;
		int d = c++ + 2; // notazione postfissa: c viene incrementato dopo
		System.out.println("Valori: a = " + a + " b = " + b + " c = " + c + " d = " + d);

		tab(7);
	}

}
