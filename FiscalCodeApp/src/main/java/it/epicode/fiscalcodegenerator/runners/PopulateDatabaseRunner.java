package it.epicode.fiscalcodegenerator.runners;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import it.epicode.fiscalcodegenerator.entities.CityEntity;
import it.epicode.fiscalcodegenerator.entities.ProvinceEntity;
import it.epicode.fiscalcodegenerator.services.CityService;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PopulateDatabaseRunner implements CommandLineRunner {

	@Value("${cities.filename}")
	private String resourceFileName;

	@Autowired
	CityService cities;

	@Override
	public void run(String... args) throws Exception {
		if (cities.countCities() == 0) {
			var citiesList = new ArrayList<CityEntity>();
			try {
				log.info("Attempt to load {}", resourceFileName);
				var file = ResourceUtils.getFile(String.format("classpath:%s", resourceFileName));
				try (var reader = new BufferedReader(
						new InputStreamReader(new FileInputStream(file), StandardCharsets.ISO_8859_1))) {
					citiesList.addAll(reader.lines() //
							.skip(3) //
							.map(l -> l.split(";")) //
							.map(a -> CityEntity.builder() //
									.withCadastral(a[19]) //
									.withCapital(a[13].charAt(0) == '1') //
									.withName(a[5]) //
									.withProvince( //
											ProvinceEntity.builder() //
													.withAcronym(a[14]) //
													.withName(a[11]).build())
									.build())
							.toList());
				}
				citiesList.stream().map(CityEntity::getProvince).distinct().forEach(cities::saveProvince);
				citiesList.stream()
						.map(c -> CityEntity.builder().withCadastral(c.getCadastral()).withCapital(c.isCapital())
								.withName(c.getName())
								.withProvince(cities.getProvinceByAcronym(c.getProvince().getAcronym()).orElseThrow())
								.build())
						.forEach(cities::saveCity);

			} catch (FileNotFoundException e) {
				log.error("Input file not found", e);
			} catch (IOException e) {
				log.error("I/O exception reading cities from stream", e);
			}
		}
	}

}
