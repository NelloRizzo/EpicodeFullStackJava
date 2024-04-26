package it.epicode.services;

import java.util.List;

import it.epicode.data.City;

public interface CityService {
	void addCity(City c);
	void deleteCity(City c);
	List<City> getCities();
}
