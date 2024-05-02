package it.epicode.dao;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;

import it.epicode.entities.City;
import it.epicode.entities.Province;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Persistence;

@NamedQuery(name = "ALL_CITIES", query = "SELECT c FROM City c")
@NamedQuery(name = "ALL_PROVINCES", query = "SELECT p FROM Province p")
@NamedQuery(name = "ALL_CITIES_BY_PROV", query = "SELECT c FROM City c WHERE c.acronym = :1")
public class JpaCityDao implements CityDao {

	private final String PERSISTENCE_UNIT = "U1_W3_D3";
	private final EntityManager em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT).createEntityManager();

	public static void populate(InputStream s) {
		try (var r = new BufferedReader(new InputStreamReader(s)); var dao = new JpaCityDao()) {
			List<City> cities = r.lines() //
					.skip(3) // salto le prime tre righe
					.map(l -> l.split(";")) // entra la linea esce un array con i campi (separati con ;)
					// .map(a -> a[5] + " (" + a[14] + ")") // prendo solo il 6^ elemento e il 15^
					.map(a -> new City(a[5], a[19], a[13].charAt(0) == '1', new Province(a[11], a[14]))) // creo una
																											// istanza
																											// di classe
																											// City
					.toList() // creo una lista di città!!!!!!
			;

			cities.stream().map(c -> c.getProvince()).distinct().forEach(dao::saveProvince);

		} catch (Exception e) {

		}
	}

	@Override
	public void close() throws Exception {
		em.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<City> getCities(String acronym) {
		return (List<City>) em.createNamedQuery("ALL_CITIES_BY_PROV").setParameter(1, acronym).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<City> getAllCities() {
		return (List<City>) em.createNamedQuery("ALL_CITIES").getResultList();
	}

	@Override
	public Optional<City> getById(long cityId) {
		return Optional.empty();
	}

	@Override
	public void save(City city) {
		var t = em.getTransaction();
		t.begin();
		em.persist(city);
		t.commit();
	}

	@Override
	public void deleteById(long cityId) {
		var t = em.getTransaction();
		t.begin();
		em.remove(em.find(City.class, cityId));
		t.commit();
	}

	@Override
	public void saveProvince(Province province) {
		var t = em.getTransaction();
		t.begin();
		em.persist(province);
		t.commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Province> getProvinces() {
		return (List<Province>) em.createNamedQuery("ALL_PROVINCES").getResultList();
	}

}
