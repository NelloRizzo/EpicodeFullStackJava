package it.epicode.dao;

import java.util.List;
import java.util.Optional;

import it.epicode.entities.City;
import it.epicode.entities.Province;

public interface CityDao extends AutoCloseable {
	List<City> getCities(String acronym);

	List<City> getAllCities();

	Optional<City> getById(long cityId);

	void save(City city);

	void deleteById(long cityId);

	void saveProvince(Province province);

	List<Province> getProvinces();

}
