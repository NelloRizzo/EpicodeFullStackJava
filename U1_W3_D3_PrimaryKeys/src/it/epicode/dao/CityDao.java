package it.epicode.dao;

import it.epicode.entities.City;

public interface CityDao {

	void save(City c);

	City getById(long id);
}
