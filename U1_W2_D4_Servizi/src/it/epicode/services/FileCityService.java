package it.epicode.services;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.epicode.data.City;

public class FileCityService implements CityService {
	private static final Logger logger = LoggerFactory.getLogger(FileCityService.class);
	
	private final ArrayList<City> cities = new ArrayList<>();

	public FileCityService(String file) {
		try {
			cities.addAll( //
					Files.lines(Path.of(file), StandardCharsets.ISO_8859_1) //
							.skip(3) // salto le prime tre righe
							.map(l -> l.split(";")) // entra la linea esce un array con i campi (separati con ;)
							// .map(a -> a[5] + " (" + a[14] + ")") // prendo solo il 6^ elemento e il 15^
							.map(a -> new City(Long.parseLong(a[4]), a[5], a[14], a[11])) // creo una istanza di City
							.toList());
			logger.debug("Sono presenti {} città in archivio", cities.size());
		} catch (IOException e) {
			logger.error("Eccezione leggendo il file delle città", e);
		}
	}

	@Override
	public void addCity(City c) {
		cities.add(c);
	}

	@Override
	public void deleteCity(City c) {
		var city = cities.stream().filter(e -> e.getId() == c.getId()).findAny();
		if (city.isPresent())
			cities.remove(city.get());
	}

	@Override
	public List<City> getCities() {
		return cities.stream().toList();
	}

}
