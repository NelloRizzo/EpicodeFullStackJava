package it.epicode.dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import it.epicode.entities.City;
import it.epicode.entities.Province;

/**
 * DAO per la gestione di città e province.
 */
public interface CityDao extends AutoCloseable {
	/**
	 * Recupera tutte le città in una provincia.
	 * 
	 * @param acronym la sigla della provincia.
	 * @return tutte le città nella provincia passata come parametro.
	 */
	List<City> getCities(String acronym);

	/**
	 * @return l'elenco di tutte le città.
	 */

	List<City> getAllCities();

	/**
	 * Cerca una città a partire dal proprio {@code id}.
	 * 
	 * @param cityId l'{@code id} della città.
	 * @return la città corrispondente all'{@code id} passato come parametro o un
	 *         {@code Optional.empty()}.
	 */
	Optional<City> getCityById(long cityId);

	/**
	 * Salva i dati di una città.
	 * 
	 * @param city i dati da salvare.
	 */
	void saveCity(City city);

	/**
	 * Elimina una città.
	 * 
	 * @param cityId l'{@code id} della città da eliminare.
	 */
	void deleteCityById(long cityId);

	/**
	 * Salva i dati di una provincia.
	 * 
	 * @param province i dati della provincia.
	 */
	void saveProvince(Province province);

	/**
	 * Recupera una provincia a partire dalla sigla.
	 * 
	 * @param acronym la sigla della provincia.
	 * @return la provincia corrispondente o un {@code Optional.empty()} se non
	 *         esiste
	 */
	Optional<Province> getProvinceByAcronym(String acronym);

	/**
	 * Recupera una lista di province con una ricerca sul nome.
	 * 
	 * @param sample il pattern da usare nella ricerca (sintassi dell'operatore
	 *               {@code LIKE}.
	 * @return l'elenco delle province il cui nome corrisponde al parametro.
	 */
	List<Province> getProvinceBySample(String sample);

	/**
	 * @return il numero di province presenti nel database.
	 */
	long getProvincesCount();

	/**
	 * @return l'elenco di tutte le province.
	 */
	List<Province> getProvinces();

	long getCitiesCount();

	Map<String, Long> getCitiesCountByProvince();

}
