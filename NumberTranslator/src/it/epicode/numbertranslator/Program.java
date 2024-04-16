package it.epicode.numbertranslator;

public class Program {

	/**
	 * Traduce in stringa il numero in input.
	 * 
	 * @param number il numero da tradurre
	 * @return la rappresentazione come stringa del numero.
	 */
	public static String translate(int number) {
		// se il numero è 0
		if (number == 0)
			// restituisce "zero"
			return "zero";
		// se il numero è negativo
		if (number < 0)
			// restituisce "meno" + la traduzione dell'opposto!
			return "meno " + translate(-number);
		// effettua la traduzione degli altri numeri
		return translate1000(number).replace("au", "u") //
				.replace("ao", "o") //
				.replace("oo", "o");
	}

	/**
	 * Traduce i numeri da 1 a 20.
	 * 
	 * @param number il numero da tradurre.
	 * @return la stringa che rappresenta quel numero.
	 */
	public static String translate20(int number) {
		// se il numero è 0 non traduce nulla
		if (number == 0)
			return "";
		// non può tradurre numeri più alti di 20!
		if (number > 19)
			return "Fuori dai limiti";
		// i numeri da 1 a 20 si traducono con una tabella...
		String[] to20 = { "uno", "due", "tre", "quattro", "cinque", "sei", "sette", "otto", "nove", "dieci", "undici",
				"dodici", "tredici", "quattordici", "quindici", "sedici", "diciassette", "diciotto", "diciannove" };
		return to20[number - 1];
	}

	/**
	 * Traduce i numeri da 20 a 100 (escluso).
	 * 
	 * @param number il numero da tradurre.
	 * @return la stringa che rappresenta quel numero.
	 */
	public static String translate100(int number) {
		if (number > 99)
			return "Fuori dai limiti";
		if (number < 20)
			return translate20(number);
		// tutte le decine
		String[] dec = { "venti", "trenta", "quaranta", "cinquanta", "sessanta", "settanta", "ottanta", "novanta" };
		int d = number / 10; // la decina
		int u = number % 10; // l'unità
		// prende la decina dalle decine e l'unità dal metodo precedente
		return dec[d - 2] + translate20(u);
	}

	public static String translate1000(int number) {
		if (number > 999)
			return "Fuori dai limiti";
		if (number < 100)
			return translate100(number);
		int t = number / 100;
		int d = number % 100;
		if (t == 1)
			return "cento" + translate100(d);
		else
			return translate20(t) + "cento" + translate100(d);
	}

	public static void main(String[] args) {
		for (int i = 0; i < 1000; ++i) {
			System.out.println(i + " -> " + translate(i));
		}

	}

}
