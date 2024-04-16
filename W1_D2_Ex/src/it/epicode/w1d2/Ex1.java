package it.epicode.w1d2;

public class Ex1 {

	/**
	 * Controlla se una stringa ha lunghezza pari.
	 * 
	 * @param s la stringa da gestire.
	 * @return {@code true} se la stringa a lunghezza pari.
	 */
	public static boolean isStringLengthEven(String s) {
		// if (s.length() % 2 == 0) return true; else return false;
		return s.length() % 2 == 0;
	}

	/**
	 * Controlla se un anno è bisestile.
	 * 
	 * @param year l'anno da controllare.
	 * @return {@code true} se l'anno è bisestile.
	 */
	public static boolean isLeapYear(int year) {
		// anno è bisestile se è divisibile per 4 ma non per 100
		return (year % 4 == 0 && year % 100 != 0)
				// oppure per 400
				|| year % 400 == 0;
	}

	public static void main(String[] args) {
		String s = "Questa è una stringa";
		System.out.println("La lunghezza della stringa <" + s + "> è " + (isStringLengthEven(s) ? "pari" : "dispari"));
		int year = 1900;
		System.out.println("L'anno " + year + (!isLeapYear(year) ? " non " : " ") + "è bisestile");
		year = 2000;
		System.out.println("L'anno " + year + (!isLeapYear(year) ? " non " : " ") + "è bisestile");
		System.out.println("L'anno 2024" + (!isLeapYear(2024) ? " non " : " ") + "è bisestile");
	}

}
