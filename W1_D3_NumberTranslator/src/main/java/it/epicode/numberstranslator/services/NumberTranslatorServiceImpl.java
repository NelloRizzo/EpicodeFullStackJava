package it.epicode.numberstranslator.services;

import org.springframework.stereotype.Component;

import it.epicode.numberstranslator.services.exceptions.OutOfRangeException;

@Component
public class NumberTranslatorServiceImpl implements NumberTranslatorService {

	@Override
	public String translate(int number) {
		// 1. se il numero è 0
		if (number == 0)
			// 1.1 produco in output "zero"
			return "zero";
		// 2. se il numero è negativo
		if (number < 0)
			// 2.1 produco in output "meno" e considero la traduzione del numero come
			// positivo
			return "meno " + translate(-number);
		// 3. qui sono sicuro di star traducendo un numero positivo

		// fino a quanto voglio arrivare per tradurre?
		int max = 999999;
		// diamoci un limite massimo
		if (number > max)
			// superato il quale non forniamo traduzione
			throw new OutOfRangeException(number);
		return translateTo999999(number) //
				.replaceAll("iu", "u") //
				.replaceAll("au", "u") //
				.replaceAll("ao", "o") //
		;
	}

	private String translateTo19(int number) {
		String[] names = { "", "uno", "due", "tre", "quattro", "cinque", "sei", "sette", "otto", "nove", "dieci",
				"undici", "dodici", "tredici", "quattordici", "quindici", "sedici", "diciassette", "diciotto",
				"diciannove" };
		return names[number];
	}

	private String translateTo99(int number) {
		if (number < 20)
			return translateTo19(number);
		var d = number / 10; // decine
		var u = number % 10; // unità
		String[] names = { "venti", "trenta", "quaranta", "cinquanta", "sessanta", "settanta", "ottanta", "novanta" };
		return names[d - 2] + translateTo19(u);
	}

	private String translateTo999(int number) {
		if (number < 100)
			return translateTo99(number);
		var h = number / 100; // le centinaia
		var d = number % 100; // le decine
		// se h = 1 -> sono nel caso "cento", altrimenti sono nel caso in cui
		// h vale 2,3,4,5,6 -> duecento, trecento...
		var result = (h == 1) ? "cento" : translateTo19(h) + "cento";
		return result + translateTo99(d);
	}

	private String translateTo999999(int number) {
		if (number < 1000)
			return translateTo99(number);
		var t = number / 1000; // le migliaia
		var h = number % 1000; // le centinaia
		var result = (t == 1) ? "mille" : translateTo999(t) + "mila";
		return result + translateTo999(h);
	}
}
