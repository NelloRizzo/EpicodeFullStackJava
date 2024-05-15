package it.epicode.fiscalcode.dao;

import java.util.Optional;

import it.epicode.fiscalcode.entities.City;

public interface CitiesDao {
	Optional<City> getCityByNameAndProvinceAcronym(String name, String acronym);
}
