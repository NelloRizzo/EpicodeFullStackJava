package it.epicode.devicesmanagement.utils;

import java.util.stream.Collectors;

public class Utils {

	public static String purify(String input) {
		return input.toLowerCase().chars().filter(c -> Character.isLetterOrDigit(c) || c == ' ')
				.mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining()).replaceAll(" ", "_");
	}
}
