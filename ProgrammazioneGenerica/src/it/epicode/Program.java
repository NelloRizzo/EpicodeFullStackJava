package it.epicode;

import java.time.LocalDate;

public class Program {

//	public static void printArray(int[] a) {
//		for (int i = 0; i < a.length; ++i) {
//			int e = a[i];
//			System.out.println(e);
//		}
//	}
//
//	public static void printArray(String[] a) {
//		for (int i = 0; i < a.length; ++i) {
//			String e = a[i];
//			System.out.println(e);
//		}
//	}

	public static <T> void printArray(T[] a) {
		for (int i = 0; i < a.length; ++i) {
			T e = a[i];
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		int a = 1;
		Integer a1 = a;

		Integer[] n = { 452, 26533, 765, 467, 235, 7890, 7809, 45236, 859, 435786 };
		System.out.println("Array da stampare:");
		printArray(n);
		String[] names = { "Paperino", "Paperone", "Archimede", "Gastone" };
		System.out.println("Array di stringhe:");
		printArray(names);
		Object[] obj = { 10, "Pippo", LocalDate.now() };
		System.out.println("Array di qualsiasi cosa:");
		printArray(obj);
		
		Pair<String,Integer> psi = new Pair<String,Integer>("Pluto", 10);
		//psi.first = 1.45;
		Pair<Integer, String> pis = new Pair<>(10, "Paperino");
		//pis.first = "Pluto";
		System.out.println(psi);
		System.out.println(pis);
	}

}
