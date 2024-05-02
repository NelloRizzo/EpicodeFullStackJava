package it.epicode.dao.implementations;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.epicode.dao.Dao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public abstract class JpaDao<T> implements Dao<T> {

	private static final Logger log = LoggerFactory.getLogger(JpaDao.class);
	// Nome della persistence unit nel file persistence.xml
	private static final String PERSISTENCE_UNIT = "Events";

	protected final EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
	// L'entity manager utilizzato in tutti i metodi della classe
	protected final EntityManager em = emf.createEntityManager();

	protected Class<?> type;

	public JpaDao(Class<T> type) {
		this.type = type;
		log.debug("Type is {}", type);
	}

	@Override
	public T save(T e) {
		// ottiene una transazione
		var trans = em.getTransaction();
		try {
			// inizia la transazione
			trans.begin();
			// salva l'evento
			em.persist(e);
			// commissiona la transazione
			trans.commit();
			// restituisce l'entità appena salvata
			return e;
		} catch (Exception ex) {
			// se c'è un errore annulla le operazioni sulle tabelle
			trans.rollback();
			log.error("Exception in save(), rolling back transaction", e);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Optional<T> getById(long id) {
		// Event.class indica di cercare nella tabella che memorizza Event
		// il secondo parametro è l'id da cercare

		var e = em.find(type, id);
		if (e == null) // se non è stato trovato l'evento...
			return Optional.empty(); // restituisce un Optional vuoto
		// ... altrimenti mette dentro all'Optional l'evento trovato
		return Optional.of((T) e);
	}

	@Override
	public void delete(T e) {
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
