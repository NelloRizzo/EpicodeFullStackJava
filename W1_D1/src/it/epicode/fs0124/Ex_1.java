package it.epicode.fs0124;

public class Ex_1 {

	public static int multiply(int a, int b) {
		return a * b;
	}

	public static String concat(String s, int i) {
		return s + i;
	}

	public static String[] insert(String[] input, String s) {
		final String[] result = new String[6];
		for (int i = 0; i < 2; ++i)
			result[i] = input[i];
		result[2] = s;
		for (int i = 3; i < 6; ++i)
			result[i] = input[i - 1];
		return result;
	}

	public static void main(String[] args) {
		int v1 = 10;
		int v2 = 123;
		String str = "Stringa di esempio";
		String[] array = { "Questo", "array", "contiene", "cinque", "elementi" };
		System.out.format("Moltiplicazione: %d x %d = %d\n", v1, v2, multiply(v1, v2));
		System.out.format("Concatenazione: %s\n", concat(str, v2));
		String[] res = insert(array, "questa è la terza stringa");
		System.out.println("Array dopo la concatenazione:");
		for (int i = 0; i < 6; ++i)
			System.out.println("\t" + res[i]);
	}

}
