package it.epicode.dao;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.epicode.entities.Event;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaEventDao implements EventDao {

	private static final Logger log = LoggerFactory.getLogger(JpaEventDao.class);
	// Nome della persistence unit nel file persistence.xml
	private static final String PERSISTENCE_UNIT = "Events";

	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
	// L'entity manager utilizzato in tutti i metodi della classe
	private final EntityManager em = emf.createEntityManager();

	@Override
	public void save(Event e) {
		// ottiene una transazione
		var trans = em.getTransaction();
		try {
			// inizia la transazione
			trans.begin();
			// salva l'evento
			em.persist(e);
			// commissiona la transazione
			trans.commit();
		} catch (Exception ex) {
			// se c'è un errore annulla le operazioni sulle tabelle
			trans.rollback();
			log.error("Exception in save(), rolling back transaction", e);
		}
	}

	@Override
	public Optional<Event> getById(long id) {
		// Event.class indica di cercare nella tabella che memorizza Event
		// il secondo parametro è l'id da cercare
		var event = em.find(Event.class, id);
		if (event == null) // se non è stato trovato l'evento...
			return Optional.empty(); // restituisce un Optional vuoto
		// ... altrimenti mette dentro all'Optional l'evento trovato
		return Optional.of(event);
	}

	@Override
	public void delete(Event e) {
		var trans = em.getTransaction();
		try {
			trans.begin();
			em.remove(e);
			trans.commit();
		} catch (Exception ex) {
			trans.rollback();
			log.error("Exception in delete(), rolling back transaction", e);
		}
	}

	@Override
	public void close() throws Exception {
		em.close();
		emf.close();
	}

}
