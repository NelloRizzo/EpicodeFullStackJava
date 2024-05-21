package it.epicode.fiscalcodegenerator.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import it.epicode.fiscalcodegenerator.entities.CityEntity;
import it.epicode.fiscalcodegenerator.entities.ProvinceEntity;
import it.epicode.fiscalcodegenerator.repositories.CitiesRepository;
import it.epicode.fiscalcodegenerator.repositories.ProvincesRepository;

@Service
public class JpaCityService implements CityService {

	@Autowired
	private CitiesRepository cities;

	@Autowired
	private ProvincesRepository provinces;

	@Override
	public Optional<CityEntity> saveCity(CityEntity city) {
		return Optional.of(cities.save(city));
	}

	@Override
	public Optional<ProvinceEntity> saveProvince(ProvinceEntity province) {
		return Optional.of(provinces.save(province));
	}

	@Override
	public int saveCities(Iterable<CityEntity> cities) {
		return this.cities.saveAll(cities).size();
	}

	@Override
	public List<CityEntity> getCitiesByAcronym(String acronym) {
		return cities.findAllByProvinceAcronymIgnoreCase(acronym);
	}

	@Override
	public Page<CityEntity> search(String nameLike, Pageable pageable) {
		return cities.findAllByNameLike(nameLike, pageable);
	}

	@Override
	public List<ProvinceEntity> getProvinces() {
		return provinces.findAll(Sort.by("acronym"));
	}

	@Override
	public long countCities() {
		return cities.countCities();
	}

	@Override
	public Optional<ProvinceEntity> getProvinceByAcronym(String acronym) {
		return provinces.findOneByAcronym(acronym);
	}

	@Override
	public Optional<CityEntity> getCityByNameAndAcronym(String name, String acronym) {
		return cities.findOneByNameAndProvinceAcronym(name, acronym);
	}

	@Override
	public Optional<CityEntity> getCityById(long birthCityId) {
		return cities.findById(birthCityId);
	}

}
