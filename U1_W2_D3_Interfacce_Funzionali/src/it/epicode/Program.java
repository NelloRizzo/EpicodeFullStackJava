package it.epicode;

public class Program {

	static boolean decidiSeScambiareAsc(int a, int b) {
		return a > b;
	}

	static boolean decidiSeScambiareDesc(int a, int b) {
		return a < b;
	}

	static void sortAsc(int[] a) {
		for (var i = 0; i < a.length - 1; ++i) {
			for (var j = i + 1; j < a.length; ++j) {
				// if (a[i] > a[j]) {
				if (decidiSeScambiareAsc(a[i], a[j])) {
					var temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
	}

	static void sortDesc(int[] a) {
		for (var i = 0; i < a.length - 1; ++i) {
			for (var j = i + 1; j < a.length; ++j) {
				// if (a[i] < a[j]) {
				if (decidiSeScambiareDesc(a[i], a[j])) {
					var temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
	}

	// funzione high order
	static void sort(int[] a, DecidiSeScambiare d) {
		for (var i = 0; i < a.length - 1; ++i) {
			for (var j = i + 1; j < a.length; ++j) {
				// if (a[i] < a[j]) {
				if (d.decidiSeScambiare(a[i], a[j])) {
					var temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
	}

	static void print(int[] a, String message) {
		System.out.println(message);
		for (var i : a)
			System.out.println(i);
	}

	public static void main(String[] args) {
		int[] numbers = { 1423, 7465, 234, 6978, 32, 8790, 2453, 780, 45678, 9 };
		print(numbers, "Array da ordinare:");
		sortAsc(numbers);
		print(numbers, "Array ordinato in senso crescente:");
		sortDesc(numbers);
		print(numbers, "Array ordinato in senso decrescente:");
		sort(numbers, new DecidiSeScambiareAsc());
		print(numbers, "Array ordinato in senso crescente:");
		sort(numbers, new DecidiSeScambiareDesc());
		print(numbers, "Array ordinato in senso decrescente:");
		// implementazione anonima di interfaccia
		sort(numbers, new DecidiSeScambiare() {

			@Override
			public boolean decidiSeScambiare(int a, int b) {
				return a % 2 == 0 ? a > b : a < b;
			}
		});
		print(numbers, "Array ordinato con interfaccia implementata anonimamente:");
		// sort(numbers, (int x, int y) -> { return x > y;} );
		sort(numbers, (int x, int y) -> x > y);
		print(numbers, "Array ordinato con interfaccia implementata anonimamente:");
	}

}
