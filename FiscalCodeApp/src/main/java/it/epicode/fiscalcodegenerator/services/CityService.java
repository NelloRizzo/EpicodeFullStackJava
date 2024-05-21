package it.epicode.fiscalcodegenerator.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.epicode.fiscalcodegenerator.entities.CityEntity;
import it.epicode.fiscalcodegenerator.entities.ProvinceEntity;

public interface CityService {

	Optional<CityEntity> saveCity(CityEntity city);

	Optional<ProvinceEntity> saveProvince(ProvinceEntity province);

	int saveCities(Iterable<CityEntity> cities);

	List<CityEntity> getCitiesByAcronym(String acronym);

	Page<CityEntity> search(String nameLike, Pageable pageable);

	List<ProvinceEntity> getProvinces();

	Optional<ProvinceEntity> getProvinceByAcronym(String acronym);

	Optional<CityEntity> getCityByNameAndAcronym(String name, String acronym);

	long countCities();

	Optional<CityEntity> getCityById(long birthCityId);
}
