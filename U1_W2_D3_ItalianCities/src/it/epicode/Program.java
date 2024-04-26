package it.epicode;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;

public class Program {

	static final Path file = Path.of("E:/Codice/EpicodeFS0124/Workspace/U1_W2_D3_ItalianCities", //
			"comuni.csv");

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
		List<City> cities = Files.lines(file, StandardCharsets.ISO_8859_1) //
				.skip(3) // salto le prime tre righe
				.map(l -> l.split(";")) // entra la linea esce un array con i campi (separati con ;)
				// .map(a -> a[5] + " (" + a[14] + ")") // prendo solo il 6^ elemento e il 15^
				.map(a -> new City(a[5], a[14], a[11])) // creo una istanza di classe City
				.toList() // creo una lista di città!!!!!!
		;

		var count = cities.stream().count(); // conto quante città ci sono!
		System.out.println("Sono state caricate " + count + " città");

		System.out.println("Province italiane:");
		cities.stream() // apro uno stream sulla lista precedente
				.map(c -> c.getProvince()) // per ogni City recupero la provincia
				.distinct() // escludo i duplicati
				.sorted() // ordino alfabeticamente le stringhe
				.map(s -> s.toUpperCase()).forEach(System.out::println) // stampo le province italiane
		;

		System.out.println("Città in provincia di Roma:");
		cities.stream().filter(c -> c.getAcronym().equals("RM")).sorted().forEach(System.out::println);

		System.out.println("Città organizzate per provincia:");
		cities.stream() // apro lo stream
				.collect(Collectors.groupingBy(c -> c.getProvince())) // raggruppo per provincia in una Map
				.entrySet() // prendo gli elementi della mappa come lista
				.stream() // apro un altro stream
				.sorted(Map.Entry.comparingByKey()) // ordino sulla base della chiave
				.forEach(e -> System.out.format("%-30s\t%d%n", e.getKey(), e.getValue().size()));

		var content = cities.stream() // apro uno stream sulla lista precedente
				.map(c -> c.getProvince()) // per ogni City recupero la provincia
				.distinct() // escludo i duplicati
				.sorted() // ordino alfabeticamente le stringhe
				.map(s -> s.toUpperCase())
				.collect(Collectors.joining("\n", "Elenco delle province italiane:\n", "\nFine."));
		File output = new File("./test.txt");
		//FileUtils.writeStringToFile(output, content);
		var provinces = cities.stream() // apro uno stream sulla lista precedente
				.map(c -> c.getProvince()) // per ogni City recupero la provincia
				.distinct() // escludo i duplicati
				.sorted() // ordino alfabeticamente le stringhe
				.map(s -> s.toUpperCase()).toList();
		FileUtils.writeLines(output, provinces);
	}

}
