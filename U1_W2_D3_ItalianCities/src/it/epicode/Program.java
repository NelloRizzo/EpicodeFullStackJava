package it.epicode;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Program {

	static final Path file = Path.of("E:/Codice/EpicodeFS0124/Workspace/U1_W2_D3_ItalianCities", //
			"comuni.csv");

	public static void main(String[] args) throws IOException {
		List<City> cities = Files.lines(file, StandardCharsets.ISO_8859_1) //
				.skip(3) // salto le prime tre righe
				.map(l -> l.split(";")) // entra la linea esce un array con i campi (separati con ;)
				// .map(a -> a[5] + " (" + a[14] + ")") // prendo solo il 6^ elemento e il 15^
				.map(a -> new City(a[5], a[14])) // creo una istanza di classe City
				.toList() // creo una lista di città!!!!!!
		;

		var count = cities.stream().count(); // conto quante città ci sono!
		System.out.println("Sono state caricate " + count + " città");

		System.out.println("Province italiane:");
		cities.stream() // apro uno stream sulla lista precedente
				.map(c -> c.getAcronym()) // per ogni City recupero la sigla
				.distinct() // escludo i duplicati
				.sorted() // ordino alfabeticamente le stringhe
				.forEach(System.out::println) // stampo le province italiane
		;

		System.out.println("Città in provincia di Roma:");
		cities.stream().filter(c -> c.getAcronym().equals("RM")).forEach(System.out::println);
	}

}
