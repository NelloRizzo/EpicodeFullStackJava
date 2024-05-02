package it.epicode;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.epicode.dao.JpaCityDao;
import it.epicode.dao.JpaPersonDao;
import it.epicode.entities.City;
import it.epicode.entities.Passport;
import it.epicode.entities.Person;
import it.epicode.entities.PersonKey;
import it.epicode.entities.Role;
import it.epicode.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class Program {

	private static final Logger log = LoggerFactory.getLogger(Program.class);

	public static void main(String[] args) {
		var dao = new JpaPersonDao();
		var now = new Date();
		var pp = new Passport("Passaporto di Paperone");
		var topolinia = new City("Topolinia");
		var paperopoli = new City("Paperopoli");

		dao.save(new Person("Paperon", "De' Paperoni", now, paperopoli, "Riccone", pp));
		dao.save(new Person("Archimede", "Pitagorico", now, paperopoli, "Scienziato",
				new Passport("Passaporto di archimede")));
//		try {
//			dao.save(new Person("Archimede", "Pitagorico", now, "Paperinia", "Docente"));
//		} catch (Exception e) {
//			log.error("Chiave duplicata");
//		}

		var pk = new PersonKey("Paperon", "De' Paperoni", now);
		log.debug("Elemento: {}", dao.getById(pk));

		var cityDao = new JpaCityDao();
		cityDao.save(new City("Paperopoli"));
		cityDao.save(new City("Topolinia"));
		pp = dao.getPassport(2);
		log.debug("Proprietario di {} = {}", pp, pp.getOwner());

		var c = cityDao.getById(1);
		log.debug("Persone che abitano a {}", c);
		c.getPeople().stream().forEach(p -> log.debug("{}", p));

		final EntityManager em = Persistence //
				.createEntityManagerFactory("JPA_Sample").createEntityManager();
		var u1 = new User("paperino", "password");
		var u2 = new User("topolino", "password");
		var u3 = new User("paperone", "password");

		var r1 = new Role("admin");
		var r2 = new Role("user");
		var r3 = new Role("editor");

		var t = em.getTransaction();
		t.begin();
		em.persist(u1);
		em.persist(u2);
		em.persist(u3);
		em.persist(r1);
		em.persist(r2);
		em.persist(r3);
		u1.getRoles().add(r1);
		u1.getRoles().add(r2);
		u2.getRoles().add(r3);
		u3.getRoles().add(r2);
		em.persist(u1);
		em.persist(u2);
		em.persist(u3);
		t.commit();

		log.debug("Utente {} -> ruoli:", u1);
		u1.getRoles().forEach(r -> log.debug("{}", r));
		log.debug("Ruolo {} -> utenti:", r3);
		r3.getUsers().forEach(u -> log.debug("{}", u));

		t.begin();
		u1.getRoles().remove(r1);
		em.persist(u1);
		em.remove(r1);
		t.commit();
		em.refresh(r1);
		log.debug("Ruolo eliminato: {}", r1);
	}

}
