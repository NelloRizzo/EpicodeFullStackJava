package it.epicode.dao;

import it.epicode.entities.City;

public class JpaCityDao extends JpaBaseDao implements CityDao {

	@Override
	public void save(City c) {
		try {
			log.debug("Saving {}", c);
			var t = em.getTransaction();
			t.begin();
			em.persist(c);
			log.debug("Before commit {}", c);
			t.commit();
			log.debug("After commit {}", c);
		} catch (Exception e) {
			log.error("Exception saving entity...", e);
		}
	}

	@Override
	public City getById(long id) {
		return em.find(City.class, id);
	}

}
