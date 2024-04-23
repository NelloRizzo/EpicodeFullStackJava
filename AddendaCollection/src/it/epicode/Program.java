package it.epicode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

public class Program {

	public static final Random rnd = new Random(100);

	public static <T> void handleCollection(Collection<T> collection) {
		System.out.println("Gestione di Collection");
		int size = collection.size();
		System.out.println("Totale elementi: " + size);
	}

	public static <T> void navigate(Iterable<T> collection) {
		System.out.println("Attraversamento della collection:");
//		for (var item : collection) {
//			System.out.println(item);
//		}
		var iterator = collection.iterator();
		while (iterator.hasNext())
			System.out.println(iterator.next());
	}

	// supponiamo di voler creare una lista
	// che contenga tutti gli elementi della collection
	// inferiori a una soglia
	public static ArrayList<Integer> find(Collection<Integer> collection, int target) {
		var result = new ArrayList<Integer>();
		for (var item : collection) {
			if (item < target) {
				result.add(item);
			}
		}
		return result;
	}

	public static void wrapperSamples() {
		boolean b = true;
		Boolean bool = b;

		char c = 'A';
		Character ch = c;
		if (Character.isAlphabetic('a'))
			System.out.println("a è alfabetico");
		if (!Character.isDigit('a'))
			System.out.println("a non è una cifra");
		if (Character.isJavaIdentifierPart('à'))
			System.out.println("à non è parte di un identificatore Java");

		byte bt = 8; // -128 - 127
		Byte by = bt;

		short s = 1; // 16bit 32768/2
		Short sh = s;

		int i = 1;
		Integer in = i;
		in = Integer.parseInt("1234");
		i = in;
		String str = in.toString();

		long l = 1;
		Long lo = Long.parseLong("124312435345133");

		float f = 1.0f;
		Float fl = f;

		double d = 1.0;
		Double db = d;
	}

	public static void StringsSamples() {
		String test = "Questa è una stringa";
		for (int i = 0; i < test.length(); ++i)
			System.out.println(test.charAt(i));
		System.out.println(test.toUpperCase());
		System.out.println(test.toLowerCase());
		System.out.println(test.substring(3, 8));
		System.out.println(test.repeat(5));
		System.out.println(test //
				.replaceAll("una stringa", "un testo") //
				.replaceAll("Questa", "Questo"));
		test = "Altra Stringa";
		// regular expression
		System.out.println(test.replaceAll("[aeiou]", "X"));
		System.out.println(test.indexOf("ring"));
		System.out.println(test.indexOf("non c'è"));
	}

	public static void main(String[] args) {
		var list = new ArrayList<Integer>();
		var set = new HashSet<Integer>();
		for (var i = 0; i < 10; ++i) {
			var n = rnd.nextInt(0, 10);
			list.add(n);
			set.add(n);
		}
		handleCollection(list);
		handleCollection(set);
		navigate(list);
		navigate(set);
		System.out.println("Ricerca all'interno di collection:");
		for (var item : find(list, 5)) {
			System.out.println(item);
		}

		System.out.println("Rimozione:");
		list.remove(8);
		for (var item : list) {
			System.out.println(item);
		}

		wrapperSamples();
		StringsSamples();
	}

}
