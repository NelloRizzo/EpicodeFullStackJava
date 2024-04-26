package it.epicode.services;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.epicode.data.City;

public class FileCityService implements CityService {
	private static final Logger logger = LoggerFactory.getLogger(FileCityService.class);

	private final ArrayList<City> cities = new ArrayList<>();

	private static final String STORAGE = "./cities.my";

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

	public FileCityService() {
		load();
	}

	public void save() {
		File f = new File(STORAGE);
		try {
			FileUtils.delete(f);
		} catch (IOException e) {
			logger.error("Eccezione durante l'eliminazione del file di storage", e);
		}
		cities.stream().forEach(c -> {
			try {
				var lines = Arrays.asList(c.getId().toString(), c.getAcronym(), c.getName(), c.getProvince());
				FileUtils.writeLines(f, StandardCharsets.ISO_8859_1.name(), lines, true);
			} catch (IOException e) {
				logger.error("Eccezione durante il salvataggio", e);
			}
		});
	}

	private void load() {
		File f = new File(STORAGE);
		try {
			var l = FileUtils.readLines(f, StandardCharsets.ISO_8859_1);
			for (int i = 0; i < l.size(); i += 4) {
				cities.add( //
						new City( //
								Long.parseLong(l.get(i)), //
								l.get(i + 2), //
								l.get(i + 1), //
								l.get(i + 3)));
			}
		} catch (IOException e) {
			logger.error("Eccezione durante il caricamento", e);
		}
	}

	@Override
	public void addCity(City c) {
		cities.add(c);
		save();
	}

	@Override
	public void deleteCity(City c) {
		var city = cities.stream().filter(e -> e.getId() == c.getId()).findAny();
		if (city.isPresent()) {
			cities.remove(city.get());
			save();
		}
	}

	@Override
	public List<City> getCities() {
		return cities.stream().toList();
	}

}
