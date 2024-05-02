package it.epicode.dao;

import it.epicode.entities.Passport;
import it.epicode.entities.Person;
import it.epicode.entities.PersonKey;

public class JpaPersonDao extends JpaBaseDao implements PersonDao {

	@Override
	public void save(Person p) {
		try {
			log.debug("Saving {}", p);
			var t = em.getTransaction();
			t.begin();
			em.persist(p.getPassport());
			em.persist(p.getCity());
			em.persist(p);
			t.commit();
			log.debug("Saved {}", p);
		} catch (Exception e) {
			log.error("Exception saving entity...", e);
		}
	}

	@Override
	public Person getById(PersonKey key) {
		return em.find(Person.class, key);
	}

	@Override
	public Passport getPassport(long id) {
		return em.find(Passport.class, id);
	}

}
