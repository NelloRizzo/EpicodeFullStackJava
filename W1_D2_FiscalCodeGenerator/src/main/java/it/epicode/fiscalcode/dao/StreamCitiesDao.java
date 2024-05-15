package it.epicode.fiscalcode.dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import it.epicode.fiscalcode.entities.City;
import it.epicode.fiscalcode.entities.Province;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class StreamCitiesDao implements CitiesDao {

	private final List<City> cities = new ArrayList<>();

	public StreamCitiesDao(@Value("${cities.filename}")String resourceFileName) {
		try {
			log.info("Attempt to load {}", resourceFileName);
			var file = ResourceUtils.getFile(String.format("classpath:%s", resourceFileName));
			try (var reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
				cities.addAll(reader.lines() //
						.skip(3) //
						.map(l -> l.split(";")) //
						.map(a -> City.builder() //
								.withCadastral(a[19]) //
								.withCapital(a[13].charAt(0) == '1') //
								.withId(Long.parseLong(a[4])) //
								.withName(a[5]) //
								.withProvince( //
										Province.builder() //
												.withAcronym(a[14]) //
												.withId(Long.parseLong(a[2])) //
												.withName(a[11]).build())
								.build())
						.toList());
			}
		} catch (FileNotFoundException e) {
			log.error("File not found creating DAO for cities", e);
		} catch (IOException e) {
			log.error("I/O exception reading cities from stream", e);
		}
	}

	@Override
	public Optional<City> getCityByNameAndProvinceAcronym(String name, String acronym) {
		return cities.stream().filter(c -> c.getName().equals(name) && c.getProvince().getAcronym().equals(acronym))
				.findAny();
	}

}
