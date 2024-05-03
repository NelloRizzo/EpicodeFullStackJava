package it.epicode.dao;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.epicode.entities.City;
import it.epicode.entities.Province;
import it.epicode.entities.constants.Queries;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

/**
 * Un DAO per la gestione di città e province attraverso la tecnologia JPA.
 *
 */
public class JpaCityDao implements CityDao {

	private static final Logger log = LoggerFactory.getLogger(JpaCityDao.class);
	private static final String PERSISTENCE_UNIT = "FiscalCodeGenerator";
	private final EntityManager em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT).createEntityManager();

	/**
	 * Legge i dati da uno stream e popola con esso il database.
	 * 
	 * @param s lo stream da cui leggere.
	 */
	public void populate(InputStream s) {
		log.debug("Populating database...");
		try (var r = new BufferedReader(new InputStreamReader(s)); var dao = new JpaCityDao()) {
			List<City> cities = r.lines() //
					.skip(3) // salto le prime tre righe
					.map(l -> l.split(";")) // entra la linea esce un array con i campi (separati con ;)
					.map(a -> new City(a[5], a[19], a[13].charAt(0) == '1', new Province(a[11], a[14]))).toList();
			log.debug("Persisting provinces");
			em.getTransaction().begin();
			cities.stream().map(c -> c.getProvince()).distinct().forEach(em::persist);
			em.getTransaction().commit();
			log.debug("Persisting cities");
			em.getTransaction().begin();
			cities.stream()
					.map(c -> c.setProvince(dao.getProvinceByAcronym(c.getProvince().getAcronym()).orElseThrow()))
					.forEach(em::persist);
			em.getTransaction().commit();
		} catch (Exception e) {
			log.error("Exception populating database", e);
		}
		log.debug("Database populated");
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
	public Optional<City> getCityById(long cityId) {
		try {
			var c = (City) em.createNamedQuery(Queries.Cities.BY_ID).setParameter("id", cityId).getSingleResult();
			return Optional.of(c);
		} catch (Exception ex) {
			log.error("Exception searching city by id", ex);
			return Optional.empty();
		}
	}

	@Override
	public void saveCity(City city) {
		var t = em.getTransaction();
		t.begin();
		em.persist(city);
		t.commit();
	}

	@Override
	public void deleteCityById(long cityId) {
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
		return (List<Province>) em.createNamedQuery(Queries.Provinces.ALL).getResultList();
	}

	@Override
	public Optional<Province> getProvinceByAcronym(String acronym) {
		log.trace("Search for province with acronym = {}", acronym);
		try {
			var p = (Province) em.createNamedQuery(Queries.Provinces.BY_ACRONYM).setParameter("acronym", acronym)
					.getSingleResult();
			return Optional.of(p);
		} catch (Exception ex) {
			log.error("Exception searching province by acronym", ex);
			return Optional.empty();
		}
	}

	@Override
	public long getProvincesCount() {
		return (Long) em.createNamedQuery(Queries.Provinces.COUNT).getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Province> getProvinceBySample(String s) {
		var q = em.createNamedQuery(Queries.Provinces.BY_SAMPLE);
		q.setParameter("sample", s);
		return (List<Province>) q.getResultList();
	}

	@Override
	public long getCitiesCount() {
		return (Long) em.createNamedQuery(Queries.Cities.COUNT).getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Long> getCitiesCountByProvince() {
		var result = new HashMap<String, Long>();
		em.createNamedQuery(Queries.Cities.COUNT_BY_PROVINCE).getResultStream() //
				.forEach(o -> {
					var array = (Object[]) o;
					result.put(array[0].toString(), (Long) array[1]);
				});
		return result;
	}

}
