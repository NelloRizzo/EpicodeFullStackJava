package it.epicode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Program {

	static void showMap(Map<String, Integer> items) {
		System.out.println("Metodo imperativo:");
		for (var i : items.keySet()) {
			System.out.format("%s -> %d%n", i, items.get(i));
		}
	}

	public static void main(String[] args) {
		var ages = new HashMap<String, Integer>();
		ages.put("Paperino", 50);
		ages.put("Topolino", 60);
		ages.put("Paperone", 80);
		showMap(ages);

		ages.replaceAll((n, a) -> n.startsWith("P") ? a : a + 10);

		System.out.println("Metodo dichiarativo:");
		ages.forEach((n, a) -> System.out.format("%s -> %d%n", n, a));

		var numbers = IntStream.range(0, 100);
		numbers = numbers.filter(n -> n % 2 == 0);
		var trans = numbers.mapToObj(n -> String.format("Numero = %d", n));
		// var list = trans.toList();
		trans.forEach(s -> System.out.println(s));

		var list = new ArrayList<Integer>();
		list.addAll(Arrays.asList(3421, 2354, 75346, 4657, 374, 4867));

		var s = list.stream() //
				.filter(n -> n % 2 != 0) //
				.map(n -> String.format("Numero dispari = %d", n)) //
		;

		list.add(12315643);
		list.add(345123);
		list.remove(3);

		s.forEach(n -> System.out.println(n));
		//s.forEach(System.out::println);
	}

}
