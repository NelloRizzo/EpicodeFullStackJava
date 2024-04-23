package it.epicode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Program {

	static class My {
		String s;
		int value;

		My(int value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "" + value;
		}
		@Override
		public boolean equals(Object obj) {
			return obj instanceof My && obj.hashCode() == this.hashCode();
		}
		@Override
		public int hashCode() {
			return Objects.hash(value, s);
		}
	}

	public static void main(String[] args) {
		System.out.println("Integers:");
		Set<Integer> s = new HashSet<>();
		s.add(1);
		s.add(2);
		s.add(3);
		s.add(1);

		for (Integer i : s) {
			System.out.println(i);
		}
		System.out.println("My");
		Set<My> mines = new HashSet<>();
		mines.add(new My(1));
		mines.add(new My(2));
		mines.add(new My(3));
		mines.add(new My(1));
		for (My m : mines) {
			System.out.println(m);
		}
		
		Map<My, String > mms = new HashMap<>();
		mms.put(new My(10), "Dieci");
		System.out.println(mms.get(new My(10)));
	}
}
